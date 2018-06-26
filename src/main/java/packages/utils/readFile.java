package packages.utils;

import java.io.*;
import java.util.*;

public class readFile
{
    public static void  simulateFile(String filename) throws IOException
    {
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = "";
            if (line != null)
            {
                while((line = reader.readLine()) != null)
                {
                    String [] heroDes = line.split(",");                
                    System.out.println(line);
                }
            }
        }catch(IOException e)
        {
            System.out.println("Cannot find file" + e);
        }
    
    }
}
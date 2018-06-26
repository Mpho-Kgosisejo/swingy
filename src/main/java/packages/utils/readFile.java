package packages.utils;

import java.io.*;
import java.util.*;
import packages.storage;
import packages.storage.HeroType;

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
                    Hero(heroDes[0].toString(), HeroType.values()heroDes[1],Integer.parseInt(heroDes[2]),
                    Integer.parseInt(heroDes[3]), heroDes[4].toString(), heroDes[5].toString());
                    System.out.println(line);
                }
            }
        }catch(IOException e)
        {
            System.out.println("Cannot find file" + e);
        }
    
    }
}
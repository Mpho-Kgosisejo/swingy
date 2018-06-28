package packages.utils;

import java.io.*;
import java.util.*;
import packages.storage.Hero;
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
                    
                    //Hero.newHero(line.split(",")[0],line.split(",")[1], Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]), line.split(",")[4], line.split(",")[5]);
                    System.out.println(line);
                }
            }
        }catch(IOException e)
        {
            System.out.println("Cannot find file" + e);
        }
    
    }
}
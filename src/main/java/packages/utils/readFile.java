package packages.utils;

import java.io.*;
import java.util.*;
import packages.interfaces.IHero;
import packages.models.HeroModel;
import packages.models.WarriorModel;;

public class readFile
{
    public static List<HeroModel>  simulateFile(String filename) throws IOException
    {
        List<HeroModel> heroList = new ArrayList<HeroModel>();

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = "";
            if (line != null)
            {
                while((line = reader.readLine()) != null)
                {   
<<<<<<< HEAD
                    try 
                    {
                        HeroModel iHero = HeroFactory.newHero(line.split(",")[0],line.split(",")[1], Integer.parseInt(line.split(",")[2]), Integer.parseInt(line.split(",")[3]), line.split(",")[4], line.split(",")[5]);
                        heroList.add(iHero);
                        
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("eh eh eh");;
                    }
                    //System.out.println(line);
=======
                    
                    //Hero.newHero(line.split(",")[0],line.split(",")[1], Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]), line.split(",")[4], line.split(",")[5]);
                    System.out.println(line);
>>>>>>> 59489f2b61d9b5b88027c89033061e01627f4c92
                }
            }
        }catch(IOException e)
        {
            System.out.println("Cannot find file" + e);
        }
        return (heroList);
    }
}
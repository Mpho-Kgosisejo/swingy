package packages.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import packages.models.HeroModel;

public class UpdateFile
{
    //private static int     _level;
    //private static int     _xPoints;    
    private static String  _replacor = null;    
    private static String  _line = null;
    
    public static void findAndReplace(HeroModel hero)
    {
        try
        {
            File file = new File("test.txt");
            FileReader reader = new FileReader(file);
            BufferedReader buffR = new BufferedReader(reader);

            while ((_line = buffR.readLine()) != null)
            {
                if ((_line.contains(hero.getName())))
                {
                    _line = _line.replace(hero.getName(), "Replaced String");
                }
                _replacor = _line;
            }
            reader.close();
            buffR.close();

            FileWriter writter = new FileWriter(file);
            //BufferedWriter buffW = new BufferedWriter(writter);
            
            writter.write(_replacor);
            writter.flush();
            writter.close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}

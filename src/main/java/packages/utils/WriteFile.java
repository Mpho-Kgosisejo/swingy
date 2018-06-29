package packages.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import packages.models.HeroModel;

public class WriteFile
{
    static FileWriter fw = null;
    static BufferedWriter bw = null;
    static PrintWriter out = null;
    
    public static void writeToFile(String type, HeroModel _hero)
    {
        try
        {
            if (type.equals("write") == true)
            {
                fw = new FileWriter("test.txt", true);
                bw = new BufferedWriter(fw);
                out = new PrintWriter(bw);
                //out.println("");
<<<<<<< HEAD
                out.println(_hero.getName() + "," + _hero.getType() + "," + _hero.getLevel() + "," + _hero.getXPoints() + "," + _hero.getAttack() +  "," 
                + _hero.getDefense() + "," + _hero.getHitPoints() + "," + _hero.getWeapon() + "," + _hero.getArmor() + "," + _hero.getHelm());
=======
                out.println(_hero.getName() + "," + _hero.getType() + "," + _hero.getLevel() + "," + _hero.getXPoints() + "," + _hero.getWeapon() + "," + _hero.getArmor() + "," + _hero.getIcon());
>>>>>>> 5f18f20207c2237f12c80183dd28aa50e2ac7806
                out.close();
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
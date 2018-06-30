package packages.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
                out.println(_hero.getName() + "," + _hero.getType() + "," + _hero.getLevel() + "," + _hero.getXPoints() + "," + _hero.getAttack() +  "," 
                + _hero.getDefense() + "," + _hero.getHitPoints() + "," + _hero.getWeapon() + "," + _hero.getArmor() + "," + _hero.getHelm() + "," + _hero.getIcon());
                out.close();
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFileH(List<HeroModel> _heroList, HeroModel _hero){
        try
        {
            fw = new FileWriter("test.txt", true);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            out.print("");
            for (HeroModel hero : _heroList) {
                if (_hero.getName().equalsIgnoreCase(hero.getName())){
                    writeToFile("write", _hero);    
                }else{
                    writeToFile("write", hero);
                }
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }   
    }
}
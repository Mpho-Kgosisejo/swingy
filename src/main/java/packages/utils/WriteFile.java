package packages.utils;

import java.io.BufferedWriter;
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
    private static List<HeroModel> _heroList;
    private HeroModel _hero;
    public static String FileName = "hero-stats.txt";
    public static String SimulationOutputName = "simulation-output.txt";
    
    public static void write(String filename, String str, Boolean append){
        try
        {
            fw = new FileWriter(filename, append);
            bw = new BufferedWriter(fw);
            out = new PrintWriter(bw);
            out.write(str);
            out.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
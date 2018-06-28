package packages.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile
{
    FileWriter fw = null;
    BufferedWriter bw = null;
    PrintWriter out = null;
    
    public void writeToFile(String type, String text)
    {
        try
        {
            if (type.equals("write") == true)
            {
                fw = new FileWriter("test.txt", true);
                bw = new BufferedWriter(fw);
                out = new PrintWriter(bw);
                out.println(text);
                out.close();
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
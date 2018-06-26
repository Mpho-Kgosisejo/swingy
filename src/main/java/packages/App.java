package packages;

import packages.gui.controllers.WelcomeController;
import packages.console.View.*;
import static packages.utils.Colours.*;
import packages.gui.views.WelcomeView;
import packages.utils.readFile;
import java.io.*;
import java.util.*;

public class App 
{
    public static void main( String[] args ) throws IOException
    {

        if (args.length == 2){
            
            try
            {
                readFile readFile = new readFile();
                readFile.simulateFile(args[1]);
            }catch(IOException e)
            {
                System.out.println(e); 
            }
            String arg = args[0].trim().toLowerCase();

            if (arg.equals("console")){
                System.out.println(ANSI_RED + ">>>>>> CONSOLE VIEW <<<<<<<< " + ANSI_RESET);
                ConsoleView.start();
                return ;
            }
            else if (arg.equals("gui")){
                System.out.println("Run app via gui");

                WelcomeView welcomeView = new WelcomeView();
                new WelcomeController(welcomeView);
                welcomeView.setVisible(true);
                return ;
            }

        }
        System.out.println("Run program with: console or gui");
    }
}
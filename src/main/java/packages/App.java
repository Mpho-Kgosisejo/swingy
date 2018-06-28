package packages;

import packages.gui.controllers.WelcomeController;
import packages.console.view.*;
import static packages.utils.Colours.*;
import packages.gui.views.WelcomeView;
import packages.interfaces.IHero;
import packages.models.HeroModel;
import packages.utils.readFile;
import packages.utils.HeroFactory;

import java.io.*;
import java.util.*;

public class App  //extends JFrame
{
    //public static List<IHero> iHero = new ArrayList()
    public static void main( String[] args ) throws IOException
    {

        if (args.length == 2){
            
            try
            {
                List<HeroModel> heroList = readFile.simulateFile(args[1]);

                // for (HeroModel h: heroList){
                //     System.out.println(h.getName());
                // }

            //}catch(IOException e)
            }
            catch(Exception e)
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
                //welcomeView.setUndecorated(true); // -_-
                welcomeView.setVisible(true);
                return ;
            }

        }
        System.out.println("Run program with: console or gui");
    }
}
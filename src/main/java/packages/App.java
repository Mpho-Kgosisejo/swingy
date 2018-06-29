package packages;

import packages.gui.controllers.WelcomeController;
import packages.console.view.ConsoleView;
import static packages.utils.Colours.*;
import packages.gui.views.WelcomeView;
import packages.utils.Formulas;

import java.io.*;

public class App  //extends JFrame
{
    //public static List<IHero> iHero = new ArrayList()
    public static void main( String[] args ) throws IOException
    {
        for(int i = 1; i < 10; i++){
            System.out.println(">> " + i + " Lv => " + Formulas.getXPoints(i) + "XP");
            //System.out.println(">> " + i + " => " + Formulas.sizeMap(i) + " Map");
        }

        if (args.length == 2){
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
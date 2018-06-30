package packages;

import packages.gui.controllers.WelcomeController;
import packages.console.view.ConsoleView;
import static packages.utils.Colours.*;
import packages.gui.views.WelcomeView;

import java.io.*;

public class App  //extends JFrame
{
    //public static List<IHero> iHero = new ArrayList()
    public static void main( String[] args ) throws IOException
    {
        if (args.length == 2){
            String arg = args[0].trim().toLowerCase();

            if (arg.equals("console")){
                System.out.println(ANSI_BLUE + "\n>>>>>> CONSOLE VIEW <<<<<<<< \n" + ANSI_RESET);
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
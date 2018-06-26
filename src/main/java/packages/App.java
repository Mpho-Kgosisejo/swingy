package packages;

import packages.gui.controllers.WelcomeController;
import packages.gui.views.WelcomeView;

public class App 
{
    public static void main( String[] args )
    {
        if (args.length == 1){
            String arg = args[0].trim().toLowerCase();

            if (arg.equals("console")){
                System.out.println("Run app via cli");
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
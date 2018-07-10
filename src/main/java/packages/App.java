package packages;

import packages.config.Config;
import packages.console.view.ConsoleView;
import packages.enums.AppDisplay;

import static packages.utils.Colours.*;

import packages.gui.controllers.WelcomeController;
import packages.gui.views.WelcomeView;
import packages.models.HeroModel;
import packages.providers.Cache;
import packages.providers.DataProvider;
import packages.providers.db.Database;
import packages.utils.SwingyIO;

import java.io.*;

public class App
{
    public static void main( String[] args ) throws IOException
    {
        Config.init(args);
        Cache.init();
       // Database db = new Database(Config.DB_JDBC_DRIVER, Config.DB_URL, Config.DB_USER_NAME, Config.DB_USER_NAME, Config.DB_USER_PASSWORD);
        
        // if (args.length >= 1)
        // {
            if (Config.AppDisplayMode == AppDisplay.console)
            {
                SwingyIO.ConsoleOutput("######## CONSOLE VIEW ########\n", ANSI_BLUE);
                SwingyIO.ConsoleOutput("WELCOME TO SWINGY", ANSI_PURPLE);
                ConsoleView.start();
                return ;
            }
            else if (Config.AppDisplayMode == AppDisplay.gui)
            {
                new WelcomeController(new WelcomeView());
                return ;
            }

        // }
        SwingyIO.OutputError("Usage Error", "Run program with: console or gui");
    }
}
package packages.console.view;

import java.util.List;
import java.util.Scanner;

import packages.models.HeroModel;
import packages.providers.Cache;
import packages.providers.DataProvider;
import packages.config.Config;
import packages.console.controller.CliGame;
import packages.enums.AppDisplay;
import packages.enums.CharacterType;
import packages.gui.controllers.*;
import packages.gui.views.*;
import packages.utils.HeroFactory;
import packages.utils.Log;
import packages.utils.Menus;
import packages.utils.SwingyIO;
import packages.utils.readFile;
import static packages.utils.Colours.*;

public class ConsoleView
{
    public static List<HeroModel> heroList;
    public static HeroModel _hero;

    public static void start()
    {

        heroList = Cache.HeroList;
        Scanner read = new Scanner(System.in);
        Menus.menu();
        while (read.hasNextLine())
        {

            if (read.hasNextInt())
                {
                    int n = read.nextInt();

                    switch (n) {
                        case 1:
                            createHero();
                            break;
                        case 2:
                            existingHero();
                            break;
                        case 3:
                            new WelcomeController(new WelcomeView());
                            break;
                        case 4:
                            System.exit(0);
                        default:
                            SwingyIO.ConsoleOutput("\nYOUR CHOICE DOES NOT CORRESPOND TO GIVEN CHOICES\n", ANSI_RED);
                            break;
                    }

                }
                else
                {
                    SwingyIO.ConsoleOutput("INPUT MUST BE NUMERIC PLEASE SELECT ANOTHER OPTION", ANSI_RED);
                    start();
                }
        }
        read.close();
    }

    public static void createHero()
    {
        Scanner reader = new Scanner(System.in);
        Menus.heroMenu();

        while (reader.hasNextLine())
        {
            if (reader.hasNextInt())
            {
                int n = reader.nextInt();
                switch (n) {
                    case 0:
                        start();
                        break;
                    case 1:
                        declareHero(CharacterType.knight);
                        break;
                    case 2:
                        declareHero(CharacterType.warrior);
                        break;
                    case 3:
                        declareHero(CharacterType.elf);
                        break;
                    case 4:
                        declareHero(CharacterType.hunter);
                        break;
                    case 5:
                        declareHero(CharacterType.villager);
                        break;
                    case 6:
                        new CreateHeroController(new CreateHeroView());
                        Config.AppDisplayMode = AppDisplay.gui;
                        break;
                    default:
                        SwingyIO.ConsoleOutput("\nYOUR CHOICE DOES NOT CORRESPOND TO GIVEN CHOICES\n", ANSI_RED);
                        break;
                }
            }
            else
            {
                SwingyIO.ConsoleOutput("INPUT MUST BE NUMERIC PLEASE SELECT ANOTHER OPTION", ANSI_RED);
                createHero();
            }
        }
        reader.close();
    }

    public  static void declareHero(CharacterType htype)
    {
        System.out.print(ANSI_CYAN + "\nGive your " + htype + " a name: " + ANSI_RESET);
        Scanner reader = new Scanner(System.in);
        String name = reader.next();
        _hero = HeroFactory.newHero(name, htype, null);
        DataProvider dataProvider = new DataProvider(Config.DATA_PROVIDER);
        dataProvider.insertHero(_hero);
        CliGame.run(_hero);
        backToStart();
    }


    public  static void existingHero() {
        boolean isMatch = false;
        SwingyIO.ConsoleOutput("\nCHARACTERS TO CHOOSE FROM OR TYPE IN GUI TO SWITCH TO GUI\n", ANSI_CYAN);
        int a = heroList.size();
        if (a == 0)
        {
            SwingyIO.ConsoleOutput("THERE ARE NO HERO'S YOU CAN CHOOSE!!!", ANSI_RED);
        }
        else {
            for (int index = 0; index < a; index++) {
                Menus.printStats(heroList.get(index));
            }
        }
        SwingyIO.ConsoleOutput("\nTYPE IN THE NAME OF THE HERO YOU'D LIKE: ", ANSI_CYAN);
        Scanner reader = new Scanner(System.in);
        String choice = reader.nextLine();
        int i = 0;
            for (HeroModel __hero : heroList)
            {
                if (choice.equalsIgnoreCase(heroList.get(i).getName()))
                {
                    CliGame.run(heroList.get(i));
                    isMatch = true;
                    backToStart();
                }
                else if (choice.toLowerCase().equals("gui"))
                {
                    new SelectHeroController(new SelectHeroView());
                    Config.AppDisplayMode = AppDisplay.gui;
                    break;
                }
                else if(!(choice.toLowerCase().equals(heroList.get(i).getName().toLowerCase())))
                    isMatch = false;
                i++;
            }
            if (!isMatch)
            {
                SwingyIO.ConsoleOutput("THE HERO YOU SELECTED DOES NOT EXIST!!!REDIRECTING YOU TO START\n", ANSI_RED);
                start();
            }
        }

    public static void backToStart()
   {
       SwingyIO.ConsoleOutput("0. Back");
       Scanner reader = new Scanner(System.in);
       while (reader.hasNextLine())
       {
           int n = reader.nextInt();
               switch (n)
               {
                   case 0:
                       start();
                       break;
               }
       }
   }

}
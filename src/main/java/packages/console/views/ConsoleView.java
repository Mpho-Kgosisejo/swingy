package packages.console.views;

import java.util.List;
import java.util.Scanner;

import static packages.content.Colors.*;

import packages.models.HeroModel;
import packages.providers.Cache;
import packages.providers.DataProvider;
import packages.config.Config;
import packages.console.controllers.CliGame;
import packages.enums.AppDisplay;
import packages.enums.CharacterType;
import packages.gui.controllers.*;
import packages.gui.views.*;
import packages.factories.HeroFactory;
import packages.utils.Log;
import packages.utils.Menus;
import packages.utils.SwingyIO;
import packages.utils.readFile;
import packages.exceptions.*;


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
                        SwingyIO.ConsoleOutput(ANSI_YELLOW + "\nTHANK YOU FOR PLAYING" + ANSI_RESET);
                            System.exit(0);
                        default:
                            SwingyIO.ConsoleOutput("\nYOUR CHOICE DOES NOT CORRESPOND TO GIVEN CHOICES.\n", ANSI_RED);
                            start();
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

    //private HeroModel getHero()

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
                        SwingyIO.ConsoleOutput("\nYOUR CHOICE DOES NOT CORRESPOND TO GIVEN CHOICES, YOU ARE REDIRECTED BACK TO THE STARTING MENU\n", ANSI_RED);
                        start();
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
        System.out.print(ANSI_CYAN + "\nGIVE YOUR " + htype + " A NAME " + ANSI_RESET);
        Scanner reader = new Scanner(System.in);
        String name = null;
        while (true)
        {
            boolean isFound = false;
            name = reader.nextLine();
            for(HeroModel hero : Cache.HeroList)
            {
                if (hero.getName().equalsIgnoreCase(name) && isFound == false)
                {
                    SwingyIO.ConsoleOutput(ANSI_RED + "HERO WITH THAT NAME ALREADY EXISTS. TRY ANOTHER NAME" + ANSI_RESET + "\n");
                    isFound = true;
                }
            }
            if (!isFound)
            {
                break;
            }
        }
        _hero = HeroFactory.newHero(name, htype, null);
        DataProvider dataProvider = new DataProvider(Config.DATA_PROVIDER);
        dataProvider.insertHero(_hero);
        CliGame.run(_hero);
    }


    public  static void existingHero() {
        Scanner reader = new Scanner(System.in);
        HeroModel   hero = null;
        int         count                   = 1;
        int         i                       = 0;
        String      tempHeroNameStr         = "";
        String      separator               = ". ";
        boolean     isMatch                 = false;
        heroList                            = Cache.HeroList;
        int         a                       = heroList.size();

        if (a == 0)
        {
            SwingyIO.ConsoleOutput(ANSI_RED + "\nTHERE ARE NO HERO'S YOU CAN CHOOSE!!!");
        }
        else {
            SwingyIO.ConsoleOutput(ANSI_PURPLE + "\nCHOOSE YOUR CHARACTER\n" + ANSI_RESET + "\n");
            for (int index = 0; index < a; index++) {
                SwingyIO.IntegerOutput(count);
                SwingyIO.ConsoleOutput(separator);
                SwingyIO.ConsoleOutput(Menus.printHeroNames(heroList.get(index)));
                count++;
            }
            SwingyIO.ConsoleOutput("0. " + ANSI_BLUE + "Back" + ANSI_RESET + "\n");
        }
        int         choice                  = 0;
        
        while(true)
        {
            choice = getSafeNum(reader.nextLine());
            if (choice == 0)
            {
                start();
            }
            hero = getHeroAtIndex(choice, heroList);
            if (hero != null)
            {
                if (hero.getHitPoints() <= 0)
                {
                    SwingyIO.ConsoleOutput(ANSI_RED + "\nTHE HERO YOU SELECTED IS NOT AVAILABLE!" + "HERO HIT POINTS " + hero.getHitPoints() + " TRY AGAIN!\n" + ANSI_RESET + "\n");
                    existingHero();
                }
                else
                {
                    break ;
                }
            }
            else
            {
                SwingyIO.ConsoleOutput(ANSI_RED + "\nTHE HERO YOU SELECTED DOES NOT EXIST! TRY AGAIN!" + ANSI_RESET);
                existingHero();
            }
        }
        CliGame.run(hero);
    }

    public static int getSafeNum(String num)
    {
        try {
            return (Integer.parseInt(num));
        } catch (Exception e) {}
        return (-1);
    }

    private   static  HeroModel getHeroAtIndex(int index, List<HeroModel> heroList)
    {
        if (index > heroList.size() || index <= 0)
        {
            return null;
        }
        else
        {
            return heroList.get(index - 1);
        }
    }
}
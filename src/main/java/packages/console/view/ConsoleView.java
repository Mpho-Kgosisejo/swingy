package packages.console.view;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import packages.models.HeroModel;
import packages.console.controller.CliGame;
import packages.enums.ArmorType;
import packages.enums.HelmType;
import packages.enums.CharacterType;
import packages.enums.WeaponType;
import packages.gui.controllers.*;
import packages.gui.views.*;
import packages.utils.Menus;
import packages.utils.WriteFile;
import packages.utils.readFile;
import static packages.utils.Colours.*;

public class ConsoleView
{
    public static List<HeroModel> heroList;
    public static HeroModel _hero;

    public static void start()
    {
        try {
            heroList = readFile.simulateFile();
        }
        catch (IOException e)
        {
            System.out.println("Could not read from file");
        }
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
                            WelcomeView view = new WelcomeView();
                            view.setVisible(true);
                            new WelcomeController(view);
                            break;
                        default:
                            System.out.println("\nChoice does not correspond to given choices\n");
                            break;
                    }
                }
                else
                {
                    System.out.println("Input must be numeric please enter another option");
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
                        CreateHeroView view = new CreateHeroView();
                        view.setVisible(true);
                        new CreateHeroController(view, heroList);
                        break;
                    default:
                        System.out.println("\nChoice does not correspond to given choices\n");
                        break;
                }
            }
            else
            {
                System.out.println("Input must be numeric please select another option");
                createHero();
            }
        }
        reader.close();
    }

    public  static void declareHero(CharacterType htype)
    {
        System.out.print("\nGive your " + htype + " a name: ");
        Scanner reader = new Scanner(System.in);
        String name = reader.next();
        _hero = new HeroModel(name, htype, 0, 0, 0, 0, 0, WeaponType.bow, ArmorType.jacket, HelmType.frog_mouthed, "none");
        WriteFile.writeToFile(_hero);
        CliGame.run(_hero);
        backToStart();
    }


    public  static void existingHero() {
        boolean isMatch = false;
        System.out.println(ANSI_GREEN + "\nCharacters to choose from [type 'gui' to switch to gui]\n" + ANSI_RESET);
        int a = heroList.size();
        if (a == 0)
        {
            System.out.println(ANSI_RED + "THERE ARE NO HERO'S YOU CAN CHOOSE!!!" + ANSI_RESET);
        }
        else {
            for (int index = 0; index < a; index++) {
                Menus.printStats(heroList.get(index));
            }
            System.out.println(ANSI_GREEN + "YOUR MISSION IS TO GET TO THE BORDERS OF THE MAP, ENJOY!!" + ANSI_RESET);
        }
        System.out.println(ANSI_GREEN + "\nType in the name of the Hero you'd like: \n" + ANSI_RESET);
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
                    SelectHeroView view = new SelectHeroView(heroList);
                    view.setVisible(true);
                    new SelectHeroController(view, heroList);
                    break;
                }
                else if(!(choice.toLowerCase().equals(heroList.get(i).getName().toLowerCase())))
                    isMatch = false;
                i++;
            }
            if (!isMatch)
            {
                System.out.println(ANSI_RED +  "The hero you selected does not exist!! redirecting you back to start" + ANSI_RESET);
                start();
            }
        }

    public static void backToStart()
   {
       System.out.println("0. Back");
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
package packages.console.view;

import packages.models.HeroModel;
import packages.utils.HeroType;
import packages.utils.Menus;
import packages.utils.WriteFile;

import java.util.Scanner;

public class ConsoleView
{
    public static HeroModel _hero;
    public static void start()
    {
        Scanner read = new Scanner(System.in);
        Menus.menu();
        while (read.hasNextLine())
        {
            int n = read.nextInt();
            switch (n)
            {
                case 1:
                    createHero();
                    break;
                case 2:
                    System.out.println("you chose to select a hero");
                    break;
                default:
                    System.out.println("Choice does not correspond to given choices");
            }
        }
        read.close();
    }

    public static void createHero()
    {
        Menus.heroMenu();
        Scanner reader = new Scanner(System.in);
        while (reader.hasNextLine())
        {
            int n = reader.nextInt();
            switch (n)
            {
                case 1:
                    declareHero(HeroType.knight);
                    break;
                case 2:
                    declareHero(HeroType.warrior);
                    break;
                case 3:
                    declareHero(HeroType.elf);
                    break;
                case 4:
                    declareHero(HeroType.hunter);
                    break;
                case 5:
                    declareHero(HeroType.villager);
                    break;
                default:
                    System.out.println("Choice does not correspond to given choices");
                    break;
            }
        }
    }

    public  static void declareHero(HeroType htype)
    {
        System.out.print("Give your " + htype + " a name: ");
        Scanner reader = new Scanner(System.in);
        String name = reader.next();
        _hero = new HeroModel(name, htype, 0, 0, "none", "none", "none");
        WriteFile.writeToFile("write", _hero);
    }
}

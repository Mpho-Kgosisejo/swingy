package packages.console.view;

import java.util.Scanner;

import packages.models.HeroModel;
import packages.enums.ArmorType;
import packages.enums.HelmType;
import packages.enums.HeroType;
import packages.enums.WeaponType;
import packages.utils.Menus;
import packages.utils.WriteFile;

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
        reader.close();
    }

    public  static void declareHero(HeroType htype)
    {
        System.out.print("Give your " + htype + " a name: ");
        Scanner reader = new Scanner(System.in);
        String name = reader.next();
        _hero = new HeroModel(name, htype, 0, 0, 0, 0, 0, WeaponType.bow, ArmorType.jacket, HelmType.frog_mouthed, "none");
        WriteFile.writeToFile("write", _hero);
        reader.close();
    }
}

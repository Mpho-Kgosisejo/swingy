package packages.console.view;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import packages.models.HeroModel;
import packages.enums.ArmorType;
import packages.enums.HelmType;
import packages.enums.CharacterType;
import packages.enums.WeaponType;
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
            heroList = readFile.simulateFile("test.txt");
        }
        catch (IOException e)
        {
            System.out.println("hehehehehe");
        }
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
                    existingHero();
                    break;
                default:
                    System.out.println("\nChoice does not correspond to given choices\n");
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
            int n = reader.nextInt();
            switch (n)
            {
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
                    start();
                    break;
                default:
                    System.out.println("\nChoice does not correspond to given choices\n");
                    break;
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
        WriteFile.writeToFile("write", _hero);
        reader.close();
    }


    public  static void existingHero() {
        System.out.println(ANSI_GREEN + "\nCharacters to choose from\n" + ANSI_RESET);
        int a = heroList.size();
        System.out.println(a);
        int index = 0;
        while (index < a)
        {
            System.out.println(index + ". " + heroList.get(index).getName());
            index++;
        }
        Scanner reader = new Scanner(System.in);
    }
}
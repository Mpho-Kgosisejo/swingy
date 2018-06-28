package packages.utils;

import static packages.utils.Colours.*;

import packages.models.HeroModel;

public class Menus {
    public static void menu()
    {
        System.out.print("1. create a new Hero\n" + "2. Select from existing Heroes\n");
    }

    public static void heroMenu()
    {
        System.out.println(ANSI_RED + "SELECT HERO TYPE:\n" + ANSI_RESET + "1. Knight\n" + "2. Warrior\n" + "3. Elf\n" + "4. Hunter\n" + "5. Villager\n");
    }

    public static void printMap(HeroModel hero)
    {
        
    }
}

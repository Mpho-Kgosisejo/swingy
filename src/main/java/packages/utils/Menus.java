package packages.utils;

import static packages.utils.Colours.*;
import packages.models.HeroModel;

public class Menus {
    public static void menu()
    {
        System.out.println(ANSI_PURPLE + "WELCOME TO SWINGY" + ANSI_RESET);
        System.out.print(ANSI_CYAN + "\n>>>>>> START <<<<<<" + "\nSELECT ONE OF THE OPTIONS\n" + ANSI_RESET + "1. create a new Hero\n" + "2. Select from existing Heroes\n" + "3. Switch to gui\n");
    }

    public static void heroMenu()
    {
        System.out.println(ANSI_CYAN+ "\nSELECT HERO TYPE\n" + ANSI_RESET + "1. Knight\n" + "2. Warrior\n" + "3. Elf\n" + "4. Hunter\n" + "5. Villager\n" + "6. Switch to GUI\n");
    }

    public static void printStats(HeroModel _hero)
    {
        String hero_info = ANSI_CYAN + "\nHero stats\n" + ANSI_RESET +
            ANSI_PURPLE  + "\nName: " + ANSI_RESET + _hero.getName() + "\n" +
            ANSI_PURPLE  + "Type: " + ANSI_RESET + _hero.getType() + "\n" +
            ANSI_PURPLE  + "Level: " + ANSI_RESET + _hero.getLevel() + "\n" +
            ANSI_PURPLE  + "X-Points: " + ANSI_RESET + _hero.getXPoints() + "\n" +
            ANSI_PURPLE  + "Attack: " + ANSI_RESET + _hero.getAttack() + "\n" +
            ANSI_PURPLE  + "Defense: " + ANSI_RESET + _hero.getDefense() + "\n" +
            ANSI_PURPLE  + "Hit Points: " + ANSI_RESET + _hero.getHitPoints() + "\n" +
            ANSI_PURPLE  + "Weapon: " + ANSI_RESET + _hero.getWeapon() + "\n" +
            ANSI_PURPLE  + "Armor: " + ANSI_RESET + _hero.getArmor() + "\n" +
            ANSI_PURPLE  + "Helm: " + ANSI_RESET + _hero.getHelm();

        System.out.println(hero_info);
    }

    public static void printMovementMenu()
    {
        String movement = ANSI_CYAN + "\nCHOOSE A MOVEMENT DIRECTION\n" + ANSI_RESET +
            "1. North\n" +
            "2. East\n" +
            "3. West\n" +
            "4. South\n" +
                "0. Back\n";
        System.out.print(movement);
    }
    
    public static void SimulationChoice() 
    {
        String choice = ANSI_CYAN + "\nYOU HAVE ENCOUNTERED AN ENEMY, WHAT DO YOU WANT TO DO?\n" + ANSI_RESET +
            "1. Run\n" + 
            "2. Fight\n";
        System.out.println(choice);     
    }
}
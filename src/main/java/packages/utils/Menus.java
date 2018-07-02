package packages.utils;

import static packages.utils.Colours.*;

import packages.models.HeroModel;

public class Menus {
    public static void menu()
    {
        System.out.print(ANSI_GREEN + "\nSelect one of the options\n" + ANSI_RESET + "1. create a new Hero\n" + "2. Select from existing Heroes\n" + "3. Switch to gui\n");
    }

    public static void heroMenu()
    {
        System.out.println(ANSI_RED + "\nSELECT HERO TYPE:\n" + ANSI_RESET + "1. Knight\n" + "2. Warrior\n" + "3. Elf\n" + "4. Hunter\n" + "5. Villager\n" + "6. Switch to GUI\n");
    }

    public static void printStats(HeroModel _hero)
    {
        String hero_info = ANSI_GREEN + "\nHero stats\n" + ANSI_RESET +
            ANSI_BLUE + "\nName: " + ANSI_RESET + _hero.getName() + "\n" +
            ANSI_BLUE + "Type: " + ANSI_RESET + _hero.getType() + "\n" +
            ANSI_BLUE + "Level: " + ANSI_RESET + _hero.getLevel() + "\n" +
            ANSI_BLUE + "X-Points: " + ANSI_RESET + _hero.getXPoints() + "\n" +
            ANSI_BLUE + "Attack: " + ANSI_RESET + _hero.getAttack() + "\n" +
            ANSI_BLUE + "Defense: " + ANSI_RESET + _hero.getDefense() + "\n" +
            ANSI_BLUE + "Hit Points: " + ANSI_RESET + _hero.getHitPoints() + "\n" +            
            ANSI_BLUE + "Weapon: " + ANSI_RESET + _hero.getWeapon() + "\n" +
            ANSI_BLUE + "Armor: " + ANSI_RESET + _hero.getArmor() + "\n" + 
            ANSI_BLUE + "Helm: " + ANSI_RESET + _hero.getHelm();

        System.out.println(hero_info);
    }

    public static void printMovementMenu()
    {
        String movement = "\nChoose a movement direction\n" + 
            "1. North\n" +
            "2. East\n" +
            "3. West\n" +
            "4. South\n";
        System.out.print(movement);
    }
    
    public static void SimulationChoice() 
    {
        String choice = "\nYou have encountered an enemy, what do you want to do?\n" + 
            "1. Run\n" + 
            "2. Fight\n";
        System.out.println(choice);     
    }
}
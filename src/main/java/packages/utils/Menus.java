package packages.utils;

import static packages.content.Colors.*;

import packages.models.EnemyModel;
import packages.models.HeroModel;

public class Menus {
    public static void menu()
    {
        SwingyIO.ConsoleOutput(ANSI_PURPLE + "\nSELECT ONE OF THE OPTIONS\n" + ANSI_RESET);
        SwingyIO.ConsoleOutput("\n1. " + ANSI_BLUE + "Create a new Hero\n" + ANSI_RESET); 
        SwingyIO.ConsoleOutput("2. " + ANSI_BLUE + "Select from existing Heroes\n" + ANSI_RESET);
        SwingyIO.ConsoleOutput("3. " + ANSI_BLUE + "Switch to gui\n" + ANSI_RESET);
        SwingyIO.ConsoleOutput("4. " + ANSI_BLUE + "Exit\n" + ANSI_RESET);
    }

    public static void heroMenu()
    {
        SwingyIO.ConsoleOutput(ANSI_PURPLE + "\nSELECT HERO TYPE\n" + ANSI_RESET);
        SwingyIO.ConsoleOutput("\n1. " + ANSI_BLUE + "Knight\n" + ANSI_RESET);
        SwingyIO.ConsoleOutput("2. " + ANSI_BLUE + "Warrior\n" + ANSI_RESET);
        SwingyIO.ConsoleOutput("3. " + ANSI_BLUE + "Elf\n" + ANSI_RESET);
        SwingyIO.ConsoleOutput("4. " + ANSI_BLUE + "Hunter\n" + ANSI_RESET);
        SwingyIO.ConsoleOutput("5. " + ANSI_BLUE + "Villager\n" + ANSI_RESET);
        SwingyIO.ConsoleOutput("6. " + ANSI_BLUE + "Go GUI\n" + ANSI_RESET);
        SwingyIO.ConsoleOutput("0. " + ANSI_BLUE + "Back\n" + ANSI_RESET);
    }

    public static void printStats(HeroModel _hero)
    {
        String hero_info = ANSI_CYAN + "\nYOUR HERO STATS\n" + ANSI_RESET +
            ANSI_GREEN  + "\nName: \t\t" + ANSI_RESET + _hero.getName() + "\n" +
            ANSI_GREEN  + "Type: \t\t" + ANSI_RESET + _hero.getType() + "\n" +
            ANSI_GREEN  + "Level: \t\t" + ANSI_RESET + _hero.getLevel() + "\n" +
            ANSI_GREEN  + "X-Points: \t" + ANSI_RESET + _hero.getXPoints() + "\n" +
            ANSI_GREEN  + "Attack: \t" + ANSI_RESET + _hero.getAttack() + "\n" +
            ANSI_GREEN  + "Defense: \t" + ANSI_RESET + _hero.getDefense() + "\n" +
            ANSI_GREEN  + "Hit Points: \t" + ANSI_RESET + _hero.getHitPoints() + "\n" +
            ANSI_GREEN  + "Weapon: \t" + ANSI_RESET + _hero.getWeapon() + "\n" +
            ANSI_GREEN  + "Armor: \t\t" + ANSI_RESET + _hero.getArmor() + "\n" +
            ANSI_GREEN  + "Helm: \t\t" + ANSI_RESET + _hero.getHelm();

        SwingyIO.ConsoleOutput(hero_info);
    }

    public static String printHeroNames(HeroModel hero)
    {
        String heroNames = ANSI_BLUE  + hero.getName() + ANSI_RESET + "\n";
        return heroNames;
    }

    public static void printMovementMenu()
    {
        String movement = ANSI_PURPLE + "\nCHOOSE A MOVEMENT DIRECTION\n" + ANSI_RESET + "\n" +
            "1. " + ANSI_BLUE + "North\n" + ANSI_RESET +
            "2. " + ANSI_BLUE + "East\n" + ANSI_RESET +
            "3. " + ANSI_BLUE + "West\n" + ANSI_RESET +
            "4. " + ANSI_BLUE + "South\n" + ANSI_RESET +
            "0. " + ANSI_BLUE + "Back\n" + ANSI_RESET;
        System.out.print(movement);
    }
    
    public static void SimulationChoice() 
    {
        String choice = ANSI_RED + "\nYOU HAVE ENCOUNTERED AN ENEMY, WHAT DO YOU WANT TO DO?\n" + ANSI_RESET + "\n" +
            "1. " + ANSI_BLUE + "RUN\n" + ANSI_RESET + 
            "2. " + ANSI_BLUE + "FIGHT\n" + ANSI_RESET;
        SwingyIO.ConsoleOutput(choice);     
    }
    
    public static void PrintFightOpponents(HeroModel hero, EnemyModel enemy) 
    {
        SwingyIO.ConsoleOutput("\n" + ANSI_GREEN + hero.getName().toUpperCase() + ANSI_RESET + "\t VS \t" + ANSI_RED + enemy.getName().toUpperCase() + ANSI_RESET + "\n");
        SwingyIO.ConsoleOutput("Attack: " + hero.getAttack() + ANSI_YELLOW + "\t|\t" + ANSI_RESET + "Attack: " + enemy.getAttack() + "\n");
        SwingyIO.ConsoleOutput("Defense: " + hero.getDefense() + ANSI_YELLOW + "\t|\t" + ANSI_RESET + "Defense: " + enemy.getDefense() + "\n");
        SwingyIO.ConsoleOutput("Hit Points: " + hero.getHitPoints() + ANSI_YELLOW + "\t|\t" + ANSI_RESET + "Hit Points: " + enemy.getHitPoints() + "\n");
        SwingyIO.ConsoleOutput("Weapon: " + hero.getWeapon() + ANSI_YELLOW + "\t|\t" + ANSI_RESET + "Weapon: " + enemy.getWeapon() + "\n");
        SwingyIO.ConsoleOutput("Armor: " + hero.getArmor() + ANSI_YELLOW + "\t|\t" + ANSI_RESET + "Armor: " + enemy.getArmor() + "\n");
        SwingyIO.ConsoleOutput("Helm: " + hero.getHelm() + ANSI_YELLOW + "\t|\t" + ANSI_RESET + "Helm: " + enemy.getHelm() + "\n");
        SwingyIO.ConsoleOutput("\n");
    }
}
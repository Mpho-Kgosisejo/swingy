package packages.utils;

import static packages.utils.Colours.*;

import packages.models.EnemyModel;
import packages.models.HeroModel;

public class Menus {
    public static void menu()
    {
        System.out.print(ANSI_CYAN + "\n>>>>>> START <<<<<<" + "\nSELECT ONE OF THE OPTIONS\n" + ANSI_RESET + "1. create a new Hero\n" + "2. Select from existing Heroes\n" + "3. Switch to gui\n" + "4. Exit\n");
    }

    public static void heroMenu()
    {
        SwingyIO.ConsoleOutput(ANSI_CYAN+ "\nSELECT HERO TYPE\n" + ANSI_RESET + "1. Knight\n" + "2. Warrior\n" + "3. Elf\n" + "4. Hunter\n" + "5. Villager\n" + "6. Switch to GUI\n" + "0. Back\n");
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

        SwingyIO.ConsoleOutput(hero_info);
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
        SwingyIO.ConsoleOutput(choice);     
    }
    
    public static void PrintFightOpponents(HeroModel hero, EnemyModel enemy) 
    {
        SwingyIO.ConsoleOutput(ANSI_CYAN + hero.getName().toUpperCase() + ANSI_RESET + " VS " + ANSI_RED + enemy.getName().toUpperCase() + ANSI_RESET);
        SwingyIO.ConsoleOutput("Attack: " + hero.getAttack() + ANSI_YELLOW + "   |   " + ANSI_RESET + "Attack: " + enemy.getAttack());
        SwingyIO.ConsoleOutput("Defense: " + hero.getDefense() + ANSI_YELLOW + "   |   " + ANSI_RESET + "Defense: " + enemy.getDefense());
        SwingyIO.ConsoleOutput("Hit Points: " + hero.getHitPoints() + ANSI_YELLOW + "   |   " + ANSI_RESET + "Hit Points: " + enemy.getHitPoints());
        SwingyIO.ConsoleOutput("Weapon: " + hero.getWeapon() + ANSI_YELLOW + "   |   " + ANSI_RESET + "Weapon: " + enemy.getWeapon());
        SwingyIO.ConsoleOutput("Armor: " + hero.getArmor() + ANSI_YELLOW + "   |   " + ANSI_RESET + "Armor: " + enemy.getArmor());
        SwingyIO.ConsoleOutput("Helm: " + hero.getHelm() + ANSI_YELLOW + "   |   " + ANSI_RESET + "Helm: " + enemy.getHelm() + "\n");
    }
}
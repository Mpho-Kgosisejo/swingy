package packages.utils;

import static packages.utils.Colours.*;

import packages.models.HeroModel;

public class Menus {
    public static void menu()
    {
        System.out.print("1. create a new Hero\n" + "2. Select from existing Heroes\n" + "3. Switch to gui\n");
    }

    public static void heroMenu()
    {
        System.out.println(ANSI_RED + "\nSELECT HERO TYPE:\n" + ANSI_RESET + "1. Knight\n" + "2. Warrior\n" + "3. Elf\n" + "4. Hunter\n" + "5. Villager\n");
    }

    public static void printStats(HeroModel _hero)
    {
        String hero_info = "Name: " + _hero.getName() + "\n" +
            "Type: " + _hero.getType() + "\n" +
            "Level: " + _hero.getLevel() + "\n" +
            "X-Points: " + _hero.getXPoints() + "\n" +
            "Attack: " + _hero.getAttack() + "\n" +
            "Defense: " + _hero.getDefense() + "\n" +
            "Hit Points: " + _hero.getHitPoints() + "\n" +            
            "Weapon: " + _hero.getWeapon() + "\n" +
            "Armor: " + _hero.getArmor() + "\n" + 
            "Helm: " + _hero.getHelm();

        System.out.println(hero_info);
    }
}
package packages.console.controller;

import packages.models.HeroModel;

public class CliGame
{
    public static void run(HeroModel hero)
    {
        String hero_info = "Name: " + hero.getName() + "\n" +
            "Type: " + hero.getType() + "\n" +
            "Level: " + hero.getLevel() + "\n" +
            "X-Points: " + hero.getXPoints() + "\n" +
            "Attack: " + hero.getAttack() + "\n" +
            "Defense: " + hero.getDefense() + "\n" +
            "Hit Points: " + hero.getHitPoints() + "\n" +            
            "Weapon: " + hero.getWeapon() + "\n" +
            "Armor: " + hero.getArmor() + "\n" + 
            "Helm: " + hero.getHelm();

        System.out.println(hero_info);
    }
}
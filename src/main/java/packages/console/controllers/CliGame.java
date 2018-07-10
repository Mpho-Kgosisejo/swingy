package packages.console.controllers;

import packages.models.HeroModel;
import packages.utils.Menus;
import packages.utils.SwingyIO;
import packages.console.views.ConsoleView;
import packages.console.views.Maps;
import   static packages.content.Colors.*;

import java.util.Scanner;

public class CliGame
{
    private static HeroModel _hero;
    public static void run(HeroModel hero)
    {
        Scanner scan = new Scanner(System.in);
        int i;
        _hero = hero;
        Menus.printStats(_hero);
        SwingyIO.ConsoleOutput("\n" + ANSI_RED + "\n_________________ DARE T0 START THE GAME __________________\n" + ANSI_RESET);
        SwingyIO.ConsoleOutput("\n");
        SwingyIO.ConsoleOutput(ANSI_PURPLE + "\nDO YOU WISH TO CONTINUE WITH THIS HERO: " + hero.getName() + "\n" + ANSI_RESET);
        SwingyIO.ConsoleOutput("\n1. " + ANSI_BLUE + "YES\n" + ANSI_RESET);
        SwingyIO.ConsoleOutput("\n2. " + ANSI_BLUE + "NO\n" + ANSI_RESET);

        i = ConsoleView.getSafeNum(scan.nextLine());
        switch(i)
        {
            case 1:
                SwingyIO.ConsoleOutput(ANSI_YELLOW + "\nYOUR MISSION IS TO GET TO THE BORDERS OF THE MAP, ENJOY!!\n" + ANSI_RESET);
                Maps map = new Maps();
                map.init(_hero);
                map.drawMap(_hero);
            case 2:
                ConsoleView.existingHero();
            default:
                run(hero);
        }        

    }
}
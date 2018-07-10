package packages.console.controller;

import packages.console.view.Maps;
import packages.models.HeroModel;
import packages.utils.Menus;
import packages.utils.SwingyIO;

import static packages.utils.Colours.*;

public class CliGame
{
    private static HeroModel _hero;
    public static void run(HeroModel hero)
    {
        _hero = hero;
        Menus.printStats(_hero);
        SwingyIO.ConsoleOutput("\nYOUR MISSION IS TO GET TO THE BORDERS OF THE MAP, ENJOY!!", ANSI_YELLOW);
        Maps map = new Maps();
        map.init(_hero);
        map.drawMap(_hero);
    }
}
package packages.console.controller;

import packages.console.view.Maps;
import packages.models.HeroModel;
import packages.utils.Menus;

public class CliGame
{
    private static HeroModel _hero;
    public static void run(HeroModel hero)
    {
        _hero = hero;
        Menus.printStats(_hero);
        Maps map = new Maps();
        map.init(_hero);
        map.drawMap(_hero);
    }
}
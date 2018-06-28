package packages.models;

import packages.interfaces.IHero;
import packages.utils.HeroType;

public class HunterModel extends HeroModel implements IHero
{
    public HunterModel(String name, HeroType type, int level, int xPoints, String weapon, String armor, String icon)
    {
        super(name, type, level, xPoints, weapon, armor, icon);
        System.out.println("Hunter");
    }
}
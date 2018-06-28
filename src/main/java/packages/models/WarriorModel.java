package packages.models;

import packages.interfaces.*;
import packages.utils.HeroType;

public class WarriorModel extends HeroModel implements IHero
{
    public WarriorModel(String name, HeroType type, int level, int xPoints, String weapon, String armor, String icon)
    {
        super(name, type, level, xPoints, weapon, armor, icon);
        System.out.println("Warrior");        
    }
}
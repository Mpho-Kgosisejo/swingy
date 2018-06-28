package packages.models;

import packages.interfaces.IHero;
import packages.utils.HeroType;

public class ElfModel extends HeroModel implements IHero
{
    public ElfModel(String name, HeroType type, int level, int xPoints, String weapon, String armor)
    {
        super(name, type, level, xPoints, weapon, armor);
    }
}
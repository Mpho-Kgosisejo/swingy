package packages.models;

import packages.interfaces.IHero;
import packages.enums.ArmorType;
import packages.enums.HelmType;
import packages.enums.HeroType;
import packages.enums.WeaponType;

public class KnightModel extends HeroModel implements IHero
{
    public KnightModel(String name, HeroType type, int level, int xPoints, int attack, int defense, int hitPoints, WeaponType weapon, ArmorType armor, HelmType helm,  String icon)
    {
        super(name, type, level, xPoints, attack, defense, hitPoints, weapon, armor, helm, icon);
        System.out.println("Knight");        
    }
}
package packages.interfaces;

import packages.utils.HeroType;

public interface IHero
{
    public int getId();

    public String getName();
    
    public HeroType getType();

    public int getLevel();

    public int getXPoints();

    public String getWeapon();
    
    public String getArmor();

}
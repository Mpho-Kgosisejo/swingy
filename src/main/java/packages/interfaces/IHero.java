package packages.interfaces;

import packages.enums.ArmorType;
import packages.enums.HelmType;
import packages.enums.HeroType;
import packages.enums.WeaponType;

public interface IHero
{
    public int getId();

    public String getName();
    
    public HeroType getType();

    public int getLevel();

    public int getXPoints();

    public int getAttack();

    public int getDefense();
    
    public int getHitPoints();    

    public WeaponType getWeapon();
    
    public ArmorType getArmor();

    public HelmType getHelm();

}
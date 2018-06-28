package packages.utils;

import packages.interfaces.IHero;
import packages.models.HeroModel;
import packages.models.WarriorModel;
import java.io.*;

public class HeroFactory
{
    public static HeroModel newHero(String name, String type, int level, int xPoints, String weapon, String armor)
    {
        String storeType = type.trim().toLowerCase();
        String temp = "";
        HeroModel _heroModel;

        if (storeType.equals("warrior") == true)
            temp = "warrior";
        else if (storeType.equals("hunter") == true)
            temp = "hunter";
        else if(storeType.equals("elf") == true)
            temp = "elf";
        else if(storeType.equals("knight") == true)
            temp = "knight";
        else if (storeType.equals("villager") == true)
            temp = "villager";
        else
            temp = null;

        if (temp != null)
        {
            HeroType tempHeroType = HeroType.valueOf(temp);
            for (HeroType etype : HeroType.values())
            {
                int i = 1;
                if (etype.equals(tempHeroType) == true)
                {
                    _heroModel = new HeroModel(name, etype, level, xPoints, weapon, armor);
                    return (_heroModel);
                }
            }            
        }
        return (null);
    }
}

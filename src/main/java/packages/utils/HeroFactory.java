package packages.utils;

import packages.models.ElfModel;
import packages.models.HeroModel;
import packages.models.HunterModel;
import packages.models.KnightModel;
import packages.models.VillagerModel;
import packages.models.WarriorModel;

public class HeroFactory
{
    public static HeroModel newHero(String name, String type, int level, int xPoints, String weapon, String armor, String icon)
    {
        String storeType = type.trim().toLowerCase();
        String temp = "";
            
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
        
        System.out.println("Temp type: " + temp);
        
        if (temp != null)
        {
            for (HeroType etype : HeroType.values())
            {
                HeroType tempHeroType = HeroType.valueOf(temp);                
                int i = 1;
                if (etype.equals(tempHeroType) == true)
                {
                    switch(tempHeroType)
                    {
                        case warrior:
                           return (new WarriorModel(name, etype, level, xPoints, weapon, armor, icon));
                        case elf:
                       return (new ElfModel(name, etype, level, xPoints, weapon, armor, icon));
                        case hunter:
                          return (new HunterModel(name, etype, level, xPoints, weapon, armor, icon));
                        case knight:
                          return (new KnightModel(name, etype, level, xPoints, weapon, armor, icon));
                        case villager:
                            return (new VillagerModel(name, etype, level, xPoints, weapon, armor, icon));
                        default:
                            break;
                    }
                }
            }            
        }
        return (null);
    }
}

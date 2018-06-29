package packages.utils;

import packages.enums.ArmorType;
import packages.enums.CharacterType;
import packages.enums.WeaponType;
import packages.enums.HelmType;
import packages.models.ElfModel;
import packages.models.HeroModel;
import packages.models.HunterModel;
import packages.models.KnightModel;
import packages.models.VillagerModel;
import packages.models.WarriorModel;

public class HeroFactory
{
    public static HeroModel newHero(String name, String type, int level, int xPoints, int attack, int defense, int hitPoints, String weapon, String armor, String helm, String icon)
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
        
        if (temp != null)
        {
            for (CharacterType etype : CharacterType.values())
            {
                CharacterType tempCharacterType = CharacterType.valueOf(temp);
                HelmType tempHelmType = HelmType.valueOf(helm);
                WeaponType tempWeaponType = WeaponType.valueOf(weapon);
                ArmorType tempArmorType = ArmorType.valueOf(armor);

                int i = 1;
                if (etype.equals(tempCharacterType) == true)
                {
                    switch(tempCharacterType)
                    {
                        case warrior:
                           return (new WarriorModel(name, etype, level, xPoints, attack, defense, hitPoints, tempWeaponType, tempArmorType, tempHelmType, icon));
                        case elf:
                       return (new ElfModel(name, etype, level, xPoints, attack, defense, hitPoints, tempWeaponType, tempArmorType, tempHelmType, icon));
                        case hunter:
                          return (new HunterModel(name, etype, level, xPoints, attack, defense, hitPoints, tempWeaponType, tempArmorType, tempHelmType, icon));
                        case knight:
                          return (new KnightModel(name, etype, level, xPoints, attack, defense, hitPoints, tempWeaponType, tempArmorType, tempHelmType, icon));
                        case villager:
                            return (new VillagerModel(name, etype, level, xPoints, attack, defense, hitPoints, tempWeaponType, tempArmorType, tempHelmType, icon));
                        default:
                            break;
                    }
                }
            }            
        }
        return (null);
    }
}

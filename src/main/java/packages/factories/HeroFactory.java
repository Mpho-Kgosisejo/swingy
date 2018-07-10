package packages.factories;

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
import packages.utils.Formulas;
import packages.utils.Log;

public class HeroFactory
{
    
    public static HeroModel newHero(String name, String type, String level, String xPoints, String attack, String defense, String hitPoints, String weapon, String armor, String helm, String icon)
    {
        String storeType = type.trim().toLowerCase();
        int iLevel = 0;
        int iXp = 0;
        int iAttack = 0;
        int iDefense = 0;
        int iHp = 0;
        
        try {
            iLevel = Integer.parseInt(level);
            iXp = Integer.parseInt(xPoints);
            iAttack = Integer.parseInt(attack);
            iDefense = Integer.parseInt(defense);
            iHp = Integer.parseInt(hitPoints);
            iLevel = Formulas.getLevel(iXp);

            CharacterType tempCharacterType = CharacterType.valueOf(type);
            HelmType tempHelmType = HelmType.valueOf(helm);
            WeaponType tempWeaponType = WeaponType.valueOf(weapon);
            ArmorType tempArmorType = ArmorType.valueOf(armor);

            switch(tempCharacterType)
            {
                case warrior:
                    return (new WarriorModel(name, tempCharacterType, iLevel, iXp, iAttack, iDefense, iHp, tempWeaponType, tempArmorType, tempHelmType, icon));
                case elf:
                return (new ElfModel(name, tempCharacterType, iLevel, iXp, iAttack, iDefense, iHp, tempWeaponType, tempArmorType, tempHelmType, icon));
                case hunter:
                    return (new HunterModel(name, tempCharacterType, iLevel, iXp, iAttack, iDefense, iHp, tempWeaponType, tempArmorType, tempHelmType, icon));
                case knight:
                    return (new KnightModel(name, tempCharacterType, iLevel, iXp, iAttack, iDefense, iHp, tempWeaponType, tempArmorType, tempHelmType, icon));
                case villager:
                    return (new VillagerModel(name, tempCharacterType, iLevel, iXp, iAttack, iDefense, iHp, tempWeaponType, tempArmorType, tempHelmType, icon));
                default:
                    break;
            }
        } catch (Exception e) {
            Log.out("Error creating hero: " + e.getMessage());
        }
        return (null);
    }

    public static HeroModel newHero(String name, CharacterType type, String icon)
    {
        int level = 0;
        int xPoints = 0;
        int attack  = 15;
        int defense = 10;
        int hitPoints  = 50;

        String storeType = type.toString();
        if (icon == null)
            icon = "src/main/java/packages/images/default-image.png";

        CharacterType tempCharacterType = CharacterType.valueOf(storeType);
        HelmType tempHelmType = HelmType.nasal;
        WeaponType tempWeaponType = WeaponType.spear;
        ArmorType tempArmorType = ArmorType.jacket;

        switch(tempCharacterType)
        {
            case warrior:
                return (new WarriorModel(name, tempCharacterType, level, xPoints, attack, defense, hitPoints, tempWeaponType, tempArmorType, tempHelmType, icon));
            case elf:
                return (new ElfModel(name, tempCharacterType, level, xPoints, attack, defense, hitPoints, tempWeaponType, tempArmorType, tempHelmType, icon));
            case hunter:
                return (new HunterModel(name, tempCharacterType, level, xPoints, attack, defense, hitPoints, tempWeaponType, tempArmorType, tempHelmType, icon));
            case knight:
                return (new KnightModel(name, tempCharacterType, level, xPoints, attack, defense, hitPoints, tempWeaponType, tempArmorType, tempHelmType, icon));
            case villager:
                return (new VillagerModel(name, tempCharacterType, level, xPoints, attack, defense, hitPoints, tempWeaponType, tempArmorType, tempHelmType, icon));
            default:
                break;
        }           
        return (null);
    }
}



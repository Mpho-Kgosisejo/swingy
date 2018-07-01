package packages.models;

import packages.enums.ArmorType;
import packages.enums.HelmType;
import packages.enums.CharacterType;
import packages.enums.WeaponType;
import packages.interfaces.IHero;

public class EnemyModel extends HeroModel implements IHero
{
    public EnemyModel(String name, CharacterType type, int level, int xPoints, int attack, int defense, int hitPoints, WeaponType weapon, ArmorType armor, HelmType helm, String icon)
    {
        super(name, type, level, xPoints, attack, defense, hitPoints, weapon, armor, helm, icon);
        this._name = "Trollos";
        this._type = CharacterType.enemy;
        this._level = 1;
        this._xPoints = 1;
        this._attack = 3;
        this._defense = 2;
        this._hitPoints = 3;
        this._weapon = WeaponType.spear;        
        this._armor = ArmorType.leather;
        this._helm = HelmType.pot;
        this._icon = icon;
    }
}
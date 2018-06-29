package packages.models;

import packages.enums.*;

public class HeroModel
{
	private static int _idCounter = 0;
	protected int _id = 0;
	protected String _name;
    protected HeroType _type;
    protected int _level;
	protected int _xPoints;
    protected int _attack;
    protected int _defense;
    protected int _hitPoints;	
    protected WeaponType _weapon;
	protected ArmorType _armor;
	protected HelmType _helm;	
	protected String _icon;
	
	public HeroModel(String name, HeroType type, int level, int xPoints, int attack, int defense, int hitPoints, WeaponType weapon, ArmorType armor, HelmType helm, String icon)
	{
		this._icon = icon;
		this._id = getNextId();
		this._name = name;
		this._type = type;
		this._level = level;
		this._xPoints = xPoints;
		this._attack = attack;
		this._defense = defense;
		this._hitPoints = hitPoints;
		this._weapon = weapon;
		this._armor = armor;
		this._helm = helm;
		System.out.println("New Hero!");
	}

	private int getNextId()
	{
		return (++this._idCounter);
	}

	public int getId()
    {
        return this._id;
    }

	public String getName() {
		return this._name;
	}

    public HeroType getType()
    {
        return this._type;
    }

	public int getLevel() {
		return this._level;
	}

	public int getXPoints() {
		return this._xPoints;
	}

	public int getAttack() {
		return this._attack;
	}

	public int getDefense() {
		return this._defense;
	}

	public int getHitPoints() {
		return this._hitPoints;
	}

	public WeaponType getWeapon() {
		return this._weapon;
	}

	public ArmorType getArmor() {
		return this._armor;
	}

	public HelmType getHelm() {
		return this._helm;
	}

	public String getIcon() {
		return this._icon;
	}
}
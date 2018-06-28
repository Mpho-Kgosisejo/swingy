package packages.models;

import packages.utils.HeroType;

public class HeroModel
{
	private static int _idCounter = 0;
	protected int _id = 0;
	protected String _name;
    protected HeroType _type;
    protected int _level;
    protected int _xPoints;
    protected String _weapon;
	protected String _armor;
	protected String _icon;
	
	public HeroModel(String name, HeroType type, int level, int xPoints, String weapon, String armor, String icon)
	{
		this._icon = icon;
		this._id = getNextId();
		this._name = name;
		this._type = type;
		this._level = level;
		this._xPoints = xPoints;
		this._weapon = weapon;
		this._armor = armor;
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

	public String getWeapon() {
		return this._weapon;
	}

	public String getArmor() {
		return this._armor;
	}

	public String getIcon() {
		return this._icon;
	}
}
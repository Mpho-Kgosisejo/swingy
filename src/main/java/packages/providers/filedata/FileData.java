package packages.providers.filedata;

import java.util.ArrayList;
import java.util.List;

import packages.config.Config;
import packages.interfaces.IDataProvider;
import packages.models.HeroModel;
import packages.providers.Cache;
import packages.factories.*;
import packages.utils.WriteFile;
import packages.utils.readFile;

public class FileData implements IDataProvider
{
    private String _file;
    private List<HeroModel> _heroList;

    public FileData (String filename)
    {
        this._file = filename;
        this._heroList = null;
    }

    private void initHeroList()
    {
        if (this._heroList == null)
            this._heroList = new ArrayList<HeroModel>();
    }

    private void insertHeroHelper(HeroModel _hero, Boolean append)
    {
        String hero = (_hero.getName() + "," + _hero.getType() + "," + _hero.getLevel() + "," + _hero.getXPoints() + "," + _hero.getAttack() +  "," 
        + _hero.getDefense() + "," + _hero.getHitPoints() + "," + _hero.getWeapon() + "," + _hero.getArmor() + "," + _hero.getHelm() + "," + _hero.getIcon() + "\n");

        WriteFile.write(Config.HERO_TEXT_FILE_NAME, hero, append);
        Cache.init();
    }

    public List<HeroModel> getHeroList()
    {
        String fileInfo = readFile.getContent(this._file);
        String[] fileInfoArray = null;

        if (fileInfo != null && (fileInfoArray = fileInfo.split("\n")) != null)
        {
            for (String info: fileInfoArray)
            {
                String[] heroInfo = null;

                if ((heroInfo = info.split(",")) != null && heroInfo.length == 11)
                {
                    this.initHeroList();

                    String name = heroInfo[0];
                    String type = heroInfo[1];
                    String level = heroInfo[2];
                    String xPoints = heroInfo[3];
                    String attack = heroInfo[4];
                    String defense = heroInfo[5];
                    String hitPoints = heroInfo[6];
                    String weapon = heroInfo[7];
                    String armor = heroInfo[8];
                    String helm = heroInfo[9];
                    String icon = heroInfo[10];

                    HeroModel hero = HeroFactory.newHero(name, type, level, xPoints, attack, defense, hitPoints, weapon, armor, helm, icon);
                    if (hero != null)
                        this._heroList.add(hero);
                }
            }
        }
		return this._heroList;
	}

    public Boolean insertHero(HeroModel hero)
    {
        this.insertHeroHelper(hero, true);
        return (true);
	}

	public Boolean updateHero(HeroModel hero) {
		List<HeroModel> heroList = Cache.HeroList;
        WriteFile.write(Config.HERO_TEXT_FILE_NAME, "", false);

        if (heroList == null)
            return (false);
        for (HeroModel h: heroList)
        {
            if (h.getId() == hero.getId())
                this.insertHeroHelper(hero, true);
            else
                this.insertHeroHelper(h, true);
        }
		return (true);
	}

	public Boolean deleteHero(HeroModel hero) {
		return (false);
	}
}
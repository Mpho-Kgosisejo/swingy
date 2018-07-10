package packages.models;

import java.util.List;

import packages.config.Config;
import packages.enums.CharacterType;
import packages.providers.Cache;
import packages.factories.*;
import packages.utils.Messages;

public class CreateHeroModel{
    private HeroModel _hero;
    private String _heroImagePath;

    public CreateHeroModel()
    {
        this._hero = null;
        this._heroImagePath = Config.HERO_DEFAULT_IMAGE_PATH;
    }

    public HeroModel getHero()
    {
        return (this._hero);
    }
    
    private Boolean isHeroNameUnique(String name)
    {
        List<HeroModel> heroList = Cache.HeroList;

        for (HeroModel hero: heroList)
        {
            if (name.equals(hero.getName()))
                return (false);
        }
        return (true);
    }

    public void setHeroImagePath(String path)
    {
        this._heroImagePath = path;
    }

    public String setHero(String heroName, String heroType){
        String ret = null;
        CharacterType characterType = null;

        if (heroName.isEmpty() == true || heroName == null)
            return (Messages.HeroNameCanNotBeEmpty);
        else if (heroType.isEmpty() || heroType == null)
            return (Messages.HeroTypeCanNotBeEmpty);
        else if (this.isHeroNameUnique(heroName) == false)
            return (Messages.Hero + " \"" + heroName + "\" " + Messages.AlreadyExists);
        try
        {
            characterType = CharacterType.valueOf(heroType);
        }
        catch (Exception e)
        {
            return (Messages.ErrorSettingEnum + ": " + CharacterType.class);
        }

        this._hero = HeroFactory.newHero(heroName, characterType, this._heroImagePath);
        return (ret);
    }
}
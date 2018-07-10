package packages.interfaces;

import java.util.List;

import packages.models.HeroModel;

public interface IDataProvider
{
    public List<HeroModel> getHeroList();

    public Boolean insertHero(HeroModel hero);

    public Boolean updateHero(HeroModel hero);

    public Boolean deleteHero(HeroModel hero);
}
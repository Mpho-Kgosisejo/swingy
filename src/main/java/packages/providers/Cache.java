package packages.providers;

import java.util.List;

import packages.config.Config;
import packages.models.HeroModel;

public class Cache
{
    public static List<HeroModel> HeroList = null;

    public static void init()
    {
        DataProvider dataProvider = new DataProvider(Config.DATA_PROVIDER);
        HeroList = dataProvider.getHeroList();
    }
}
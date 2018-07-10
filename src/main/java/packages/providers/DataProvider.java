package packages.providers;

import java.util.List;

import packages.config.Config;
import packages.enums.DataProviderType;
import packages.interfaces.IDataProvider;
import packages.models.HeroModel;
import packages.providers.db.Database;
import packages.providers.filedata.FileData;

public class DataProvider implements IDataProvider
{
    private IDataProvider _provider;

    public DataProvider (DataProviderType dataProviderType)
    {
        if (Config.DATA_PROVIDER == dataProviderType)
            this._provider = new FileData(Config.HERO_TEXT_FILE_NAME);
        else if (Config.DATA_PROVIDER == dataProviderType)
            this._provider = new Database(Config.DB_JDBC_DRIVER, Config.DB_URL, Config.DB_NAME, Config.DB_USER_NAME, Config.DB_USER_PASSWORD);
    }

    public List<HeroModel> getHeroList()
    {
        if (this._provider == null)
            return (null);
        return (this._provider.getHeroList());
    }

	public Boolean insertHero(HeroModel hero) {
        if (this._provider == null)
            return (null);
		return (this._provider.insertHero(hero));
	}

	public Boolean updateHero(HeroModel hero) {
        if (this._provider == null)
            return (null);
		return (this._provider.updateHero(hero));
	}

	public Boolean deleteHero(HeroModel hero) {
        if (this._provider == null)
            return (null);
		return (this._provider.deleteHero(hero));
	}
}
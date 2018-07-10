package packages.config;

import packages.enums.AppDisplay;
import packages.enums.DataProviderType;

public class Config
{
    public static AppDisplay AppDisplayMode = AppDisplay.console;
    public static Boolean IS_DEVELOPMENT = false;
    public static String HERO_TEXT_FILE_NAME = "hero-stats.txt";
    public static String HERO_DEFAULT_IMAGE_PATH = "src/main/java/packages/images/default-image.png";
    public static DataProviderType DATA_PROVIDER = DataProviderType.filedata;
    public static String DB_JDBC_DRIVER = "com.mysql.jdbc.Driver";//"oracle.jdbc.driver.OracleDriver";//
    public static String DB_URL = "jdbc:mysql://localhost/";
    public static String DB_NAME = "test";
    public static String DB_USER_NAME = "root";
    public static String DB_USER_PASSWORD = "";

    public static void init(String[] configs)
    {
        if (configs.length > 0)
        {
            for (String config: configs)
            {
                config = config.trim();

                if (config != null)
                {
                    if (config.equalsIgnoreCase("gui") || config.equalsIgnoreCase("console"))
                        Config.setAppDisplay(config);
                    if (config.equalsIgnoreCase("dev"))
                        Config.IS_DEVELOPMENT = true;
                }
            }
        }
    }

    //#region setters
    public static void setAppDisplay(String appDisplay)
    {
        try
        {
            AppDisplayMode = AppDisplay.valueOf(appDisplay);
        } catch (Exception e) {}
    }
    //#endregion
}
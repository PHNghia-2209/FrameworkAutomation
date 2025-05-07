package base_def;

public class VariableManager {
    public static String USERNAME;
    public static String PASSWORD;

    //File Path
    public static String CONFIG_FILE = "src/test/resources/config/data_info.yml";
    public static int TIMEOUT = 90;
    public static String CHROME_DRIVER = "src/test/resources/divers/chromedriver.exe";


    public enum ENV {
        data
    }
}

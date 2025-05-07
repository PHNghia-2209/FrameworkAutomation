package base_def;

import org.openqa.selenium.WebDriver;
import utils.ConfigReader;

public class TestBase {
    public WebDriver driver;
    public static ConfigReader configReader = new ConfigReader();
    public static String env = "data";
    public static String browser = "data";

    public synchronized WebDriver initWebDriver() {
        driver = DriverFactory.getDriver();
        configReader = new ConfigReader();
        return driver;
    }
}

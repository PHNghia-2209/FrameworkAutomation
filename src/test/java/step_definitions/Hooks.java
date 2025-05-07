package step_definitions;

import base_def.TestBase;
import base_def.VariableManager;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import pages.CommonPage;
import utils.ConfigReader;
import io.cucumber.java.Before;

import java.io.FileNotFoundException;

public class Hooks extends TestBase{
    static int RUNNING_COUNT = 0;
    public static WebDriver driver;
    boolean IS_UI_TESTING = false;

    @Before(value = "@ui-config", order = 1)
    public void uiConfig() throws FileNotFoundException {
        IS_UI_TESTING = true;
        settingEnv(env, configReader);
    }

    @Before(value = "@ui-login", order = 0)
    public void uiLogin() throws InterruptedException, FileNotFoundException {
        uiConfig();
        RUNNING_COUNT++;
        CommonPage.processLogin();
    }

    private void settingEnv(String env, ConfigReader config) throws FileNotFoundException {
        if (IS_UI_TESTING){
            TestBase testBase = new TestBase();
            driver = testBase.initWebDriver();
            driver.get(configReader.getSetting(env, "url"));
        }
        VariableManager.USERNAME = config.getSetting(env, "username");
        VariableManager.PASSWORD = config.getSetting(env, "password");

    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

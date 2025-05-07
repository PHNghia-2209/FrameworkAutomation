package base_def;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;
public class DriverFactory {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() != null && ((RemoteWebDriver) driver.get()).getSessionId() != null) {
            return driver.get();
        }

        String browser = System.getProperty("browser", "chrome").toLowerCase(); // default = chrome

        switch (browser) {
            case "firefox" -> driver.set(initializeAndGetFirefoxDriver());
            case "chrome" -> driver.set(initializeAndGetChromeDriver());
            default -> throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        return driver.get();
    }

    private static WebDriver initializeAndGetChromeDriver() {
        System.setProperty("webdriver.chrome.driver", VariableManager.CHROME_DRIVER);

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        configureDriver(driver);
        System.out.println("Chrome WebDriver initialized successfully.");
        return driver;
    }

    private static WebDriver initializeAndGetFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", VariableManager.CHROME_DRIVER);

        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);
        configureDriver(driver);
        return driver;
    }

    private static void configureDriver(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }

}

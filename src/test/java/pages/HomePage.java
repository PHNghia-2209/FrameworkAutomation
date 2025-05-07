package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    CommonPage commonPage;
    WebDriver driver;

    //xpath
    public By btnLogin = By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/div[1]/form/p[3]/input[3]");
    public By inputEmail = By.id("username");
    public By inputPassword = By.id("password");

    public HomePage(WebDriver webDriver) {
        this.driver = webDriver;
        commonPage = new CommonPage(driver);
    }

    public void login(String username, String password) throws InterruptedException {
        commonPage.waitForElementVisible(btnLogin);
        commonPage.sendKeyToForFill(inputEmail, username);
        commonPage.sendKeyToForFill(inputPassword, password);
        Thread.sleep(1000);
        commonPage.clickOnElement(btnLogin);
    }
}

package step_definitions;

import base_def.DriverFactory;
import base_def.VariableManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.CommonPage;
import pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginStep {
    WebDriver driver;
    CommonPage commonPage;
    HomePage homePage;

    public LoginStep() {
        driver = DriverFactory.getDriver();
        commonPage = new CommonPage(driver);
        homePage = new HomePage(driver);
    }

    @Given("I am on the Website page")
    public void iAmOnTheWebsitePage() {
        commonPage.assertValueByText(By.xpath("/html/body/div[1]/div[1]/header/div[2]/nav/ul/li[1]/a"),"Shop");
    }

    @When("Input valid email and password and hit Login button")
    public void inputValidEmailAndPasswordAndHitLoginButton() throws InterruptedException {
        Thread.sleep(2000);
        commonPage.clickOnElement(By.xpath("/html/body/div[1]/div[1]/header/div[2]/nav/ul/li[2]/a"));
        homePage.login(VariableManager.USERNAME,VariableManager.PASSWORD);
    }

    @Then("Login successful")
    public void loginSuccessful() {
        commonPage.assertValueByText(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/p[1]/strong"),"nghiatui2233");
    }
}

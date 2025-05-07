package step_definitions;

import base_def.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.CommonPage;
import pages.HomePage;

import static org.junit.Assert.assertEquals;

public class CheckEmailStep {
    WebDriver driver;
    CommonPage commonPage;
    HomePage homePage;
    public CheckEmailStep() {
        driver = DriverFactory.getDriver();
        commonPage = new CommonPage(driver);
        homePage = new HomePage(driver);
    }
    @Given("I am logged in")
    public void iLoggedIn() {
        commonPage.assertValueByText(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/p[1]/strong"),"nghiatui2233");
    }

    @When("I check Email Address is {string}")
    public void iCheckEmailAddressIs(String arg0) {
        commonPage.assertValueByText(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/p[1]/strong"),arg0);
    }

    @Then("Email is{string}")
    public void emailIs(String arg0) {
        commonPage.assertValueByText(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/div/p[1]/strong"),arg0);

    }
}

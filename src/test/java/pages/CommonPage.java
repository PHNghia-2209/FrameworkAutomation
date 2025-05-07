package pages;

import base_def.VariableManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import step_definitions.LoginStep;

import java.time.Duration;
import java.util.List;

public class CommonPage {
    WebDriver driver;
    public static WebDriverWait wait;
    Actions action;
    JavascriptExecutor jsExecutor;

    public CommonPage(WebDriver webDriver){
        this.driver = webDriver;
        action = new Actions(driver);
        jsExecutor = (JavascriptExecutor) driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(VariableManager.TIMEOUT));
    }

    public static void processLogin() throws InterruptedException {
        LoginStep loginStep = new LoginStep();
        loginStep.inputValidEmailAndPasswordAndHitLoginButton();
        Thread.sleep(2000);
    }

    public void clickOnElement(By by){
        WebElement element = driver.findElement(by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public void clickOnElement(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
    public WebElement findElement (By by){
        return driver.findElement(by);
    }
    public By findElementByXpath(String locator){
        return By.xpath(locator);
    }
    public void doubleClick(By by){
        action.doubleClick(findElement(by)).perform();
    }
    public void sendKeyToForFill(WebElement element, String valueToSend){
        element.clear();
        element.sendKeys(valueToSend);
    }
    public void sendKeyToForFill(By by, String valueToSend) {
        driver.findElement(by).sendKeys(valueToSend);
    }

    public void sendKeyToFormatFill(By by, String valueToSend){
        findElement(by).sendKeys(valueToSend);
    }
    public void assertValueByText(By by, String expectedValue){
        Assert.assertEquals(findElement(by).getText(), expectedValue);
    }
    public void waitForElementClickable(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }
    public String getTextElement(By by){
        return findElement(by).getText();
    }
    public String getAttributeValue(By by){
        return findElement(by).getAttribute("value");
    }
    public boolean checkElementEnable(By by){
        try{
            return driver.findElement(by).isEnabled();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
    public boolean checkElementPresent(By by){
        try{
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
    public boolean isSelected(By by){
        try{
            return driver.findElement(by).isSelected();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
    public boolean isSelected(WebElement element){
        try{
            return element.isSelected();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
    public List<WebElement> findElements(By by){
        return driver.findElements(by);
    }
    public int countElements(By by){
        return findElements(by).size();
    }

//    functions wait
    public void waitForElementVisible(By by){
        try{
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(by)));
        } catch (NoSuchElementException ex) {
            System.out.println("Element " + by + " not exist");
        }
    }
    public void waitForAttributeToBeNotEmpty(By by){
        try{
            wait.until(ExpectedConditions.attributeToBeNotEmpty(driver.findElement(by), "class"));
        } catch (NoSuchElementException ex) {
            System.out.println("Attribute " + by + " not exist");
        }
    }
    public void waitTextToBe(By by, String text){
        try{
            wait.until(ExpectedConditions.textToBe(by, text));
        } catch (NoSuchElementException ex) {
            System.out.println("Element not exist");
        }
    }
    public void waitForElementInvisible(By by){
        try{
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(by)));
        } catch (NoSuchElementException ex) {
            System.out.println("Element " + by +  " not exist");
        }
    }
    public void waitForElementPresenceLocated(By by){
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (NoSuchElementException ex) {
            System.out.println("Element not exist");
        }
    }
    public void waitForAttributeToBeNotEmpty(WebElement element, String attribute){
        try{
            wait.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
        } catch (NoSuchElementException ex) {
            System.out.println("Element not exist");
        }
    }

}

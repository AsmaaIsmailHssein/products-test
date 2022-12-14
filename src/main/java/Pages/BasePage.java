package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
    }
    public WebElement locateElement(By elementLocator)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        wait.until(ExpectedConditions.elementToBeClickable(elementLocator));
        return driver.findElement(elementLocator);
    }
    public void clickElement(By elementLocator)
    {
        locateElement(elementLocator).click();
    }

    public String getTextOfElement(By elementLocator)
    {
        return locateElement(elementLocator).getText();
    }

    public void typeOnInputField(By elementLocator,String text)
    {
        locateElement(elementLocator).sendKeys(text);
    }
    public boolean isElementDisplay(By elementLocator)
    {
        return locateElement(elementLocator).isDisplayed();
    }
    public String getCssColorValue(By elementLocator)
    {
       return locateElement(elementLocator).getCssValue("color");
    }


}

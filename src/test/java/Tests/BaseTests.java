package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class BaseTests {

    WebDriver driver;

    @BeforeMethod
    public void initializationSetup()
    {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationexercise.com/");
    }
    @AfterMethod
    public void a_TakeFailureScreenShot(ITestResult result)
    {
        if (result.getStatus() == ITestResult.FAILURE)
        {
            File screenshots = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenshots, new File("./screenshots/" +result.getName()+  ".png"));
            } catch (IOException e)
            {
                System.out.println("there are something wrong");
            }
        }
    }
    @AfterMethod
    public void z_QuitDriver()
    {
        driver.quit();
    }
}

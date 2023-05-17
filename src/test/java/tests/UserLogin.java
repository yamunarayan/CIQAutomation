package tests;

import io.cucumber.core.internal.com.fasterxml.jackson.databind.ser.Serializers;
import org.ciq.ConfigLoader;
import org.ciq.ElementActionsImpl;
import org.ciq.WebDriverImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.grid.config.Config;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;

public class UserLogin extends BaseTest {


    @Test
    public void test(){
        WebDriver driver = launchBrowser();
        WebDriverImpl wdMethods = new WebDriverImpl(driver);
        ConfigLoader configLoader = new ConfigLoader();
        //  ElementActionsImpl elementActions = new ElementActionsImpl(driver);
        driver.get(configLoader.getConfigValue("url"));
        WebElement firstName = wdMethods.locateElement("xpath", "//input[@type='text']");
        wdMethods.enterText(firstName,"first name");
        WebElement lastName = wdMethods.locateElement("xpath", "(//input[@type='text'])[2]");
        wdMethods.enterText(lastName,"last name");


     //   driver.findElement(By.xpath("//input[@type='text']")).sendKeys("abc");
     //   driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("last name");



    }
}

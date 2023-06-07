package tests;

import io.qameta.allure.Flaky;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import pages.RegisterPage;
import utils.ConfigLoader;
import utils.WebDriverImpl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class UserLogin extends BaseTest {


    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void test(){
        WebDriver driver = launchBrowser();
        RegisterPage registerPage=new RegisterPage( driver);
        driver.get(ConfigLoader.getConfigValue("url"));
        registerPage.enterFirstName();
        registerPage.enterLastName();
       // Assert.assertEquals("",driver.getTitle());
    }
}

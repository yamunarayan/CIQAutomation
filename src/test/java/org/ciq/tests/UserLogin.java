package org.ciq.tests;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.ciq.pages.RegisterPage;
import org.ciq.utils.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class UserLogin extends BaseTest {


    @Test(groups = {"smoke"})
    @Severity(SeverityLevel.CRITICAL)
    public void test(){
        WebDriver driver = launchBrowser();
        RegisterPage registerPage=new RegisterPage( driver);
        driver.get(ConfigLoader.getConfigValue("url"));
        registerPage.enterFirstName();
        registerPage.enterLastName();
     //   Assert.assertEquals("",driver.getTitle());
    }

    @Test(groups = {"sanity"})
    @Severity(SeverityLevel.CRITICAL)
    public void test1(){
        WebDriver driver = launchBrowser();
        RegisterPage registerPage=new RegisterPage( driver);
        driver.get(ConfigLoader.getConfigValue("url"));
        registerPage.enterFirstName();
        registerPage.enterLastName();
      //  Assert.assertEquals("Register",driver.getTitle());
    }

    @Test(groups = {"regression"})
    @Severity(SeverityLevel.CRITICAL)
    public void test2(){
        WebDriver driver = launchBrowser();
        RegisterPage registerPage=new RegisterPage( driver);
        driver.get(ConfigLoader.getConfigValue("url"));
        registerPage.enterFirstName();
        registerPage.enterLastName();
     //   Assert.assertEquals("Register",driver.getTitle());
    }
}

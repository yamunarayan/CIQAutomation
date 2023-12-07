package org.ciq.tests;

import io.qameta.allure.Step;
import org.ciq.pages.LoginPage;
import org.ciq.pages.NavigatorHomePage;
import org.ciq.utils.ConfigLoader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.ciq.utils.AllureConfigurator;
import org.ciq.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {


    @Step("launching the browser")
    public WebDriver launchBrowser(){
        
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-notifications");
        ChromeDriver driver=new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(ConfigLoader.getConfigValue("implicitWait"))));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(ConfigLoader.getConfigValue("pageLoadTimeOut"))));
        driver.manage().window().maximize();
        DriverFactory.getInstance().setDriver(driver);
        return DriverFactory.getInstance().getDriver();
    }

    @BeforeSuite
    public void configuringLog4j() throws IOException {
        AllureConfigurator.configure();
    }

    @AfterMethod(alwaysRun = true)
    @Step("closing the browser")
    public void tearDownBrowser(){
       // DriverFactory.getInstance().getDriver().quit();
    }

    public WebDriver launchAppAndLogin(String url){
        WebDriver driver = launchBrowser();
        driver.get(ConfigLoader.getConfigValue(url));
        LoginPage loginPage = new LoginPage(driver);
        NavigatorHomePage navigatorHomePage = new NavigatorHomePage(driver);
        loginPage.enterUserName(ConfigLoader.getConfigValue("userEmail"));
        loginPage.enterPassWord(ConfigLoader.getConfigValue("password"));
        loginPage.submit();
        return driver;
    }


    public WebDriver launchAppAndSurveyLogin(){
        WebDriver driver = launchBrowser();
        driver.get(ConfigLoader.getConfigValue("surveyUrl"));
        LoginPage loginPage = new LoginPage(driver);
        NavigatorHomePage navigatorHomePage = new NavigatorHomePage(driver);
        loginPage.enterUserName(ConfigLoader.getConfigValue("surveyUser"));
        loginPage.enterPassWord(ConfigLoader.getConfigValue("surveyPwd"));
        loginPage.submit();
        return driver;
    }
}

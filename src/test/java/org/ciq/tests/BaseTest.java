package org.ciq.tests;

import io.qameta.allure.Step;
import org.ciq.pages.LoginPage;
import org.ciq.pages.NavigatorHomePage;
import org.ciq.utils.ConfigLoader;
import org.openqa.selenium.*;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v117.network.Network;
import org.openqa.selenium.devtools.v117.network.model.Headers;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.ciq.utils.AllureConfigurator;
import org.ciq.utils.DriverFactory;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;

import java.io.IOException;
import java.time.Duration;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

    public WebDriver launchAppAndDelphiLogin(String url){
        ChromeDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        String username = ConfigLoader.getConfigValue("delphiUserName");
        String password = ConfigLoader.getConfigValue("delphiPassword");
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        String auth = username + ":" + password;
        String encodeToString = Base64.getEncoder().encodeToString(auth.getBytes());
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", "Basic " + encodeToString);
        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));
        driver.get(ConfigLoader.getConfigValue(url));
        return driver;
    }



}

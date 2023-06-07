package tests;

import io.qameta.allure.Step;
import org.testng.annotations.BeforeSuite;
import utils.AllureConfigurator;
import utils.DriverFactory;
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
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
        DriverFactory.getInstance().getDriver().close();
    }
}

package tests;

import org.ciq.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {

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

    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser(){
        DriverFactory.getInstance().getDriver().close();
    }
}

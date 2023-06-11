package org.ciq.tests;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.ciq.pages.LoginPage;
import org.ciq.pages.NavigatorHomePage;
import org.ciq.pages.ScreeningResultsPage;
import org.ciq.utils.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CIQTest  extends BaseTest {

    @Test
    public void launcCIQ() throws InterruptedException {
        String firstName="cjb";
        WebDriver driver = launchAppAndLogin();
        NavigatorHomePage navigatorHomePage = new NavigatorHomePage(driver);
        ScreeningResultsPage screeningResultsPage = new ScreeningResultsPage(driver);
        Thread.sleep(15000);
        navigatorHomePage.enterNameToSearch(firstName);
        navigatorHomePage.clickOnMatchingRecord(firstName);
        screeningResultsPage.clickDashBoard();
        Thread.sleep(2000);
        navigatorHomePage.clickOnProfileButton();
        navigatorHomePage.clickOnlogOuteButton();
        Thread.sleep(10000);
    }
}

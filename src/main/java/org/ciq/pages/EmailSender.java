package org.ciq.pages;

import io.qameta.allure.Step;
import org.checkerframework.checker.units.qual.C;
import org.ciq.utils.WebDriverMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.security.Key;

public class EmailSender {
    WebDriver driver;
    WebDriverMethods  webDriverMethods;

    public EmailSender(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);
        webDriverMethods = new WebDriverMethods(driver);
    }

    @Step("send email")
    public EmailSender sendEmail() {
        String email = "yjayaraman@canceriq.com";
        String password = "AcerdLenl@123";

        String emailSubject = ": Complete Your Screening Questionnaire";

        try{
            WebElement emailField = webDriverMethods.waitForElementTobeClickable("//input[@type='email']");
            emailField.sendKeys(email);
            emailField.sendKeys(Keys.RETURN);
            Thread.sleep(10000);
            WebElement emailField1 = webDriverMethods.waitForElementTobeClickable("//input[@type='email']");
            emailField1.sendKeys(email);
            emailField1.sendKeys(Keys.RETURN);



            WebElement passwordField = webDriverMethods.waitForElementTobeClickable("//input[@type='password']");
            passwordField.sendKeys(password);
            passwordField.sendKeys(Keys.RETURN);

            //webDriverMethods.waitForElementTobeClickable("//input[@type='checkbox']").click();
            webDriverMethods.waitForElementTobeClickable("//span[text()='Try another way']//ancestor::button").click();
            webDriverMethods.waitforElementToLoad();
            webDriverMethods.waitForElementTobeClickable("//div[text()='Get a verification code from the ']").click();
            WebElement searchBox = webDriverMethods.waitForElementTobeClickable("//div[@id='searchBoxId-Mail']");
            searchBox.sendKeys("subject:" + emailSubject);
            searchBox.sendKeys(Keys.RETURN);
            webDriverMethods.waitforElementToLoad();

            try{
                WebElement emailLink = webDriverMethods.locateElement("partiallinktext",emailSubject);
                emailLink.click();
                webDriverMethods.waitforElementToLoad();
            }catch(Exception e){
                System.out.println("Email with subject" + emailSubject + "not found");
            }
        }catch(Exception e){
            e.printStackTrace();

        }
        return this;
    }
}

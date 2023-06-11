package org.ciq.pages;

import io.qameta.allure.Step;
import org.apache.commons.logging.Log;
import org.ciq.utils.WebDriverMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {

    WebDriver driver;
    WebDriverMethods webDriverMethods;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);
        webDriverMethods = new WebDriverMethods(driver);
    }

    @FindBy(xpath = "//input[@name='email']")
    WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;

    @Step("entering user email")
    public void enterUserName(String emailText) {
        webDriverMethods.enterText(email,emailText);
    }

    @Step("entering password")
    public void enterPassWord(String passwordText) {
        webDriverMethods.enterText(password, passwordText);
    }

    @Step("clicking,submit button")
    public void submit() {
        webDriverMethods.click(submit);
    }
}

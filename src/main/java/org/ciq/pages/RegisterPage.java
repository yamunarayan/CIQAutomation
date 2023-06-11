package org.ciq.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.ciq.utils.ElementActionsImpl;
import org.ciq.utils.WebDriverMethods;

public class RegisterPage {

    public WebDriver driver;

    public WebDriverMethods webDriverMethods;




    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,15), this);
        webDriverMethods =new WebDriverMethods(driver);
    }

    @FindBy(xpath = "//input[@type='text']")
    private WebElement firstName;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    private WebElement lastName;

    @Step("entering first name")
    public void enterFirstName() {
        webDriverMethods.enterText(firstName,"first name");
    }

    @Step("entering last name")
    public void enterLastName() {
        webDriverMethods.enterText(lastName,"first name");

    }
}

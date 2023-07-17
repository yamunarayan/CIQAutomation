package org.ciq.pages;

import io.qameta.allure.Step;
import org.ciq.utils.WebDriverMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegistryPage {

    WebDriver driver;
    WebDriverMethods webDriverMethods;

    public RegistryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        webDriverMethods = new WebDriverMethods(driver);
    }

    @Step("click on patient record")
    public RegistryPage clickPatientRecord(String firstName, String lastName) {
        webDriverMethods.waitForElementTobeClickable("//div[text()[normalize-space()='"+firstName+"'] and text()[normalize-space()='"+lastName+"']]").click();
        return this;
    }
}

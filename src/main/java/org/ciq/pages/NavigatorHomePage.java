package org.ciq.pages;

import io.qameta.allure.Step;
import org.ciq.utils.WebDriverMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class NavigatorHomePage {

    WebDriver driver;
    WebDriverMethods webDriverMethods;

    public NavigatorHomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);
        webDriverMethods = new WebDriverMethods(driver);
    }

    @FindBy(xpath = "//button[@type='button']")
    WebElement button;

    @FindBy(xpath = "//button[text()='Save']")
    WebElement save;

    @FindBy(xpath = "//input[@type='text']")
    WebElement searchByNameOrDob;

    @FindBy(xpath = "//div[@class='btn-group']/button[@class='btn btn-default btn-outline dropdown-toggle']")
    WebElement profileButton;

    @FindBy(xpath = "//a[text()=' Log Out']")
    WebElement logOutBtn;



    @Step("clicking on profile button")
    public void clickButton() {
        webDriverMethods.click(button);
    }

    @Step("save profile")
    public void clickSave() {
        webDriverMethods.click(save);
    }

    @Step("search by name")
    public void enterNameToSearch(String name) {
        webDriverMethods.enterText(searchByNameOrDob, name);
    }

    @Step("clicking on profile button")
    public void clickOnProfileButton() {
        webDriverMethods.click(profileButton);
    }

    @Step("clicking on logout button")
    public void clickOnlogOuteButton() {
        webDriverMethods.click(logOutBtn);
    }

    @Step("clicking on matching record")
    public void clickOnMatchingRecord(String firstName) {
        String xpath="//a[text()='"+firstName+"']";
        WebElement webElement = webDriverMethods.locateElement("xpath", xpath);
        webDriverMethods.click(webElement);
    }
}

package org.ciq.pages;

import io.qameta.allure.Step;
import org.ciq.utils.WebDriverMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ScreeningResultsPage {

    WebDriver driver;
    WebDriverMethods webDriverMethods;

    public ScreeningResultsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);
        webDriverMethods = new WebDriverMethods(driver);
    }

    @FindBy(xpath = "//li[@id='patientNav']")
    WebElement navList;

    @FindBy(xpath = "//li[@id='patientNav']//a")
    WebElement dashBoardLink;


    public void clickDashBoard(){
        webDriverMethods.click(dashBoardLink);
    }

}

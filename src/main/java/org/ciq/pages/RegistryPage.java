package org.ciq.pages;

import io.qameta.allure.Step;
import org.ciq.utils.WebDriverMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import java.util.Arrays;
import java.util.List;

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
        webDriverMethods.waitForElementTobeClickable("//div[text()[normalize-space()='" + firstName + "'] and text()[normalize-space()='" + lastName + "']]").click();
        return this;
    }

    @Step("validate patient eligibilities..")
    public RegistryPage validateListOfPatientEligibilities(String eligibilities) {

        List<String> list = Arrays.asList(eligibilities.split(","));
        List<WebElement> eligibilityEle = webDriverMethods.waitForElementsVisibility( "//div[starts-with(@class,'MuiBox-root']//ul//li//h2");
        Assert.assertTrue(list.size()== eligibilityEle.size(),"expected and actual eligibilities doesn't match");

        for (int i=0;i<list.size();i++){
            String text = eligibilityEle.get(i).getText();
            Assert.assertTrue(list.contains(text), "eligibility " + text
                    + " is not present in the expected list of eligibilities");
        }
                return this;
    }
}

package org.ciq.pages;

import io.qameta.allure.Step;
import org.ciq.utils.WebDriverMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AmericanCancerSocietyPage {

    WebDriver driver;
    WebDriverMethods webDriverMethods;

    public AmericanCancerSocietyPage (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);
        webDriverMethods= new WebDriverMethods(driver);
    }

    @Step("click take the survey")
    public AmericanCancerSocietyPage clickTakeTheSurvey() {
        webDriverMethods.waitForElementTobeClickable("//a[contains(text(),'Take the survey')]").click();
        webDriverMethods.switchToChildWindow("Clinical Questionnaire App");
        return this;
    }

    @Step("navigate to survey page ")
    public SurveyPage navigateToSurveyPage(){
                    return new SurveyPage(driver);
    }

}

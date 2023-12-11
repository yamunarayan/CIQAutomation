package org.ciq.pages;

import io.qameta.allure.Step;
import org.ciq.utils.WebDriverMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import java.util.List;

public class DelphiPage {
    WebDriver driver;
    WebDriverMethods webDriverMethods;

    public DelphiPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        webDriverMethods = new WebDriverMethods(driver);
    }

    @Step("Check home page loading")
    public DelphiPage checkHomePage(String headerField, String dashboardField, String dashboardLink) {
        String headerName = webDriverMethods.waitForElementTobeClickable("//h1[contains(text(),'"+headerField+"')]").getText();
        Assert.assertEquals(headerName,headerField);
        String dashBoardName = webDriverMethods.waitForElementTobeClickable("//li[contains(text(),'"+dashboardField+"')]").getText();
        Assert.assertEquals(dashBoardName,dashboardField);
        String dashBoardLink = webDriverMethods.waitForElementTobeClickable("//span[contains(text(),'"+dashboardLink+"')]").getText();
        Assert.assertEquals(dashBoardLink,dashboardLink);
        return this;
    }

    @Step("Check home page link")
    public DelphiPage checkHomePageLink(String LinkName1, String LinkName2, String LinkName3, String LinkName4, String LinkName5) {
        String applicationLink = webDriverMethods.waitForElementTobeClickable("//a[contains(text(),'Application')]").getText();
        Assert.assertEquals(applicationLink,LinkName1);
        String locationThemeLink = webDriverMethods.waitForElementTobeClickable("//a[contains(text(),'Location themes')]").getText();
        Assert.assertEquals(locationThemeLink,LinkName2);
        String questionsLink = webDriverMethods.waitForElementTobeClickable("//a[contains(text(),'Questions')]").getText();
        Assert.assertEquals(questionsLink,LinkName3);
        String surveysLink = webDriverMethods.waitForElementTobeClickable("//a[contains(text(),'Surveys')]").getText();
        Assert.assertEquals(surveysLink,LinkName4);
        String surveyModulesLink = webDriverMethods.waitForElementTobeClickable("//a[contains(text(),'Survey modules')]").getText();
        Assert.assertEquals(surveyModulesLink,LinkName5);
        return this;
    }

    @Step("click add new button")
    public DelphiPage clickAddnew(){
        webDriverMethods.waitForElementTobeClickable("//span[contains(text(),'Add new')]").click();
        return this;
    }

    @Step("click add new item button")
    public DelphiPage clickAddNewItem(){
        webDriverMethods.waitForElementTobeClickable("//a[@title='Add new']").click();
        return this;
    }

    @Step("navigate to page")
    public DelphiPage navigateToPages(String fieldName){
        webDriverMethods.waitForElementTobeClickable("//a[contains(text(),'"+fieldName+"')]").click();
        return this;
    }

    @Step("click cancel")
    public DelphiPage clickCancel(){
        webDriverMethods.waitForElementTobeClickable("//button[@data-disable-with='Cancel']").click();
        return this;
    }

    @Step("click cancel")
    public DelphiPage clickCancelWithScroll(){
        WebElement ele = webDriverMethods.locateElement("xpath","//button[@data-disable-with='Cancel']");
        webDriverMethods.scrollToView(ele);
        return this;
    }

    @Step("click edit")
    public DelphiPage clickEdit(){
        webDriverMethods.waitForElementTobeClickable("(//li[@title='Edit'])[1]").click();
        return this;
    }

    @Step("click chooseall")
    public DelphiPage clickChooseAll(){
        webDriverMethods.waitForElementTobeClickable("//a[text()='Choose all']").click();
        return this;
    }
    @Step("select multi select option" )
    public DelphiPage selectOptioninMultiSelectBox(){
        webDriverMethods.waitForElementTobeClickable("//select[@multiple = 'multiple']//option").click();
        return this;
    }

    @Step("check selected items in multi select option" )
    public DelphiPage checkSelectedOptionInMultiSelect(){
        List<WebElement> elements =webDriverMethods.locateElements("xpath","//select[@class='form-control ra-multiselect-selection']//option");
        int elementSize = elements.size();
        if(elementSize>0){

        }        return this;
    }

    @Step("navigate to applications page" )
    public DelphiPage navigateToApplications(String pageName, String searchText){
        navigateToPages(pageName);
        clickAddnew();
        WebElement searchTextSpace = webDriverMethods.waitForElementTobeClickable("(//div[@id='application_survey_ids_field']//child::div//input)[3]");
        webDriverMethods.enterText(searchTextSpace, searchText);
        selectOptioninMultiSelectBox();
        clickAddNewItem();
        checkSelectedOptionInMultiSelect();
        clickCancel();
        clickEdit();
        webDriverMethods.enterText(searchTextSpace, searchText);
        clickChooseAll();
        clickCancel();
        return this;
    }

    @Step("navigate to location themes page" )
    public DelphiPage navigateToLocationThemes(String pageName, String locationText, String dataText) throws InterruptedException {
        navigateToPages(pageName);
        clickAddnew();
        Thread.sleep(3000);
        WebElement LocationTextSpace = webDriverMethods.waitForElementTobeClickable("//input[@id='location_theme_location_id']");
        webDriverMethods.enterText(LocationTextSpace, locationText);
        WebElement dataTextSpace = webDriverMethods.waitForElementTobeClickable("//textarea[@id='location_theme_data']");
        webDriverMethods.enterText(dataTextSpace, dataText);
        clickCancel();
        clickEdit();
        clickCancel();
        return this;
    }

    @Step("navigate to questions page" )
    public DelphiPage navigateToQuestions(String pageName, String surveyModuleText) throws InterruptedException {
        navigateToPages(pageName);
        clickAddnew();
        WebElement surveyModuleSearch = webDriverMethods.waitForElementTobeClickable("(//div[@id='question_survey_module_ids_field']//child::div//input)[3]");
        webDriverMethods.enterText(surveyModuleSearch, surveyModuleText);
        selectOptioninMultiSelectBox();
        clickAddNewItem();
        checkSelectedOptionInMultiSelect();
        clickCancel();
        clickEdit();
        WebElement surveyEditModuleSearch = webDriverMethods.waitForElementTobeClickable("(//div[@id='question_survey_module_ids_field']//child::div//input)[3]");
        webDriverMethods.enterText(surveyEditModuleSearch, surveyModuleText);
        Thread.sleep(3000);
        clickChooseAll();
        clickCancel();
        return this;
    }

    @Step("navigate to surveys page" )
    public DelphiPage navigateToSurveys(String pageName, String surveyModuleText ) throws InterruptedException {
        navigateToPages(pageName);
        clickAddnew();
        WebElement surveyModuleSearch = webDriverMethods.waitForElementTobeClickable("(//div[@id='survey_survey_module_ids_field']//child::div//input)[3]");
        webDriverMethods.enterText(surveyModuleSearch, surveyModuleText);
        selectOptioninMultiSelectBox();
        clickAddNewItem();
        checkSelectedOptionInMultiSelect();
        clickCancelWithScroll();
        clickEdit();
        WebElement surveyEditModuleSearch = webDriverMethods.waitForElementTobeClickable("(//div[@id='survey_survey_module_ids_field']//child::div//input)[3]");
        webDriverMethods.enterText(surveyEditModuleSearch, surveyModuleText);
        clickChooseAll();
        clickCancelWithScroll();
        return this;
    }

    @Step("navigate to survey modules page" )
    public DelphiPage navigateToSurveyModules(String pageName, String questionText) throws InterruptedException {
        navigateToPages(pageName);
        clickAddnew();
        WebElement questionSearch = webDriverMethods.waitForElementTobeClickable("(//div[@id='survey_module_question_ids_field']//child::div//input)[3]");
        webDriverMethods.enterText(questionSearch, questionText);
        selectOptioninMultiSelectBox();
        clickAddNewItem();
        checkSelectedOptionInMultiSelect();
        WebElement surveySearch = webDriverMethods.waitForElementTobeClickable("(//div[@id='survey_module_survey_ids_field']//child::div//input)[3]");
        webDriverMethods.enterText(surveySearch, questionText);
        clickChooseAll();
        checkSelectedOptionInMultiSelect();
        clickCancelWithScroll();
        clickEdit();
        WebElement editSearchTextSpace = webDriverMethods.waitForElementTobeClickable("(//div[@id='survey_module_question_ids_field']//child::div//input)[3]");
        webDriverMethods.enterText(editSearchTextSpace, questionText);
        clickChooseAll();
        checkSelectedOptionInMultiSelect();
        WebElement surveyEditSearch = webDriverMethods.waitForElementTobeClickable("(//div[@id='survey_module_survey_ids_field']//child::div//input)[3]");
        webDriverMethods.enterText(surveyEditSearch, questionText);
        clickChooseAll();
        checkSelectedOptionInMultiSelect();
        clickCancelWithScroll();
        return this;
    }
}

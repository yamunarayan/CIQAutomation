package org.ciq.pages;

import io.qameta.allure.Step;
import org.ciq.utils.WebDriverMethods;
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

    @Step("navigate to specialist url portal for testing tab verification")
    public SpecialistPendingDashBoardPage navigateToSpecialistUrl(String url){

        try{
            webDriverMethods.openNextTabNavigateToUrl(url);
            Thread.sleep(15000);
            return new SpecialistPendingDashBoardPage(driver);
        }
        catch (Exception e){
            System.out.println("Exception has occurred..");
        }
        return new SpecialistPendingDashBoardPage(driver);
    }


    @Step("click on patient record")
    public RegistryPage clickPatientRecord(String firstName, String lastName) {
        webDriverMethods.waitForElementTobeClickable("//div[text()[normalize-space()='" + firstName + "'] and text()[normalize-space()='" + lastName + "']]").click();
        return this;
    }

    @Step("validate patient eligibilities..")
    public RegistryPage validateListOfPatientEligibilities(String eligibilities) {

        List<String> list = Arrays.asList(eligibilities.split(","));
        List<WebElement> eligibilityEle = webDriverMethods.waitForElementsVisibility( "//div[starts-with(@class,'MuiBox-root')]//ul//li//h2");
       // Assert.assertTrue(list.size()== eligibilityEle.size(),"expected and actual eligibilities doesn't match");
        //Adding test

        for (int i=0;i<list.size();i++){
            String text = eligibilityEle.get(i).getText();
            Assert.assertTrue(list.contains(text), "eligibility " + text
                    + " is not present in the expected list of eligibilities");
        }
                return this;
    }

    @Step("clicking create new patient")
    public RegistryPage clickCreateNewPatient() {
        webDriverMethods.waitForElementTobeClickable("//span[text()='Create New Patient']//ancestor::button").click();
        return this;
    }

    @Step("enter patient's first name in ithaca")
    public RegistryPage enterFirstName(String fName){
        WebElement firstName = webDriverMethods.waitForElementTobeClickable("//input[@id='patient-ame-first-input']");
        webDriverMethods.enterText(firstName,fName);
        return this;
    }

    @Step("enter patient's last name in ithaca")
    public RegistryPage enterLastName(String lName){
        WebElement lastName = webDriverMethods.waitForElementTobeClickable("//input[@id='patient-name-last-input']");
        webDriverMethods.enterText(lastName,lName);
        return this;
    }

    @Step("choose patient's sex in ithaca")
    public RegistryPage chooseBirthSex(String birthSex){
        webDriverMethods.waitForElementTobeClickable("//div[@id='birthSexInput']").click();
        webDriverMethods.waitForElementTobeClickable("//li[@data-value='"+birthSex+"']").click();
        return this;
    }

    @Step("enter month of birth in ithaca")
    public RegistryPage enterMonth(String month){
        WebElement monthField = webDriverMethods.waitForElementTobeClickable("//input[@placeholder='Month']");
        webDriverMethods.enterText(monthField,month);
        return this;
    }

    @Step("enter day of birth in ithaca")
    public RegistryPage enterDay(String day){
        WebElement dayField = webDriverMethods.waitForElementTobeClickable("(//input[@id='patient-name-input'])[2]");
        webDriverMethods.enterText(dayField,day);
        return this;
    }

    @Step("enter year of birth in ithaca")
    public RegistryPage enterYear(String year){
        WebElement yearField = webDriverMethods.waitForElementTobeClickable("//input[@placeholder='Year']");
        webDriverMethods.enterText(yearField,year);
        return this;
    }

    @Step("click submit in ithaca")
    public RegistryPage clickSubmit(){
        webDriverMethods.waitForElementTobeClickable("//span[text()='Submit']//ancestor::button").click();
        return this;
    }
    @Step("click on patient case in ithaca")
    public RegistryPage clickStartScreening() {
        webDriverMethods.waitForElementTobeClickable("//span[text()='Start Screening']//ancestor::button").click();
        return this;
    }

    @Step("click on prescreened referral in ithaca")
    public RegistryPage clickPatientCase(String field) {
        webDriverMethods.waitForElementTobeClickable("//button[@data-id='"+field+"']").click();
        return this;
    }

    @Step("select currentlysmokes details in ithaca")
    public RegistryPage selectCurrentlySmokes(String option,String field) throws InterruptedException {
       Thread.sleep(5000);
       WebElement ele = webDriverMethods.waitForElementTobeClickable("//label[text()='Currently Smokes']/following::div[@id='downshift-14-toggle-button']");
        //webDriverMethods.scrollToView(ele);
        ele.click();
        System.out.println(ele.getText());
        webDriverMethods.waitForElementTobeClickable("//div[@id='downshift-14-item-0']").click();
        return this;
    }

    @Step("enter years smoked in ithaca")
    public RegistryPage enterYearsSmoked(String yearsSmoked) {
        WebElement yearsSmokedN = webDriverMethods.waitForElementTobeClickable("//span[text()='Years Smoked']/following::input[1]");
        webDriverMethods.enterText(yearsSmokedN, yearsSmoked);
        return this;
    }

    @Step("enter number of packs per day in ithaca")
    public RegistryPage enterNumberOfPacks(String noOfPacks) {
        WebElement numberOfPacks = webDriverMethods.waitForElementTobeClickable("//span[text()='Number of Packs Per Day']/following::input");
        webDriverMethods.enterText(numberOfPacks, noOfPacks);
        return this;
    }

    @Step("click button in ithaca")
    public RegistryPage clickButton(String buttonName) {
        webDriverMethods.waitForElementTobeClickable("//span[text()='"+buttonName+"']//ancestor::button").click();
        return this;
    }

    @Step("check patient eligibility in ithaca")
    public RegistryPage checkPatientEligibility(String eligibilityScreening) {
        String eligibility = webDriverMethods.waitForElementTobeClickable("//h2[text()='"+eligibilityScreening+"']").getText();
        Assert.assertEquals(eligibility, eligibilityScreening);

        return this;
    }

    @Step("click add to care plan in ithaca")
    public RegistryPage clickAddCarePlan(String eligibility) {
        webDriverMethods.waitForElementTobeClickable("//h2[text()='"+eligibility+"']//following-sibling::div/button").click();
        return this;
    }

    @Step("click care plan tab in ithaca")
    public RegistryPage clickIthacaTab(String tabName) {
        webDriverMethods.waitForElementTobeClickable("//a[@role='tab' and @title='"+tabName+"']").click();
        return this;
    }

    @Step("check recommended added care plan in ithaca")
    public RegistryPage checkRecommendedCarePlan(String recommendedCarePlan) {
        String recommendedCarePlanIthaca = webDriverMethods.waitForElementTobeClickable("//h5[text()='"+recommendedCarePlan+"']").getText();
        Assert.assertEquals(recommendedCarePlanIthaca, recommendedCarePlan);
        return this;
    }

    @Step("add family member in screening results of ithaca")
    public RegistryPage addFamilyMember(String field, String type) {
        webDriverMethods.waitForElementTobeClickable("//h3[text()='"+field+"']//following::div//button[@data-testid='Button']").click();
        webDriverMethods.waitForElementTobeClickable("//h5[text()='"+type+"']//ancestor::label").click();
        return this;
    }

    @Step("select relationshipdetails in ithaca")
    public RegistryPage addRelationshipCancer(String dropdownName, String option, String age) throws InterruptedException {
        Thread.sleep(5000);
        WebElement dropdown = webDriverMethods.waitForElementTobeClickable("//label[text()='"+dropdownName+"']//ancestor::div/div[contains(@class,'default__StyledSelectDefault-sc-3ywncz-9')]");
        dropdown.click();
        WebElement dropdownvalueSelection = webDriverMethods.waitForElementTobeClickable("//label[text()='"+dropdownName+"']//parent::div//div[@data-testid='Select__SelectedItem']");
        webDriverMethods.selectDropDownByValue(dropdownvalueSelection,option);
        WebElement enterAgeOfDx= webDriverMethods.waitForElementVisibility("//input[@placeholder='Age of Dx']");
        webDriverMethods.enterText(enterAgeOfDx, age);
        return this;
    }



    @Step("scrolling down from {x} until {y}")
    public RegistryPage scrollDownByXY(int x, int y){
        webDriverMethods.scrollDown(x,y);
        return this;
    }


}

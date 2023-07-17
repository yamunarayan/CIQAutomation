package org.ciq.pages;

import io.qameta.allure.Step;
import org.ciq.utils.WebDriverMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.ArrayList;

public class SpecialistPendingDashBoardPage {

    WebDriver driver;
    WebDriverMethods webDriverMethods;

    public SpecialistPendingDashBoardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        webDriverMethods = new WebDriverMethods(driver);
    }


    @Step("clicking create patient button")
    public SpecialistPendingDashBoardPage clickCreatePatientButton() {
        webDriverMethods.waitForElementTobeClickable("//button[text()[normalize-space()='Create Patient']]").click();
        return this;
    }

    @Step("click on patient record in pending dashboard")
    public SpecialistPendingDashBoardPage clickPatientRecord(String patientName) {
        webDriverMethods.waitForElementTobeClickable("//a[text()='"+patientName+"']").click();
        return this;
    }

    @Step("click on review patient case")
    public SpecialistPendingDashBoardPage clickReviewPatient() {
        webDriverMethods.waitForElementTobeClickable("//p[text()[normalize-space()='Review Patient Case']]").click();
        return this;
    }

    @Step("click on {tab} tab")
    public SpecialistPendingDashBoardPage clickPatientNavigationTab(String tab) {
        webDriverMethods.waitForElementTobeClickable("//li[@id='patientNav']//a//span[contains(text(),'"+tab+"')]").click();
        return this;
    }

    @Step("scroll up to the element and click edit button")
    public SpecialistPendingDashBoardPage scrollToElementAndClick(String section) {
        //span[text()='Specialist-Entered Patient Info']
        WebElement spPatient = webDriverMethods.waitForElementTobeClickable(" //span[text()='"+section+"']//parent::center//parent::div//parent::div//button[text()='Edit']");
      //  JavascriptExecutor js= (JavascriptExecutor) webDriverMethods;
       // js.executeScript("arguments[0].scrollIntoView(true);",spPatient);
        spPatient.click();
        return this;
    }

    @Step("click Add {type} button")
    public SpecialistPendingDashBoardPage clickAnyAddButton(String type) {
        webDriverMethods.waitForElementTobeClickable("//button[text()[normalize-space()='"+type+"']]").click();
        return this;
    }

    @Step("choose cancer {type}")
    public SpecialistPendingDashBoardPage chooseCancer(String type) {
        WebElement cancerType = webDriverMethods.waitForElementTobeClickable("//div[text()[normalize-space()='Cancer:']]//parent::div//select[@class='form-control ng-pristine ng-untouched ng-valid']");
        webDriverMethods.selectDropDownByText(cancerType, type);
        return this;
    }
    @Step("enter age:- {age}")
    public SpecialistPendingDashBoardPage enterAgeOfDiagnosis(String age, int typeCount) {
        WebElement cancerType = webDriverMethods.waitForElementTobeClickable("(//div[text()[normalize-space()='Cancer:']]//ancestor::div[@class='well ng-scope']//div[text()[normalize-space()='Age of Diagnosis:']]//parent::div//div[2]//input[@type='number'])["+typeCount+"]");
        webDriverMethods.enterText(cancerType, age);
        return this;
    }

    @Step("choose {field} with option {text}")
    public SpecialistPendingDashBoardPage chooseBrestCancerAttributes(String field, String text) {
        WebElement cancerType = webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'"+field+":')]//parent::div//select[@class='form-control ng-pristine ng-untouched ng-valid']");
        webDriverMethods.selectDropDownByText(cancerType, text);
        return this;
    }

    @Step("click on save changes")
    public SpecialistPendingDashBoardPage clickSaveChanges() {
        webDriverMethods.waitForElementTobeClickable("//button[text()='Save Changes']").click();
        return this;
    }

    @Step("enter patient's first name in survey")
    public SpecialistPendingDashBoardPage enterFirstName(String fName){
        WebElement firstName = webDriverMethods.waitForElementTobeClickable("//input[@name='firstname']");
        webDriverMethods.enterText(firstName,fName);
        return this;
    }

    @Step("enter patient's last name in survey")
    public SpecialistPendingDashBoardPage enterLastName(String lName){
        WebElement lastName = webDriverMethods.waitForElementTobeClickable("//input[@name='lastname']");
        webDriverMethods.enterText(lastName,lName);
        return this;
    }

    @Step("choose patient's sex in survey")
    public SpecialistPendingDashBoardPage chooseGender(String gender){
        WebElement genderField = webDriverMethods.waitForElementTobeClickable("//select[@id='gender']");
        webDriverMethods.selectDropDownByText(genderField,gender);
        return this;
    }

    @Step("enter date of birth")
    public SpecialistPendingDashBoardPage enterDob(String dob){
        WebElement dobField = webDriverMethods.waitForElementTobeClickable("//input[@name='dob']");
        webDriverMethods.enterText(dobField,dob);
        return this;
    }

    @Step("choose patient's location in survey")
    public SpecialistPendingDashBoardPage chooseLocation(String location){
        WebElement loc = webDriverMethods.waitForElementTobeClickable("//select[@id='location']");
        webDriverMethods.selectDropDownByText(loc,location);
        return this;
    }

    @Step("enter patient's email in survey")
    public SpecialistPendingDashBoardPage enterEmail(String email){
        WebElement emailEle = webDriverMethods.waitForElementTobeClickable("//input[@name='email']");
        webDriverMethods.enterText(emailEle,email);
        return this;
    }

    @Step("enter patient's confirm email in survey")
    public SpecialistPendingDashBoardPage enterConfirmEmail(String email){
        WebElement confirmEmailEle = webDriverMethods.waitForElementTobeClickable("//input[@name='confirmation_email']");
        webDriverMethods.enterText(confirmEmailEle,email);
        return this;
    }

    @Step("choose patient's STAT in survey")
    public SpecialistPendingDashBoardPage chooseStatPatient(String stat){
        WebElement confirmEmailEle = webDriverMethods.waitForElementTobeClickable("//select[@id='stat_status']");
        webDriverMethods.selectDropDownByText(confirmEmailEle,stat);
        return this;
    }

    @Step("clicking next button")
    public SpecialistPendingDashBoardPage clickNext(){
        webDriverMethods.waitForElementTobeClickable("//button[text()='Next']").click();
        return this;

    }

    @Step("clicking skip & Add patient button")
    public SpecialistPendingDashBoardPage clickSkipAddPatient(){
        webDriverMethods.waitForElementTobeClickable("//button[text()='Skip & Add Patient ']").click();
        return this;

    }

    @Step("navigate to ethica portal for patient verification")
    public RegistryPage navigateToEthicaUrl(String url){

        try{
            webDriverMethods.openNextTabNavigateToUrl(url);
            Thread.sleep(15000);
            return new RegistryPage(driver);
        }
        catch (Exception e){
            System.out.println("Exception has occurred..");
        }
        return new RegistryPage(driver);
    }

    @Step("scrolling down from {x} until {y}")
    public SpecialistPendingDashBoardPage scrollDownByXY(int x, int y){
        webDriverMethods.scrollDown(x,y);
        return this;
    }



}

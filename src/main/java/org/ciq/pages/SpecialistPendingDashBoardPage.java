package org.ciq.pages;

import io.qameta.allure.Step;
import org.ciq.utils.WebDriverMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    @Step("validate HBOC and HCC test in testing tab")
    public SpecialistPendingDashBoardPage validateHbocAndHccStatus(String attributeName, String attributeValue1, String attributeValue2) throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> togglestatus = webDriverMethods.locateElements("xpath", "//i[contains(@ng-class,'meetsHBOCTesting')]//ancestor::div//span[contains(@class,'switch ng-valid')]");
        for(WebElement ele: togglestatus){
          String className =  ele.getAttribute(attributeName);
          Assert.assertEquals(className,attributeValue1);
        }

        List<WebElement> teststatus = webDriverMethods.locateElements("xpath", "//i[contains(@ng-class,'meets')]");
        for(WebElement ele: teststatus){
            String className =  ele.getAttribute(attributeName);
            Assert.assertEquals(className,attributeValue2);
        }
        return this;
    }

    @Step("check eligibilities in primary test selection panel")
    public SpecialistPendingDashBoardPage testSelectionPanelEligibilities(String field, String diagnosis) {
       String diagnosisName = webDriverMethods.waitForElementTobeClickable("//h4[text()='"+field+"']//following::input").getAttribute("value");
             Assert.assertEquals(diagnosisName,diagnosis);
              return this;
    }

    @Step("select vendors in testing tab")
    public SpecialistPendingDashBoardPage selectVendors(String field) {
       webDriverMethods.waitForElementTobeClickable("//h4[contains(text(),'Vendors')]//ancestor::div//button[contains(text(),'"+field+"')]").click();
       return this;
    }

    @Step("select test in testing tab")
    public SpecialistPendingDashBoardPage selecttest(String field) {
        webDriverMethods.waitForElementTobeClickable("//h4[contains(text(),'Select Test')]//following::div[contains(text(),'"+field+"')]").click();
        return this;
    }

    @Step("scroll up to the element and click edit button")
    public SpecialistPendingDashBoardPage scrollToElementAndClick(String section) {
        WebElement spPatient = webDriverMethods.waitForElementTobeClickable(" //span[text()='"+section+"']//parent::center//parent::div//parent::div//button[text()='Edit']");
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
    @Step("enter age of diagnosis for cancer{age}")
    public SpecialistPendingDashBoardPage enterAgeOfDiagnosis(String age, int typeCount) {
        WebElement cancerType = webDriverMethods.waitForElementTobeClickable("(//div[text()[normalize-space()='Cancer:']]//ancestor::div[@class='well ng-scope']//div[text()[normalize-space()='Age of Diagnosis:']]//parent::div//div[2]//input[@type='number'])["+typeCount+"]");
        webDriverMethods.enterText(cancerType, age);
        return this;
    }

    @Step("enter age of diagnosis for all type:- {age}")
    public SpecialistPendingDashBoardPage enterAgeOfDiagnosis( String age, int typeCount, String field) {
        WebElement diagnosisType = webDriverMethods.waitForElementTobeClickable("(//div[text()[normalize-space()='"+field+":']]//ancestor::div[@class='well ng-scope']//div[text()[normalize-space()='Age of Diagnosis:']]//parent::div//div[2]//input[@type='number'])["+typeCount+"]");
        webDriverMethods.enterText(diagnosisType, age);
        return this;
    }

    @Step("choose race {type}")
    public SpecialistPendingDashBoardPage chooseRace(String type, String field) {
        WebElement race = webDriverMethods.waitForElementTobeClickable("//div[text()[normalize-space()='"+field+":']]//parent::div//select");
        webDriverMethods.selectDropDownByText(race, type);
        return this;
    }

    @Step("choose sub race {type}")
    public SpecialistPendingDashBoardPage chooseSubRace(String type, String field) {
        WebElement subRace = webDriverMethods.waitForElementTobeClickable("//div[text()[normalize-space()='"+field+":']]//parent::div//select");
        webDriverMethods.selectDropDownByText(subRace, type);
        return this;
    }

    @Step("get surgery:- {surgery}")
    public SpecialistPendingDashBoardPage surgery(String surgeryName) {
        List<WebElement> webElements = webDriverMethods.waitForElementsVisibility("");
        for(WebElement ele:webElements){
            ele.getText().equalsIgnoreCase("surgeryName");
        }
        return this;
    }

    @Step("validate care plan")
    public SpecialistPendingDashBoardPage ValidateCarePlanEligibilities(String careplan) {

        clickPatientNavigationTab("Care Plan");
        String recommendedcareplan=webDriverMethods.waitForElementTobeClickable("//div[@class='panel-heading clearfix recommend_panel_heading']//h3[text()='"+careplan+"']").getText();
        if(recommendedcareplan.contains("Mammogram (Annual) - RECOMMENDED")){
            clickPatientNavigationTab("Risk Assessment");
            double gailPercentageValue = getGailScore();
            if (!(gailPercentageValue <17 )){
                Assert.assertEquals(recommendedcareplan,"Mammogram (Annual) - RECOMMENDED");
            }
        } else if (recommendedcareplan.contains("Aromatase Inhibitors (Anastrozole 1 mg/day or Exemestane 25mg/d for 5 years) - RECOMMENDED")) {
                Assert.assertEquals(recommendedcareplan,"Aromatase Inhibitors (Anastrozole 1 mg/day or Exemestane 25mg/d for 5 years) - RECOMMENDED");
        }
            return this;
    }

    @Step("capturing gail score")
    public double getGailScore(){
        String gailLifeTypeScore = webDriverMethods.waitForElementTobeClickable("//div[@class='risk_factor col-sm-12']//div[contains(text(),'Gail Lifetime')]").getText();
        Pattern pattern = Pattern.compile("\\b\\d+\\.\\d+\\b");
        Matcher matcher = pattern.matcher(gailLifeTypeScore);
        double gailPercentageValue = 0;
        if (matcher.find()) {
            String extractedgailScore = matcher.group();
            gailPercentageValue = Double.parseDouble(extractedgailScore);
            System.out.println(gailPercentageValue);
        }
        return gailPercentageValue;
    }

    @Step("enter age of menarche:- {age}")
    public SpecialistPendingDashBoardPage enterAgeOfMenarche(String text, String field) {
        WebElement menarche = webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'"+field+":')]//parent::div//div[2]/input[@class='form-control ng-pristine ng-untouched ng-valid ng-valid-min']");
        webDriverMethods.enterText(menarche,text);
        return this;
    }

    @Step("select genetic test in basic information :- {geneticTest}")
    public SpecialistPendingDashBoardPage selectGeneticTestResult(String text, String field) {
        WebElement geneticTest = webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'"+field+":')]//parent::div//select");
        webDriverMethods.selectDropDownByText(geneticTest,text);
        return this;
    }

    @Step("select surgery in medical history :- {surgery}")
    public SpecialistPendingDashBoardPage selectSurgey(String text, String field, int typeCount, String notes) {
        WebElement surgery = webDriverMethods.waitForElementTobeClickable("(//div[contains(text(),'"+field+":')]//parent::div//select[@class='form-control ng-pristine ng-untouched ng-valid'])["+typeCount+"]");
        webDriverMethods.selectDropDownByValue(surgery,text);
        WebElement notesgc = webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'Notes')]//parent::div//textarea");
        webDriverMethods.enterText(notesgc,notes);
        return this;
    }

    @Step("select breast ER status in specialist-entered patient Info :- {breastERStatus}")
    public SpecialistPendingDashBoardPage selectBreastERStatus(String text, String field) {
        WebElement breastERStatus = webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'"+field+":')]//parent::div//select");
        webDriverMethods.selectDropDownByText(breastERStatus,text);
        return this;
    }

    @Step("enter pathogenicMutation:- {pathogenicMutation}")
    public SpecialistPendingDashBoardPage addPathogenicMutations(String text, String field) {
        WebElement pathogenicMutation = webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'"+field+":')]//parent::div//input[@placeholder='i.e. BRCA1']");
        webDriverMethods.enterText(pathogenicMutation,text);
        return this;
    }

    @Step("enter comorbidity:- {comorbidity}")
    public SpecialistPendingDashBoardPage addComorbidity(String text, String field) {
        WebElement comorbility = webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'"+field+":')]//parent::div//input[@class='form-control ng-pristine ng-untouched ng-valid']");
        webDriverMethods.enterText(comorbility,text);
        return this;
    }

    @Step("click on add mutation")
    public SpecialistPendingDashBoardPage clickAddMutation(String field)  {
        webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'"+field+":')]//parent::div//button[text()='Add Mutation']").click();
        return this;
    }

    @Step("choose menopause {field} with option {text}")
    public SpecialistPendingDashBoardPage chooseMenopauseStatus(String text, String field) {
        WebElement menopauseStatus = webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'"+field+":')]//parent::div//select[@class='form-control ng-pristine ng-untouched ng-valid']");
        webDriverMethods.selectDropDownByText(menopauseStatus, text);
        return this;
    }

    @Step("enter breast biopsies {field} with option {text}")
    public SpecialistPendingDashBoardPage enterBreastBiopsies(String text, String field) {
        WebElement breastBiopsies = webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'"+field+":')]//parent::div//div[2]/input[@class='form-control ng-pristine ng-untouched ng-valid ng-valid-min ng-valid-max']");
        webDriverMethods.enterText(breastBiopsies,text);
        return this;
    }

    @Step("enter colon polyps {field} with option {text}")
    public SpecialistPendingDashBoardPage enterColonPolyps(String text, String field) {
        WebElement colonpolyps = webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'"+field+":')]//parent::div//div[2]/input[@class='form-control ng-pristine ng-untouched ng-valid ng-valid-min ng-valid-max']");
        webDriverMethods.enterText(colonpolyps,text);
        return this;
    }

    @Step("choose {field} with option {text}")
    public SpecialistPendingDashBoardPage chooseBreastDensity(String text, String field) {
        WebElement chooseBreastDensity = webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'"+field+":')]//parent::div//select[@class='form-control ng-pristine ng-untouched ng-valid']");
        webDriverMethods.selectDropDownByText(chooseBreastDensity, text);
        return this;
    }
    @Step("click on save changes")
    public SpecialistPendingDashBoardPage clickSaveChanges() throws InterruptedException {
        webDriverMethods.waitForElementTobeClickable("//button[contains(text(),'Save Changes')]").click();
        Thread.sleep(8000);
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
        webDriverMethods.waitForElementTobeClickable("//button[contains(@ng-click,'next')]").click();
        return this;
    }

    @Step("click button in ordering information popup")
    public SpecialistPendingDashBoardPage clickButton(String field) throws InterruptedException {
        webDriverMethods.waitForElementTobeClickable("//button[contains(text(),'"+field+"')]").click();
        return this;
    }

    @Step("click to close pop up")
    public SpecialistPendingDashBoardPage clickToClosePopup(){
        webDriverMethods.waitForElementTobeClickable("//div[@modal-window='modal-window']").click();
        return this;
    }

    @Step("check test result panel")
    public SpecialistPendingDashBoardPage checkTestResultPanel(String testName) throws InterruptedException {
       String testResultPanelName =  webDriverMethods.waitForElementTobeClickable("//span[@class='flex-col ciq-panel-heading ng-binding']").getText();
        Assert.assertEquals(testResultPanelName,testName);
        return this;
    }

    @Step("enter test result in testing tab")
    public SpecialistPendingDashBoardPage enterTestResult(String testName, String dropdownValue) throws InterruptedException {
        webDriverMethods.waitForElementTobeClickable("(//span[text()='"+testName+"']//parent::td//following-sibling::td//span)[1]").click();
        WebElement dropdownvalue = webDriverMethods.waitForElementTobeClickable("//span[text()='"+testName+"']//parent::td//following-sibling::td//select");
        webDriverMethods.selectDropDownByText(dropdownvalue,dropdownValue);
        return this;
    }

    @Step("add additional variant to test")
    public SpecialistPendingDashBoardPage addAdditionalVariant(String testName, String dropdownValue) throws InterruptedException {
        webDriverMethods.waitForElementTobeClickable("(//span[text()='"+testName+"']//parent::td//following-sibling::td//button[@ng-click='addMutation(gene)'])[1]").click();
        WebElement dropdownvalue = webDriverMethods.waitForElementTobeClickable("//span[text()='"+testName+"']//parent::td//following-sibling::td//select");
        webDriverMethods.selectDropDownByText(dropdownvalue,dropdownValue);
        return this;
    }

    @Step("validate saved test results")
    public SpecialistPendingDashBoardPage validateSavedResults(String testName, String variant) throws InterruptedException {
        String variantType = webDriverMethods.waitForElementTobeClickable("(//td[(text()='"+testName+"')]//following-sibling::td)[1]").getText();
        Assert.assertEquals(variantType,variant);
        return this;
    }

    @Step("click run risk assessment button in testing tab")
    public SpecialistPendingDashBoardPage clickRunRiskAssessmentButton() throws InterruptedException {
        webDriverMethods.waitForElementTobeClickable("//a[contains(@href,'/risk_asse') and contains(@class,'btn')]").click();
        return this;
    }

    @Step("click print assessment in risk assessment tab")
    public SpecialistPendingDashBoardPage clickPrintAssessment(String windowName){
        String parentWindow = webDriverMethods.getParentWindow();
        webDriverMethods.waitForElementTobeClickable("//a[contains(@href,'print')]").click();
        //String parentWindow = webDriverMethods.getParentWindow();
        //webDriverMethods.switchToChildWindow(windowName);
        //System.out.println(webDriverMethods.getParentWindow());
        webDriverMethods.waitForElementTobeClickable("//i[contains(@class,'fa fa-print')]").click();
        return this;
    }

    @Step("click view completed forms")
    public SpecialistPendingDashBoardPage clickViewCompletedForms(){
        webDriverMethods.waitForElementTobeClickable("(//a[@ng-click='viewCompletedForms()'])[1]").click();
        return this;
    }

    @Step("download forms")
    public SpecialistPendingDashBoardPage downloadForms(String testName) throws InterruptedException {
        webDriverMethods.waitForElementTobeClickable("//button[contains(text(),'"+testName+"')]").click();
        Thread.sleep(10000);
        return this;
    }

    @Step("clicking skip & Add patient button")
    public SpecialistPendingDashBoardPage clickSkipAddPatient(){
        webDriverMethods.waitForElementTobeClickable("//button[@ng-click='addPatient();']").click();
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
            e.printStackTrace();
            System.out.println("Exception has occurred..");
        }
        return new RegistryPage(driver);
    }

    @Step("scrolling down from {x} until {y}")
    public SpecialistPendingDashBoardPage scrollDownByXY(int x, int y){
        webDriverMethods.scrollDown(x,y);
        return this;
    }

    @Step("choose {field} with option")
    public SpecialistPendingDashBoardPage chooseReports( String field) throws InterruptedException {
        Thread.sleep(5000);
        webDriverMethods.waitForElementTobeClickable("//div[@ng-repeat='group in reportGroupMap']//button[contains(text(),'"+field+"')]").click();
        return this;
    }
    @Step("select view pdf in  {patientreports}")
    public SpecialistPendingDashBoardPage viewReports(String patientreports,String windowName, String field) throws InterruptedException {
        String parent=webDriverMethods.getParentWindow();
        webDriverMethods.waitForElementTobeClickable("(//h4[contains(text(),'"+patientreports+"')]//ancestor::div[3]//div)[5]").click();
        webDriverMethods.switchToChildWindow(windowName);
        webDriverMethods.waitForElementTobeClickable("//button[@data-cmd='"+field+"']").click();
        Thread.sleep(5000);
        webDriverMethods.switchToWindow(parent);
        return this;
    }
    @Step("check saved {reports}")
    public SpecialistPendingDashBoardPage viewSavedReports(String savedReportName){
        String savedreport=webDriverMethods.locateElementByXpath("//span[text()='Saved Reports']//ancestor::div[2]//div/h4[contains(text(),'"+savedReportName+"')]").getText();
        Assert.assertEquals(savedreport,savedReportName);
        return this;
    }

    @Step("enter gravida in reproductive history")
    public SpecialistPendingDashBoardPage enterGravida(String gravidaNo, String field){
        WebElement gravida = webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'"+field+":')]//parent::div//input[@class='form-control ng-pristine ng-untouched ng-valid ng-valid-min']");
        webDriverMethods.enterText(gravida,gravidaNo);
        return this;
    }

    @Step("enter parity in reproductive history")
    public SpecialistPendingDashBoardPage enterParity(String parityNo, String field){
        WebElement parity = webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'"+field+":')]//parent::div//input[@class='form-control ng-pristine ng-untouched ng-valid ng-valid-min']");
        webDriverMethods.enterText(parity,parityNo);
        return this;
    }

    @Step("enter age of first birth in reproductive history")
    public SpecialistPendingDashBoardPage enterAgeOfFirstBirth(String age, String field){
        WebElement ageOfFirstBirth = webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'"+field+":')]//parent::div//input[@class='form-control ng-pristine ng-untouched ng-valid ng-valid-min']");
        webDriverMethods.enterText(ageOfFirstBirth,age);
        return this;
    }

    @Step("enter weight in medical history")
    public SpecialistPendingDashBoardPage enterWeight(String weight, String field){
        WebElement weightofPatient = webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'"+field+":')]//parent::div//input");
        webDriverMethods.enterText(weightofPatient,weight);
        return this;
    }

    @Step("enter height {height}")
    public SpecialistPendingDashBoardPage enterHeight(String height, String field) {
        WebElement heightOfPatient = webDriverMethods.waitForElementTobeClickable("//div[text()[normalize-space()='"+field+":']]//parent::div//select");
        webDriverMethods.selectDropDownByText(heightOfPatient, height);
        return this;
    }

}

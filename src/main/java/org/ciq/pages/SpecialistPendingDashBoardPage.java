package org.ciq.pages;
import io.qameta.allure.Step;
import org.ciq.utils.ConfigLoader;
import org.ciq.utils.WebDriverMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import java.io.IOException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpecialistPendingDashBoardPage {

    WebDriver driver;
    WebDriverMethods webDriverMethods;
    ReadPDF readPDF;



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

    @Step("enter MRN number in create patient specialist")
    public SpecialistPendingDashBoardPage enterMRNNumber(String mrnNumber) {
        WebElement mrnField = webDriverMethods.waitForElementTobeClickable("//input[@id='mrn']");
        webDriverMethods.enterText(mrnField, mrnNumber);
        return this;
    }

    @Step("get MRN number from patient specialist dashboard")
    public SpecialistPendingDashBoardPage getMRNNumber(String field, String mrn) {
        String mrnValue = webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'"+field+":')]//following-sibling::div").getText();
        Assert.assertEquals(mrnValue, mrn);
        return this;
    }

    @Step("click on patient record in pending dashboard")
    public SpecialistPendingDashBoardPage clickPatientRecord(String patientName) throws InterruptedException {
        Thread.sleep(10000);
        webDriverMethods.waitForElementTobeClickable("//a[text()='"+patientName+"']").click();
        return this;
    }

    @Step("click on review patient case")
    public SpecialistPendingDashBoardPage clickReviewPatient() {
        webDriverMethods.waitForElementTobeClickable("//p[text()[normalize-space()='Review Patient Case']]").click();
        return this;
    }

    @Step("click on {tab} tab")
    public SpecialistPendingDashBoardPage clickPatientNavigationTab(String tab) throws InterruptedException {
        webDriverMethods.waitforElementToLoad();
        webDriverMethods.waitForElementTobeClickable("//li[@id='patientNav']//a//span[contains(text(),'"+tab+"')]").click();
        return this;
    }

    @Step("validate HBOC and HCC test in testing tab")
    public SpecialistPendingDashBoardPage validateHbocAndHccStatus(String attributeName, String attributeValue1, String attributeValue2) throws InterruptedException {
        Thread.sleep(6000);
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

    @Step("get gene names in testing tab")
    public SpecialistPendingDashBoardPage getTestGeneNames(String field, String TestGene) {
        String geneNames = webDriverMethods.waitForElementTobeClickable("//h4[contains(text(),'Select Test')]//following::div[contains(text(),'"+field+"')]//following-sibling::div").getText();
        Assert.assertEquals(geneNames, TestGene);
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

    @Step("validate care plan")
    public SpecialistPendingDashBoardPage ValidateCarePlanEligibilities(String careplan) throws InterruptedException {

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
    @Step("select genetic test in basic information :- {geneticTest}")
    public SpecialistPendingDashBoardPage selectGeneticTestResult(String text, String field) {
        WebElement geneticTest = webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'"+field+":')]//parent::div//select");
        webDriverMethods.selectDropDownByText(geneticTest,text);
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
    @Step("click on add mutation")
    public SpecialistPendingDashBoardPage clickAddMutation(String field)  {
        webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'"+field+":')]//parent::div//button[text()='Add Mutation']").click();
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
    public SpecialistPendingDashBoardPage chooseLocation(String location) throws InterruptedException {
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

    @Step("click button in ordering information popup in testing tab")
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

    @Step("navigate to outlook to validate email")
    public EmailSender navigateToOutlookUrl(String url){

        try{
            webDriverMethods.openNextTabNavigateToUrl(url);
            Thread.sleep(15000);
            return new EmailSender(driver);
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("Exception has occurred..");
        }
        return new EmailSender(driver);
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

    @Step("download reports pdf in  {patientreports}")
    public SpecialistPendingDashBoardPage downloadReports(String patientreports,String windowName, String field) throws InterruptedException, IOException {
        String parent=webDriverMethods.getParentWindow();
        webDriverMethods.waitForElementTobeClickable("(//h4[contains(text(),'"+patientreports+"')]//ancestor::div[3]//div)[5]").click();
        webDriverMethods.switchToChildWindow(windowName);
        webDriverMethods.waitForElementTobeClickable("//button[@data-cmd='"+field+"']").click();
        //after adding pdf class remove this
        String pdfFilePath = "./src/main/resources/testdoc.pdf";
        String pdfContent = ReadPDF.readPDFContent(pdfFilePath);
        System.out.println("PDF Content:\n" + pdfContent);
        Assert.assertTrue(pdfContent.contains("Herbert Debbi"));
        return this;
    }


    public SpecialistPendingDashBoardPage reportLogin(){
        WebElement userName = webDriverMethods.waitForElementTobeClickable("//input[@name = 'email']");
        webDriverMethods.enterText(userName,ConfigLoader.getConfigValue("userEmail"));

        WebElement password = webDriverMethods.waitForElementTobeClickable("//input[@name = 'password']");
        webDriverMethods.enterText(password,ConfigLoader.getConfigValue("password"));



        webDriverMethods.waitForElementTobeClickable("//button[@class='auth0-lock-submit']").click();

        return this;
    }


    @Step("check saved {reports}")
    public SpecialistPendingDashBoardPage viewSavedReports(String savedReportName){
        String savedreport=webDriverMethods.locateElementByXpath("//span[text()='Saved Reports']//ancestor::div[2]//div/h4[contains(text(),'"+savedReportName+"')]").getText();
        Assert.assertEquals(savedreport,savedReportName);
        return this;
    }
    @Step("enter age of menarche:- {age} in reproductive history")
    public SpecialistPendingDashBoardPage enterAgeOfMenarche(String text, String field) {
        WebElement menarche = webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'"+field+":')]//parent::div//div[2]/input[@class='form-control ng-pristine ng-untouched ng-valid ng-valid-min']");
        webDriverMethods.enterText(menarche,text);
        return this;
    }
    @Step("choose menopause {field} with option {text} in reproductive hsitory")
    public SpecialistPendingDashBoardPage chooseMenopauseStatus(String text, String field) {
        WebElement menopauseStatus = webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'"+field+":')]//parent::div//select[@class='form-control ng-pristine ng-untouched ng-valid']");
        webDriverMethods.selectDropDownByText(menopauseStatus, text);
        return this;
    }
    @Step("choose menopause reason {field} with option {text} in reproductive hsitory")
    public SpecialistPendingDashBoardPage chooseMenopauseReason(String text, String field) {
        WebElement menopauseReason = webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'"+field+":')]//parent::div//select");
        webDriverMethods.selectDropDownByText(menopauseReason, text);
        return this;
    }
    @Step("enter age begin menopause in reproductive history")
    public SpecialistPendingDashBoardPage enterAgeBeginMenopause(String age, String field){
        WebElement gravida = webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'"+field+"')]//parent::div//input");
        webDriverMethods.enterText(gravida,age);
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
    @Step("enter age of last birth in reproductive history")
    public SpecialistPendingDashBoardPage enterAgeOfLastBirth(String age, String field){
        WebElement ageOfFirstBirth = webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'"+field+":')]//parent::div//input[@class='form-control ng-pristine ng-untouched ng-valid ng-valid-min']");
        webDriverMethods.enterText(ageOfFirstBirth,age);
        return this;
    }
    @Step("choose birth control 5+ years details in reproductive history")
    public SpecialistPendingDashBoardPage chooseBirthControl(String field, String birthControlValue){
        WebElement birthControl = webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'"+field+"')]//parent::div//select");
        webDriverMethods.selectDropDownByText(birthControl,birthControlValue);
        return this;
    }
    @Step("choose hrt last use details in reproductive history")
    public SpecialistPendingDashBoardPage chooseHRTLastUse(String field, String hrtLastUseValue){
        WebElement hrtLastUse = webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'"+field+"')]//parent::div//select");
        webDriverMethods.selectDropDownByText(hrtLastUse,hrtLastUseValue);
        return this;
    }
    @Step("enter hrt years in reproductive history")
    public SpecialistPendingDashBoardPage enterHRTYears(String field, String hrtYearValue){
        WebElement hrtYears = webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'"+field+"')]//parent::div//input");
        webDriverMethods.enterText(hrtYears,hrtYearValue);
        return this;
    }
    @Step("enter notes")
    public SpecialistPendingDashBoardPage enterNotes(String notesValue){
        WebElement notes = webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'Notes')]//parent::div//textarea");
        webDriverMethods.enterText(notes,notesValue);
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
    @Step("enter comorbidity:- {comorbidity}")
    public SpecialistPendingDashBoardPage addComorbidity(String text, String field) {
        WebElement comorbility = webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'"+field+":')]//parent::div//input[@class='form-control ng-pristine ng-untouched ng-valid']");
        webDriverMethods.enterText(comorbility,text);
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
    @Step("select chemoprevention in medical history :- {chemoprevention}")
    public SpecialistPendingDashBoardPage selectChemoprevention(String field,String chemoPreventionValue) {
        WebElement chemoprevention = webDriverMethods.waitForElementTobeClickable("//div[contains(text(),'"+field+":')]//parent::div//select");
        webDriverMethods.selectDropDownByValue(chemoprevention,chemoPreventionValue);
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

    @Step("select surgery in medical history :- {surgery}")
    public SpecialistPendingDashBoardPage selectSurgey(String text, String field, int typeCount) {
        WebElement surgery = webDriverMethods.waitForElementTobeClickable("(//div[contains(text(),'"+field+":')]//parent::div//select[@class='form-control ng-pristine ng-untouched ng-valid'])["+typeCount+"]");
        webDriverMethods.selectDropDownByValue(surgery,text);
        return this;
    }
    @Step("select ordering physician in ordering physician/genetic counselor information")
    public SpecialistPendingDashBoardPage selectOrderingPhysician(String field) {
        webDriverMethods.waitForElementTobeClickable("//label[text()='Who is the Ordering Physician?']//following::button[contains(text(),'"+field+"')]").click();
        return this;
    }

    @Step("select Include self as additional results recipient in ordering physician/genetic counselor information")
    public SpecialistPendingDashBoardPage selectAdditionalResultsRecipient(String field) {
        webDriverMethods.waitForElementTobeClickable("//label[text()='Include self as additional results recipient?']//following::button[contains(text(),'"+field+"')]").click();
        return this;
    }

    @Step("enter name in ordering physician/genetic counselor information")
    public SpecialistPendingDashBoardPage enterName(String name) {
        WebElement nameField = webDriverMethods.waitForElementTobeClickable("//label[text()='Name']//following-sibling::input");
        webDriverMethods.enterText(nameField,name);
        return this;
    }
    @Step("enter NPI in ordering physician/genetic counselor information")
    public SpecialistPendingDashBoardPage enterNPI(String npi) {
        WebElement npiField = webDriverMethods.waitForElementTobeClickable("//label[text()='NPI']//following-sibling::input");
        webDriverMethods.enterText(npiField,npi);
        return this;
    }

    @Step("enter email in ordering physician/genetic counselor information")
    public SpecialistPendingDashBoardPage enterEmailInPopup(String email) {
        WebElement emailField = webDriverMethods.waitForElementTobeClickable("//label[text()='Email ']//following-sibling::input");
        webDriverMethods.enterText(emailField,email);
        return this;
    }

    @Step("enter phone in ordering physician/genetic counselor information")
    public SpecialistPendingDashBoardPage enterPhone(String phone) {
        WebElement phoneField = webDriverMethods.waitForElementTobeClickable("//label[text()='Phone']//following-sibling::input");
        webDriverMethods.enterText(phoneField,phone);
        return this;
    }

    @Step("enter fax in ordering physician/genetic counselor information")
    public SpecialistPendingDashBoardPage enterFax(String fax) {
        WebElement faxField = webDriverMethods.waitForElementTobeClickable("//label[text()='Fax']//following-sibling::input");
        webDriverMethods.enterText(faxField,fax);
        return this;
    }

    @Step("enter street address in ordering physician/genetic counselor information")
    public SpecialistPendingDashBoardPage enterStreetAddress(String streetAddress) {
        WebElement streetAddressField = webDriverMethods.waitForElementTobeClickable("//label[text()='Street Address']//following-sibling::input");
        webDriverMethods.enterText(streetAddressField,streetAddress);
        return this;
    }

    @Step("enter city in ordering physician/genetic counselor information")
    public SpecialistPendingDashBoardPage enterCity(String city) {
        WebElement cityField = webDriverMethods.waitForElementTobeClickable("//label[text()='City']//following-sibling::input");
        webDriverMethods.enterText(cityField,city);
        return this;
    }
    @Step("enter state in ordering physician/genetic counselor information")
    public SpecialistPendingDashBoardPage enterState(String state) {
        WebElement stateField = webDriverMethods.waitForElementTobeClickable("//label[text()='State']//following-sibling::input");
        webDriverMethods.enterText(stateField,state);
        return this;
    }

    @Step("enter zip in ordering physician/genetic counselor information")
    public SpecialistPendingDashBoardPage enterZip(String zip) {
        WebElement zipField = webDriverMethods.waitForElementTobeClickable("//label[text()='Zip']//following-sibling::input");
        webDriverMethods.enterText(zipField,zip);
        return this;
    }
    @Step("select Populate From CancerIQ in ordering physician/genetic counselor information")
    public SpecialistPendingDashBoardPage selectPopulateFromCIQValue(String populateFromCIQValue) {
        WebElement npiField = webDriverMethods.waitForElementTobeClickable("//label[text()='NPI']//following-sibling::input");
        webDriverMethods.selectDropDownByText(npiField,populateFromCIQValue);
        return this;
    }
    @Step("select provide signature in ordering physician/genetic counselor information")
    public SpecialistPendingDashBoardPage selectProvideSignature() {
        webDriverMethods.waitForElementTobeClickable("//label[text()='Provide Signature?']//following::input").click();
        return this;
    }
    @Step("enter Patient Mailing Address1 in demographic information")
    public SpecialistPendingDashBoardPage enterPatientMailingAddress1(String text) {
        WebElement mailingAddress1 = webDriverMethods.waitForElementTobeClickable("//label[text()='Patient Mailing Address']//following::input[@ng-model='store.formData.patient_street_address_1']");
        webDriverMethods.enterText(mailingAddress1,text);
        return this;
    }

    @Step("enter Patient Mailing Address2 in demographic information")
    public SpecialistPendingDashBoardPage enterPatientMailingAddress2(String text) {
        WebElement mailingAddress2 = webDriverMethods.waitForElementTobeClickable("//label[text()='Patient Mailing Address']//following::input[@ng-model='store.formData.patient_street_address_2']");
        webDriverMethods.enterText(mailingAddress2,text);
        return this;
    }

    @Step("enter patient city in demographic information")
    public SpecialistPendingDashBoardPage enterPatientCity(String text) {
        WebElement patientCity = webDriverMethods.waitForElementTobeClickable("//label[text()='Patient City']//following::input[@ng-model='store.formData.patient_city']");
        webDriverMethods.enterText(patientCity,text);
        return this;
    }

    @Step("enter patient state in demographic information")
    public SpecialistPendingDashBoardPage enterPatientState(String text) {
        WebElement patientState = webDriverMethods.waitForElementTobeClickable("//label[text()='Patient State']//following::input[@ng-model='store.formData.patient_state']");
        webDriverMethods.enterText(patientState,text);
        return this;
    }
    @Step("enter patient zip in demographic information")
    public SpecialistPendingDashBoardPage enterPatientZip(String text) {
        WebElement patientZip = webDriverMethods.waitForElementTobeClickable("//label[text()='Patient Zip']//following::input[@ng-model='store.formData.patient_zip']");
        webDriverMethods.enterText(patientZip,text);
        return this;
    }
    @Step("select patient race in demographic information")
    public SpecialistPendingDashBoardPage selectPatientRace(String text) {
        WebElement patientRace = webDriverMethods.waitForElementTobeClickable("//label[text()='Patient Race ']//following::select");
        webDriverMethods.selectDropDownByText(patientRace,text);
        return this;
    }
    @Step("select Patient Ethnicity in demographic information")
    public SpecialistPendingDashBoardPage selectPatientEthnicity(String field) {
        webDriverMethods.waitForElementTobeClickable("//label[text()='Patient Ethnicity']//following::button[text()[normalize-space()='"+field+"']]").click();
        return this;
    }
    @Step("select bill Type in billing information")
    public SpecialistPendingDashBoardPage selectBillType(String field) {
        webDriverMethods.waitForElementTobeClickable("//label[text()='Bill Type?']//following::button[contains(text(),'"+field+"')]").click();
        return this;
    }

    @Step("select patient Relationship To Policy Holder in billing information")
    public SpecialistPendingDashBoardPage selectRelationshipToPolicyHolder(String field) {
        webDriverMethods.waitForElementTobeClickable("//label[text()='Patient Relationship To Policy Holder']//following::button[contains(text(),'"+field+"')]").click();
        return this;
    }

    @Step("enter primary Insurance in billing information")
    public SpecialistPendingDashBoardPage selectPrimaryInsurance(String text) {
        WebElement primaryInsurance = webDriverMethods.waitForElementTobeClickable("//label[text()='Primary Insurance']//following::input[@ng-model='store.formData.insurance_company']");
        webDriverMethods.enterText(primaryInsurance,text);
        return this;
    }

    @Step("enter policy Insurance in billing information")
    public SpecialistPendingDashBoardPage enterPolicy(String text) {
        WebElement policy = webDriverMethods.waitForElementTobeClickable("//label[text()='Policy #']//following::input[@ng-model='store.formData.member_id']");
        webDriverMethods.enterText(policy,text);
        return this;
    }

    @Step("enter group in billing information")
    public SpecialistPendingDashBoardPage enterGroup(String text) {
        WebElement group = webDriverMethods.waitForElementTobeClickable("//label[text()='Group #']//following::input[@ng-model='store.formData.group_id']");
        webDriverMethods.enterText(group,text);
        return this;
    }

    @Step("select hospital inpatient in billing information")
    public SpecialistPendingDashBoardPage selectHospitalInpatient(String field) {
        webDriverMethods.waitForElementTobeClickable("//label[text()='Hospital Inpatient']//following::button[contains(text(),'"+field+"')]").click();
        return this;
    }

    @Step("select date of discharge in billing information")
    public SpecialistPendingDashBoardPage selectDateOfDischarge(String field) {
        webDriverMethods.waitForElementTobeClickable("//label[text()='Date of Discharge']//following::input").click();
        return this;
    }

    @Step("select sample type in specimen retrieval")
    public SpecialistPendingDashBoardPage selectSampleType(String field) {
        webDriverMethods.waitForElementTobeClickable("//label[text()='Sample Type? ']//following::button[contains(text(),'"+field+"')]").click();
        return this;
    }

    @Step("choose mobile phlebotomy in specimen retrieval")
    public SpecialistPendingDashBoardPage chooseMobilePhlebotomy(String field) {
        webDriverMethods.waitForElementTobeClickable("//label[text()='Are you using mobile phlebotomy?']//following::button[contains(text(),'"+field+"')]").click();
        return this;
    }
    @Step("choose buccal swab kit to the patient in specimen retrieval")
    public SpecialistPendingDashBoardPage chooseBuccalSwabKit(String field) {
        webDriverMethods.waitForElementTobeClickable("//label[text()='Are you sending the buccal swab kit to the patient?']//following::button[contains(text(),'"+field+"')]").click();
        return this;
    }

    @Step("choose Has the patient ever received an allogenic bone marrow or peripheral stem cell transplant in clinical history")
    public SpecialistPendingDashBoardPage chooseCellTransplant(String field) {
        webDriverMethods.waitForElementTobeClickable("//label[contains(text(),'cell transplant?')]//following::button[contains(text(),'"+field+"')]").click();
        return this;
    }

    @Step("select ICD-10 Primary Diagnosis Codes in clinical history")
    public SpecialistPendingDashBoardPage chooseICD10(String option) {
        List<WebElement> icd10list = webDriverMethods.locateElements("xpath", "//label[contains(text(),'ICD-10')]//following::label");
        for(WebElement e : icd10list){
            if((e.getText()).contains(option)){
                e.click();
            }
        }
        return this;
    }

    @Step("choose Has the patient, or any member of their family, ever had Somatic/Tumor testing in prior personal or family history or genetic testing")
    public SpecialistPendingDashBoardPage chooseTumorTesting(String field) {
        webDriverMethods.waitForElementTobeClickable("(//label[contains(text(),'Tumor testing?')]//following::button[contains(text(),'"+field+"')])[1]").click();
        return this;
    }
    @Step("choose Has the patient, or any member of their family, ever had Germline testing in prior personal or family history or genetic testing")
    public SpecialistPendingDashBoardPage chooseGermlineTesting(String field) {
        webDriverMethods.waitForElementTobeClickable("(//label[contains(text(),'Tumor testing?')]//following::button[contains(text(),'"+field+"')])[2]").click();
        return this;
    }

    @Step("validate text in the ordering physician or genetic counselor signature ")
    public SpecialistPendingDashBoardPage verifyCounselorSignatureText(String text) {
        String signatureText = webDriverMethods.waitForElementTobeClickable("//div[@ng-switch-when='ATTESTATION']//p").getText();
        Assert.assertEquals(text, signatureText);
        return this;
    }

    @Step("validate test name text in confirmation")
    public SpecialistPendingDashBoardPage verifyConfirmationTestNameText(String text) {
        String testNameText = webDriverMethods.waitForElementTobeClickable("//td[contains(text(),'Test Name')]//following-sibling::td").getText();
        Assert.assertEquals(text, testNameText);
        return this;
    }

    @Step("validate genes text in confirmation")
    public SpecialistPendingDashBoardPage verifyConfirmationGenesText(String ConfirmGene) {
        String genesText = webDriverMethods.waitForElementTobeClickable("//td[contains(text(),'Genes')]//following-sibling::td").getText();
        Assert.assertEquals(genesText, ConfirmGene);
        return this;
    }

    @Step("validate relationship text in confirmation")
    public SpecialistPendingDashBoardPage verifyConfirmationRelationshipText(String text) {
        String relationshipText = webDriverMethods.waitForElementTobeClickable("//td[contains(text(),'  Relationship')]//following-sibling::td").getText();
        Assert.assertEquals(text, relationshipText);
        return this;
    }

    @Step("validate name text in confirmation")
    public SpecialistPendingDashBoardPage verifyConfirmationNameText(String text) {
        String nameText = webDriverMethods.waitForElementTobeClickable("//td[text()='Name']//following-sibling::td").getText();
        Assert.assertEquals(text, nameText);
        return this;
    }

    @Step("validate NPI text in confirmation")
    public SpecialistPendingDashBoardPage verifyConfirmationNPIText(String text) {
        String npiText = webDriverMethods.waitForElementTobeClickable("//td[text()='NPI']//following-sibling::td").getText();
        Assert.assertEquals(text, npiText);
        return this;
    }

    @Step("validate provide signature text in confirmation")
    public SpecialistPendingDashBoardPage verifyConfirmationSignatureText(String text) {
        String provideSignatureText = webDriverMethods.waitForElementTobeClickable("//td[text()='Provide Signature?']//following-sibling::td").getText();
        Assert.assertEquals(text, provideSignatureText);
        return this;
    }

    @Step("validate address1 text in confirmation")
    public SpecialistPendingDashBoardPage verifyConfirmationAddress1Text(String text) {
        String addressText = webDriverMethods.waitForElementTobeClickable("//td[text()='Address']//following-sibling::td").getText();
        Assert.assertEquals(text, addressText);
        return this;
    }

    @Step("validate address text in confirmation")
    public SpecialistPendingDashBoardPage verifyConfirmationAddress2Text(String text) {
        String addressText = webDriverMethods.waitForElementTobeClickable("//td[text()='Address 2']//following-sibling::td").getText();
        Assert.assertEquals(text, addressText);
        return this;
    }

    @Step("validate city text in confirmation")
    public SpecialistPendingDashBoardPage verifyConfirmationCityText(String text) {
        String cityText = webDriverMethods.waitForElementTobeClickable("//td[text()='City']//following-sibling::td").getText();
        Assert.assertEquals(text, cityText);
        return this;
    }

    @Step("validate state text in confirmation")
    public SpecialistPendingDashBoardPage verifyConfirmationStateText(String text) {
        String stateText = webDriverMethods.waitForElementTobeClickable("//td[text()='State']//following-sibling::td").getText();
        Assert.assertEquals(text, stateText);
        return this;
    }

    @Step("validate postalcode text in confirmation")
    public SpecialistPendingDashBoardPage verifyConfirmationPostalCodeText(String text) {
        String postalCodeText = webDriverMethods.waitForElementTobeClickable("//td[text()='Postal Code']//following-sibling::td").getText();
        Assert.assertEquals(text, postalCodeText);
        return this;
    }

    @Step("validate race text in confirmation")
    public SpecialistPendingDashBoardPage verifyConfirmationRaceText(String text) {
        String raceText = webDriverMethods.waitForElementTobeClickable("//td[text()='Race']//following-sibling::td").getText();
        Assert.assertEquals(text, raceText);
        return this;
    }

    @Step("validate ethnicity text in confirmation")
    public SpecialistPendingDashBoardPage verifyConfirmationEthnicityext(String text) {
        String ethnicityText = webDriverMethods.waitForElementTobeClickable("//td[text()='Ethnicity']//following-sibling::td").getText();
        Assert.assertEquals(text, ethnicityText);
        return this;
    }

    @Step("validate How will the test be paid for text in confirmation")
    public SpecialistPendingDashBoardPage verifyConfirmationHowTestPaidText(String text) {
        String howTestPaidText = webDriverMethods.waitForElementTobeClickable("//td[text()='How will the test be paid for?']//following-sibling::td").getText();
        Assert.assertEquals(text, howTestPaidText);
        return this;
    }

    @Step("validate Policy Holder Name text in confirmation")
    public SpecialistPendingDashBoardPage verifyConfirmationPolicyHolderText(String text) {
        String policyHolderText = webDriverMethods.waitForElementTobeClickable("//td[text()='Policy Holder Name']//following-sibling::td[contains(text(),'"+text+"')]").getText();
        Assert.assertEquals(text, policyHolderText);
        return this;
    }

    @Step("validate Policy Holder DOB text in confirmation")
    public SpecialistPendingDashBoardPage verifyConfirmationPolicyHolderDOBText(String text) {
        String policyHolderDOBText = webDriverMethods.waitForElementTobeClickable("//td[text()='Policy Holder DOB']//following-sibling::td").getText();
       String outputdate = webDriverMethods.dateConversion(text);
       Assert.assertEquals(outputdate, policyHolderDOBText);
        return this;
    }

    @Step("validate Patient Relationship to Policy Holder text in confirmation")
    public SpecialistPendingDashBoardPage verifyConfirmationRelationshipToPolicyHolderText(String text) {
        String relationshipToPolicyHolderText = webDriverMethods.waitForElementTobeClickable("//td[text()='Patient Relationship to Policy Holder']//following-sibling::td").getText();
        Assert.assertEquals(text, relationshipToPolicyHolderText);
        return this;
    }

    @Step("validate Primary Insurance Company text in confirmation")
    public SpecialistPendingDashBoardPage verifyConfirmationPrimaryInsuranceCompanyText(String text) {
        String primaryInsuranceCompanyText = webDriverMethods.waitForElementTobeClickable("//td[text()='Primary Insurance Company']//following-sibling::td").getText();
        Assert.assertEquals(text, primaryInsuranceCompanyText);
        return this;
    }

    @Step("validate Primary Insurance Policy Number text in confirmation")
    public SpecialistPendingDashBoardPage verifyConfirmationInsurancePolicyNumberText(String text) {
        String insurancePolicyNumberText = webDriverMethods.waitForElementTobeClickable("//td[text()='Primary Insurance Policy Number']//following-sibling::td").getText();
        Assert.assertEquals(text, insurancePolicyNumberText);
        return this;
    }

    @Step("validate Primary Insurance Group Number text in confirmation")
    public SpecialistPendingDashBoardPage verifyConfirmationInsuranceGroupNumberText(String text) {
        String insuranceGroupNumberText = webDriverMethods.waitForElementTobeClickable("//td[text()='Primary Insurance Group Number']//following-sibling::td").getText();
        Assert.assertEquals(text, insuranceGroupNumberText);
        return this;
    }

    @Step("validate sample type text in confirmation")
    public SpecialistPendingDashBoardPage verifyConfirmationSampleTypeText(String text) {
        String sampleTypeText = webDriverMethods.waitForElementTobeClickable("//td[text()='Sample Type']//following-sibling::td").getText();
        Assert.assertEquals(text, sampleTypeText);
        return this;
    }

    @Step("validate Are you using mobile phlebotomy? text in confirmation")
    public SpecialistPendingDashBoardPage verifyConfirmationMobilePhlebotomyText(String text) {
        String mobilePhlebotomyText = webDriverMethods.waitForElementTobeClickable("//td[text()='Are you using mobile phlebotomy?']//following-sibling::td").getText();
        Assert.assertEquals(text, mobilePhlebotomyText);
        return this;
    }

    @Step("validate Date Collected text in confirmation")
    public SpecialistPendingDashBoardPage verifyConfirmationDateCollectedText(String text) {
        String dateCollectedText = webDriverMethods.waitForElementTobeClickable("//td[text()='Date Collected']//following-sibling::td").getText();
        Assert.assertEquals(text, dateCollectedText);
        return this;
    }

    @Step("validate Primary Diagnosis Codes text in confirmation")
    public SpecialistPendingDashBoardPage verifyConfirmationPrimaryDiagnosisCodeText(String text) {
        String primaryDiagnosisCodeText = webDriverMethods.waitForElementTobeClickable("//td[text()='Primary Diagnosis Codes']//following-sibling::td").getText();
        String[] spt = webDriverMethods.regexUsingSpace(text);
        Assert.assertEquals(primaryDiagnosisCodeText, spt[0]);
        return this;
    }
    @Step("get provider name text")
    public SpecialistPendingDashBoardPage getProviderName(String text) {
        String loggedInUserName= webDriverMethods.getLoggedInUserName("//div[@ng-show='!fromUrl']//button[@data-toggle='dropdown']");
        Assert.assertEquals(loggedInUserName,text);
        return this;
    }

    @Step("validate provider name text in confirmation")
    public SpecialistPendingDashBoardPage verifyConfirmationOrderingProviderName(String text) {
        String confirmLoggedInUserName = webDriverMethods.waitForElementTobeClickable("//td[text()='Name']//following-sibling::td").getText();
        Assert.assertEquals(confirmLoggedInUserName,text);
        return this;
    }
    @Step("validate provider name")
    public SpecialistPendingDashBoardPage verifyGeneName(String actual, String expected){
        Assert.assertEquals(actual,expected);
        return this;
    }


    @Step("validate integration text in confirmation")
    public SpecialistPendingDashBoardPage verifyConfirmationIntegrationText(String text) {
        String integrationText = webDriverMethods.waitForElementTobeClickable("//td[text()='Integration']//following-sibling::td").getText();
        Assert.assertEquals(text, integrationText);
        return this;
    }

    @Step("select include self as additional results recipient")
    public SpecialistPendingDashBoardPage selectAdditionalResultRecipient(String field) {
        webDriverMethods.waitForElementTobeClickable("//label[text()='Include self as additional results recipient?']//following::button[contains(text(),'"+field+"')]").click();
        return this;
    }

    @Step("enter Clinic or Organization")
    public SpecialistPendingDashBoardPage enterClinicOrOrganization(String clininvalue) {
        WebElement clinicOrOrganizationField = webDriverMethods.waitForElementTobeClickable("//label[text()='Clinic or Organization']//following-sibling::input");
        webDriverMethods.enterText(clinicOrOrganizationField,clininvalue);

        return this;
    }

    @Step("enter referring physician name")
    public SpecialistPendingDashBoardPage enterreferringPhysician(String referringPhysicianName) {
        WebElement referringPhysicianNameField = webDriverMethods.waitForElementTobeClickable("//label[text()='Name']//following-sibling::input");
        webDriverMethods.enterText(referringPhysicianNameField,referringPhysicianName);
        return this;
    }

    @Step("select populate from cancerIQ")
    public SpecialistPendingDashBoardPage selectPopulateFromCancerIQ(String populateFromCancerIQValue) {
        WebElement populateFromCancerIQ =  webDriverMethods.waitForElementTobeClickable("//label[contains(text(),'Populate')]//child::select");
        webDriverMethods.selectDropDownByText(populateFromCancerIQ,populateFromCancerIQValue);
        return this;
    }
    @Step("select in patient")
    public SpecialistPendingDashBoardPage selectInPatient(String field) {
        webDriverMethods.waitForElementTobeClickable("//label[text()='Hospital Inpatient']//following::button[contains(text(),'"+field+"')]").click();
        return this;
    }
    @Step("enter somatic/tumor tests performed")
    public SpecialistPendingDashBoardPage enterTumorTestPerformed(String tumorTestPerformed ) {
        WebElement tumorTestPerformedField = webDriverMethods.waitForElementTobeClickable("//label[text()='Somatic/Tumor Tests Performed']//following::input");
        webDriverMethods.enterText(tumorTestPerformedField,tumorTestPerformed);
        return this;
    }

    @Step("enter somatic/tumor Test results")
    public SpecialistPendingDashBoardPage enterTumorTestresults(String entertumorTestresults) {
        WebElement tumorTestresultsField = webDriverMethods.waitForElementTobeClickable("//label[text()='Somatic/Tumor Test Results']//following::input");
        webDriverMethods.enterText(tumorTestresultsField,entertumorTestresults);
        return this;
    }

    @Step("enter germline tests performed")
    public SpecialistPendingDashBoardPage enterGermlineTestPerformed(String tumorTestPerformed ) {
        WebElement tumorTestPerformedField = webDriverMethods.waitForElementTobeClickable("//label[text()='Germline Tests Performed']//following::input");
        webDriverMethods.enterText(tumorTestPerformedField,tumorTestPerformed);
        return this;
    }

    @Step("enter germline Test results")
    public SpecialistPendingDashBoardPage enterGermlineTestresults(String entertumorTestresults) {
        WebElement tumorTestresultsField = webDriverMethods.waitForElementTobeClickable("//label[text()='Germline Test Results']//following::input");
        webDriverMethods.enterText(tumorTestresultsField,entertumorTestresults);
        return this;
    }








}

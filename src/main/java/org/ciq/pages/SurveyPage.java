package org.ciq.pages;

import com.google.inject.internal.ExposureBuilder;
import io.cucumber.java.sl.In;
import io.qameta.allure.Step;
import org.apache.poi.hssf.record.SubRecord;
import org.ciq.utils.WebDriverMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

public class SurveyPage {

    WebDriver driver;
    WebDriverMethods webDriverMethods;

    WebDriverWait webDriverWait;

    public SurveyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        webDriverMethods = new WebDriverMethods(driver);
    }

    public static final String next = "(//div[@class='center-button']//button)[2]";
    public static final String yes = "(//div[@class='col-md-6 col-xs-12'])[1]";
    public static final String no = "(//div[@class='col-md-6 col-xs-12'])[2]";
    public static final String iDontKnow = "(//div[@class='col-md-6 col-xs-12'])[3]";

    @FindBy(xpath = "//button[text()='Start Assessment']")
    WebElement startSurvey;

    @FindBy(xpath = "//div[@class='col-xs-12']//input")
    WebElement firstName;

    @FindBy(xpath = "//div[@class='col-md-offset-2 col-md-8 center-question']//input")
    WebElement dobEle;

    @FindBy(xpath = "//div[@class='col-md-6 col-xs-12']")
    WebElement male;

    @FindBy(xpath = "(//div[@class='col-md-6 col-xs-12'])[2]")
    WebElement feMale;

    @FindBy(xpath = "(//div[@class='col-md-6 col-xs-12'])[3]")
    WebElement jewish;

/*    @FindBy(xpath = "//div[@class='col-xs-6 ng-scope']//label[contains(text(),'Mother')]")
    WebElement mother;

    @FindBy(xpath = "//div[@class='col-xs-6 ng-scope']//label[contains(text(),'Father')]")
    WebElement father;*/

    @FindBy(xpath = "//div[@class='col-md-offset-5 col-md-2 center-question']//input")
    WebElement weight;

    @FindBy(xpath = "//span[@class='ng-scope']//button")
    WebElement submit;

    @FindBy(xpath = "//div[@class='col-xs-3 right-button']//span[text()[normalize-space()='Next']]")
    WebElement rightNext;


    @Step("starting the survey")
    public SurveyPage startSurvey() {
        webDriverMethods.click(startSurvey);
        return this;
    }

    @Step("click begin assessment")
    public SurveyPage clickBeginAssessment() {
        webDriverMethods.waitForElementTobeClickable("//button[contains(text(),'Begin Assessment')]").click();
        return this;
    }

    @Step("entering first name")
    public SurveyPage enterFirstName(String fName) {
        webDriverMethods.enterText(firstName, fName);
        return this;
    }

    @Step("entering last name")
    public SurveyPage enterLastName(String lName) {
        webDriverMethods.enterText(firstName, lName);
        return this;
    }

    @Step("clicking,next button")
    public SurveyPage clickNext() {
        try {
            Thread.sleep(2000);
            webDriverMethods.waitForElementTobeClickable(next).click();
        } catch (Exception e) {
            System.out.println("element can't be clicked");
        }
        return this;

    }

    @Step("clicking,right next button")
    public SurveyPage clickRightNext(int buttonCount) {
        try {
            Thread.sleep(2000);
            webDriverMethods.waitForElementVisibility("(//div[@class='col-xs-3 right-button']//span[text()[normalize-space()='Next']])["+buttonCount+"]").click();
        } catch (Exception e) {
            System.out.println("element can't be clicked");
        }
        return this;
    }

    @Step("entering DOB")
    public SurveyPage enterDob(String dob) {
        webDriverMethods.enterText(dobEle, dob, Keys.ALT);
        return this;
    }

    @Step("choosing the gender")
    public SurveyPage choosingGender(String gender) {
        if (gender.toLowerCase().equals("male")) webDriverMethods.click(male);
        else webDriverMethods.click(feMale);
        return this;
    }

    @Step("choosing the ancestry")
    public SurveyPage choosingAncestry(String ancestry) {
        if (ancestry.toLowerCase().equals("yes"))
            webDriverMethods.waitForElementTobeClickable(yes).click();
        else if (ancestry.toLowerCase().equals("no"))
            webDriverMethods.waitForElementTobeClickable(no).click();
        else
            webDriverMethods.click(jewish);
        return this;
    }

    @Step("Were you adopted?")
    public SurveyPage choosingAdoption(String adopted) {
        if (adopted.toLowerCase().equals("yes"))
            webDriverMethods.waitForElementTobeClickable(yes).click();
        else
            webDriverMethods.waitForElementTobeClickable(no).click();

        return this;
    }

    @Step("confirmation on biological information about family ")
    public SurveyPage biologicalInfo(String biologicalInfo) {
        if (biologicalInfo.toLowerCase().equals("yes"))
            webDriverMethods.waitForElementTobeClickable(yes).click();
        else
            webDriverMethods.waitForElementTobeClickable(no).click();

        return this;
    }

    @Step("Do you currently have or have you ever had cancer (includes DCIS)?")
    public SurveyPage isCancerous(String isCancerous) {
        if (isCancerous.toLowerCase().equals("yes"))
            webDriverMethods.waitForElementTobeClickable(yes).click();
        else
            webDriverMethods.waitForElementTobeClickable(no).click();

        return this;
    }

    @Step("Have you been diagnosed with a cancer in the past 12 months?")
    public SurveyPage cancerInRecentTimes(String cancerInRecentTimes) {
        if (cancerInRecentTimes.toLowerCase().equals("yes"))
            webDriverMethods.waitForElementTobeClickable(yes).click();
        else
            webDriverMethods.waitForElementTobeClickable(no).click();

        return this;
    }

    @Step("What type of cancers have you been diagnosed with and at what age??")
    public SurveyPage setTypeOfCancerAndAge(String typeOfCancerAndAge) {

        String[] split = typeOfCancerAndAge.split(",");
        int index = 1;
        for (String eachStr : split) {
            WebElement typeOfCancer = webDriverMethods.waitForElementTobeClickable("(//select[@name='selectBox'])[" + index + "]");
            WebElement age = webDriverMethods.waitForElementTobeClickable("(//div[@class='col-sm-2 col-xs-2']//input)[" + index + "]");
            WebElement iHadAnother = webDriverMethods.waitForElementTobeClickable("//div[@class='col-md-12']//button");
            webDriverMethods.selectDropDownByText(typeOfCancer, eachStr.trim());
            webDriverMethods.enterText(age, "35");
            if (index < split.length)
                webDriverMethods.click(iHadAnother);
            index++;
        }
        return this;
    }

    @Step("Have you ever had 10 or more polyps cumulatively from colon screenings?")
    public SurveyPage colonScreening(String colonSCreening) {
        if (colonSCreening.toLowerCase().equals("yes"))
            webDriverMethods.waitForElementTobeClickable(yes).click();
        else if (colonSCreening.toLowerCase().equals("no"))
            webDriverMethods.waitForElementTobeClickable(no).click();
        else
            webDriverMethods.waitForElementTobeClickable(iDontKnow).click();

        return this;
    }

    @Step("Did the colorectal cancer happen more than once?")
    public SurveyPage colorectalMoreThanOnce(String colonSCreening) {
        if (colonSCreening.toLowerCase().equals("yes"))
            webDriverMethods.waitForElementTobeClickable(yes).click();
        else if (colonSCreening.toLowerCase().equals("no"))
            webDriverMethods.waitForElementTobeClickable(no).click();
        else
            webDriverMethods.waitForElementTobeClickable(iDontKnow).click();

        return this;
    }

    @Step("Have any of the following blood relatives in your family developed cancer?")
    public SurveyPage cancerInBloodRelatives(String cancerInBloodRelatives) {
        if (cancerInBloodRelatives.toLowerCase().equals("yes"))
            webDriverMethods.waitForElementTobeClickable(yes).click();
        else
            webDriverMethods.waitForElementTobeClickable(no).click();

        return this;
    }

    @Step("Has anyone in your family been diagnosed with prostate cancer?")
    public SurveyPage diagnosedWithCancer(String diagnosedWithCancer) {
        if (diagnosedWithCancer.toLowerCase().equals("yes"))
            webDriverMethods.waitForElementTobeClickable(yes).click();
        else
            webDriverMethods.waitForElementTobeClickable(no).click();

        return this;
    }

    @Step("Prostate Cancer Education")
    public SurveyPage cancerEducation() {
        try {
            Thread.sleep(2000);
            webDriverMethods.waitForElementTobeClickable(next).click();
        } catch (Exception e) {
            System.out.println("element can't be clicked");
        }
        return this;
    }

    @Step("Who in your family (blood relatives only) has a history of cancer? (Select all that apply)")
    public SurveyPage whoElseHasCancerInFamily(String familyMembers) {
        String[] members = familyMembers.split(",");
        for (String eachMem : members) {
            WebElement typeOfCancer;
            if (eachMem.contains("'")) {
                typeOfCancer = webDriverMethods.waitForElementTobeClickable("//div[@class='col-md-6 col-xs-12']//div[text()[normalize-space()=" + eachMem.trim() + "]]");
                webDriverMethods.click(typeOfCancer);

            }else{
                typeOfCancer = webDriverMethods.waitForElementTobeClickable("//div[@class='col-md-6 col-xs-12']//div[text()[normalize-space()='" + eachMem.trim() + "']]");
                webDriverMethods.click(typeOfCancer);
            }

        }
        return this;
    }

    @Step("Which of your parents had cancer?")
    public SurveyPage parentsHistory(String parent, int parentCount) {
        if (parent.contains("'") || parent.contains("’")){
            WebElement parents = webDriverMethods.waitForElementTobeClickable( "(//div[@class='col-xs-6 ng-scope']//label[text()[normalize-space()=" + parent + "]])["+parentCount+"]");
            webDriverMethods.click(parents);
        }
        else {
            WebElement parents = webDriverMethods.waitForElementTobeClickable( "(//div[@class='col-xs-6 ng-scope']//label[text()[normalize-space()='" + parent + "']])["+parentCount+"]");
            webDriverMethods.click(parents);
        }

        return this;
    }

    @Step("What types of cancer did (S)he have?")
    public SurveyPage typeOfCancers(String cancerType, int parentNumber) {
        String[] cancerTypes = cancerType.split(",");
        for (String eachType: cancerTypes){
            WebElement typeOfCancer = webDriverMethods.waitForElementTobeClickable("(//div[@class='col-xs-4 ng-scope']//label[text()[normalize-space()='" + eachType.trim() + "']])["+parentNumber+"]");
            webDriverMethods.click(typeOfCancer);
        }
        return this;
    }

    @Step("What age was he diagnosed with prostate (metastatic) cancer?")
    public SurveyPage diagnosedAge(String age, int parentCount) {
        WebElement typeOfCancer = webDriverMethods.waitForElementTobeClickable("(//div[@class='col-md-4 col-xs-6']//label[text()[normalize-space()='" + age + "']])["+parentCount+"]");
        webDriverMethods.click(typeOfCancer);

        return this;
    }

    @Step("Do you have other parents who had cancer?")
    public SurveyPage otherParentInfo(String otherParent) {
        WebElement typeOfCancer = webDriverMethods.waitForElementTobeClickable("//div[text()[normalize-space()='" + otherParent + "']]");
        webDriverMethods.click(typeOfCancer);

        return this;
    }

    @Step("Which of your first cousins had cancer?")
    public SurveyPage cousinThatHadCancer(String cousin) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Female First Cousin (Mother's Side)", 1);
        map.put("Female First Cousin (Father's Side)", 2);
        map.put("Male First Cousin (Mother's Side)", 3);
        map.put("Male First Cousin (Father's Side)", 4);
        Integer integer = map.get(cousin);
        WebElement typeOfCancer = webDriverMethods.waitForElementTobeClickable("(//div[@class='col-xs-6 ng-scope']//label)["+cousin+"]");
        webDriverMethods.click(typeOfCancer);

        return this;
    }

    @Step("What is your current height?")
    public SurveyPage enterHeight(String height) {
        WebElement heightEle = webDriverMethods.waitForElementTobeClickable("//select[@name='selectBox']");
        webDriverMethods.selectDropDownByText(heightEle, height);

        return this;
    }

    @Step("What is your current weight? (lbs)")
    public SurveyPage enterWeight(String weightText) {
        webDriverMethods.enterText(weight, weightText);
        return this;
    }

    @Step("Have you ever/do you currently smoke cigarettes?")
    public SurveyPage doYouSmoke(String doSmoke) {
        webDriverMethods.locateElement("xpath", "//div[@class='col-md-6 col-xs-12']//div[text()[normalize-space()='" + doSmoke + "']]").click();
        return this;
    }

    @Step("For how many years did you smoke/have you been smoking? (Fill in the blank with the number of years.)")
    public SurveyPage yearsOfSmoke(String yearsOfSmoke) {
        WebElement webElement = webDriverMethods.waitForElementTobeClickable("//div[@class='col-md-offset-5 col-md-2 center-question']//input");
        webDriverMethods.enterText(webElement, yearsOfSmoke);
        return this;
    }

    @Step("How long ago did you quit smoking?")
    public SurveyPage whenDidYouQuitSmoking(String yearsOfQuitSmoke) {
        WebElement webElement = webDriverMethods.waitForElementTobeClickable("//div[@class='col-md-2 col-xs-3']//div[text()[normalize-space()='"+yearsOfQuitSmoke+"']]");
        webDriverMethods.click(webElement);
        return this;
    }

    @Step("On average, how many packs of cigarettes did/do you smoke per day?")
    public SurveyPage cigarettesPerDay(String noOfCigarettes) {
        WebElement webElement = webDriverMethods.waitForElementTobeClickable("//div[@class='col-md-2 col-xs-3']//div[text()[normalize-space()='" + noOfCigarettes + "']]");
        webDriverMethods.click(webElement);
        return this;
    }

    @Step("Have you been screened for colorectal cancer?")
    public SurveyPage screenColorectalCancer(String screen) {
        webDriverMethods.waitForElementTobeClickable( "//div[@class='col-md-6 col-xs-12']//div[text()[normalize-space()='" + screen + "']]").click();
        return this;
    }

    @Step("How were you screened for colorectal cancer during your most recent screening?")
    public SurveyPage colorectalRecentScreening(String screen) {
        webDriverMethods.waitForElementTobeClickable( "//div[@class='col-md-6 col-xs-12']//div[text()[normalize-space()='" + screen + "']]").click();
        return this;
    }

    @Step("When was your most recent colorectal cancer screening?")
    public SurveyPage whenWasLastColorectalScreening(String duration) {
        webDriverMethods.waitForElementTobeClickable("//div[@class='col-md-2 col-xs-3']//div[text()[normalize-space()='" + duration + "']]").click();
        return this;
    }

    @Step("Have you ever had 10 or more polyps cumulatively from colon screenings?")
    public SurveyPage cumulativeScreening(String cumulativeScreening) {
        webDriverMethods.waitForElementTobeClickable( "//div[@class='col-md-6 col-xs-12']//div[text()[normalize-space()='" + cumulativeScreening + "']]").click();
        return this;
    }

    @Step("Have you ever had a screening test for prostate cancer called a PSA (Prostate-Specific Antigen) test?")
    public SurveyPage psaTest(String pas) {
        webDriverMethods.waitForElementTobeClickable( "//div[@class='col-md-6 col-xs-12']//div[text()[normalize-space()='" + pas + "']]").click();
        return this;
    }

    @Step("When was your last PSA (Prostate-Specific Antigen) test?")
    public SurveyPage lastPsaTest(String lastPsatest) {
        webDriverMethods.waitForElementTobeClickable( "//div[@class='col-md-2 col-xs-3']//div[text()[normalize-space()='" + lastPsatest + "']]").click();
        return this;
    }

    @Step("You or your family had genetic test for hereditary cancer syndromes")
    public SurveyPage hereditaryCancerSyndrome(String hereditaryCancerSyndrome) {
        webDriverMethods.waitForElementTobeClickable( "//div[@class='col-md-6 col-xs-12']//div[text()[normalize-space()='" + hereditaryCancerSyndrome + "']]").click();
        return this;
    }

    @Step("You or your family tested positive for BRCA1 or BRCA2 gene mutation")
    public SurveyPage testedForBRCA1Or2(String testedForBRCA1Or2) {
        webDriverMethods.waitForElementTobeClickable( "//div[@class='col-md-6 col-xs-12']//div[text()[normalize-space()='" + testedForBRCA1Or2 + "']]").click();
        return this;
    }

    @Step("You or your family tested positive for lynch syndrome")
    public SurveyPage testedForLynchSyndrome(String testedForLynch) {
        webDriverMethods.waitForElementTobeClickable( "//div[@class='col-md-6 col-xs-12']//div[text()[normalize-space()='" + testedForLynch + "']]").click();
        return this;
    }

    @Step("Did you develop breast cancer in both breasts?")
    public SurveyPage cancerInBothBreasts(String lastPsatest) {
        webDriverMethods.waitForElementTobeClickable( "//div[@class='col-md-6 col-xs-12']//div[text()[normalize-space()='" + lastPsatest + "']]").click();
        return this;
    }

    @Step("Did the breast cancer happen more than once?")
    public SurveyPage breastCancerHappenedMoreThanOnce(String timesOccurred) {
        webDriverMethods.waitForElementTobeClickable( "//div[@class='col-md-6 col-xs-12']//div[text()[normalize-space()='" + timesOccurred + "']]").click();
        return this;
    }

    @Step("Was the breast cancer a triple negative breast cancer?")
    public SurveyPage tripleNegativeBreast(String tripleNegative) {
        webDriverMethods.waitForElementTobeClickable( "//div[@class='col-md-6 col-xs-12']//div[text()[normalize-space()='"+tripleNegative+"']]").click();
        return this;
    }

    @Step("How old were you the first time you had a menstrual period?")
    public SurveyPage ageWhenFirstMenstrualPeriod(String age) {
        webDriverMethods.waitForElementTobeClickable( "//div[@class='col-md-2 col-xs-3']//div[text()[normalize-space()='"+age+"']]").click();
        return this;
    }

    @Step("Have you gone through menopause?")
    public SurveyPage goneThroughMenoPause(String throughMenoPause) {
        webDriverMethods.waitForElementTobeClickable( "//div[@class='col-md-6 col-xs-12']//div[text()[normalize-space()='"+throughMenoPause+"']]").click();
        return this;
    }

    @Step("At what age did you begin menopause?")
    public SurveyPage ageWhenMenoPauseBegan(String age) {
        WebElement enterAge = webDriverMethods.waitForElementVisibility("//div[@class='col-md-offset-5 col-md-2 center-question']//input");
        webDriverMethods.enterText(enterAge,age);
        return this;
    }

    @Step("What was the reason for menopause?")
    public SurveyPage reasonForMenoPause(String reason) {
        webDriverMethods.waitForElementTobeClickable( "//div[@class='col-md-6 col-xs-12']//div[text()[normalize-space()='"+reason+"']]").click();
        return this;
    }

    @Step("How many times have you been pregnant?")
    public SurveyPage howManyTimesPregnant(String timesPregnant) {
        webDriverMethods.waitForElementTobeClickable( "//div[@class='col-md-2 col-xs-3']//div[text()[normalize-space()='"+timesPregnant+"']]").click();
        return this;
    }

    @Step("How many times have you given birth?")
    public SurveyPage timesGivenBirth(String timesPregnant) {
        webDriverMethods.waitForElementTobeClickable( "//div[@class='col-md-2 col-xs-3']//div[text()[normalize-space()='"+timesPregnant+"']]").click();
        return this;
    }

    @Step("How old were you the first time you gave birth?")
    public SurveyPage ageWhenFirstBirth(String age) {
        WebElement enterAge = webDriverMethods.waitForElementVisibility("//div[@class='col-md-offset-5 col-md-2 center-question']//input");
        webDriverMethods.enterText(enterAge,age);
        return this;
    }

    @Step("Have you ever had a prior mammogram for breast cancer screening?")
    public SurveyPage mammogramForBreastCancerScreening(String screen) {
        webDriverMethods.waitForElementTobeClickable( "//div[@class='col-md-6 col-xs-12']//div[text()[normalize-space()='" + screen + "']]").click();
        return this;
    }

    @Step("When was your last mammogram?")
    public SurveyPage lastMammogram(String lastMammogram) {
        webDriverMethods.waitForElementTobeClickable( "//div[@class='col-md-2 col-xs-3']//div[text()[normalize-space()='" + lastMammogram + "']]").click();
        return this;
    }

    @Step("Have you ever had a screening test for cervical cancer called a Pap smear?")
    public SurveyPage everHadPapSmear(String papSmear) {
        webDriverMethods.waitForElementTobeClickable( "//div[@class='col-md-6 col-xs-12']//div[text()[normalize-space()='" + papSmear + "']]").click();
        return this;
    }

    @Step("When was your last Pap smear?")
    public SurveyPage lastPapSmear(String lastPapSmear) {
        webDriverMethods.waitForElementTobeClickable( "//div[@class='col-md-2 col-xs-3']//div[text()[normalize-space()='" + lastPapSmear + "']]").click();
        return this;
    }

    @Step("Click submit")
    public void clickSubmit() {
        webDriverMethods.click(submit);
    }

    @Step("enter email")
    public SurveyPage enterEmail(String emailValue) {
        WebElement email = webDriverMethods.waitForElementTobeClickable("//input[@ng-model='email']");
        webDriverMethods.enterText(email,emailValue);
        return this;
    }

    @Step("enter confirm email")
    public SurveyPage enterConfirmEmail(String confirmEmailValue) {
        WebElement confirmEmail = webDriverMethods.waitForElementTobeClickable("//input[@ng-model='email_confirmation']");
        webDriverMethods.enterText(confirmEmail,confirmEmailValue);
        return this;
    }

}

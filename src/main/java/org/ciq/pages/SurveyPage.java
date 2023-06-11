package org.ciq.pages;

import io.cucumber.java.sl.In;
import io.qameta.allure.Step;
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

    @FindBy(xpath = "//div[@class='col-xs-6 ng-scope']//label[contains(text(),'Mother')]")
    WebElement mother;

    @FindBy(xpath = "//div[@class='col-xs-6 ng-scope']//label[contains(text(),'Father')]")
    WebElement father;

    @FindBy(xpath = "//div[@class='col-md-offset-5 col-md-2 center-question']//input")
    WebElement weight;

    @FindBy(xpath = "//span[@class='ng-scope']//button")
    WebElement submit;

   /* @FindBy(xpath = "//select[@name='selectBox']")
    WebElement typeOfCancer;

    @FindBy(xpath = "//div[@class='col-sm-2 col-xs-2']//input")
    WebElement age;*/


    @Step("starting the survey")
    public void startSurvey() {
        webDriverMethods.click(startSurvey);
    }

    @Step("entering first name")
    public void enterFirstName(String fName) {
        webDriverMethods.enterText(firstName, fName);
    }

    @Step("entering last name")
    public void enterLastName(String lName) {
        webDriverMethods.enterText(firstName, lName);
    }

    @Step("clicking,next button")
    public void clickNext() {
        try {
            Thread.sleep(2000);
            webDriverMethods.waitForElementTobeClickable(next).click();
        } catch (Exception e) {
            System.out.println("element can't be clicked");
        }

    }

    @Step("entering DOB")
    public void enterDob(String dob) {
        webDriverMethods.enterText(dobEle, dob, Keys.ALT);
    }

    @Step("choosing the gender")
    public void choosingGender(String gender) {
        if (gender.toLowerCase().equals("male")) webDriverMethods.click(male);
        else webDriverMethods.click(feMale);
    }

    @Step("choosing the ancestry")
    public void choosingAncestry(String ancestry) {
        if (ancestry.toLowerCase().equals("yes"))
            webDriverMethods.waitForElementTobeClickable(yes).click();
        else if (ancestry.toLowerCase().equals("no"))
            webDriverMethods.waitForElementTobeClickable(no).click();
        else
            webDriverMethods.click(jewish);
    }

    @Step("Were you adopted?")
    public void choosingAdoption(String adopted) {
        if (adopted.toLowerCase().equals("yes"))
            webDriverMethods.waitForElementTobeClickable(yes).click();
        else
            webDriverMethods.waitForElementTobeClickable(no).click();
    }

    @Step("confirmation on biological information about family ")
    public void biologicalInfo(String biologicalInfo) {
        if (biologicalInfo.toLowerCase().equals("yes"))
            webDriverMethods.waitForElementTobeClickable(yes).click();
        else
            webDriverMethods.waitForElementTobeClickable(no).click();
    }

    @Step("Do you currently have or have you ever had cancer (includes DCIS)?")
    public void isCancerous(String isCancerous) {
        if (isCancerous.toLowerCase().equals("yes"))
            webDriverMethods.waitForElementTobeClickable(yes).click();
        else
            webDriverMethods.waitForElementTobeClickable(no).click();
    }

    @Step("Have you been diagnosed with a cancer in the past 12 months?")
    public void cancerInRecentTimes(String cancerInRecentTimes) {
        if (cancerInRecentTimes.toLowerCase().equals("yes"))
            webDriverMethods.waitForElementTobeClickable(yes).click();
        else
            webDriverMethods.waitForElementTobeClickable(no).click();
    }

    @Step("What type of cancers have you been diagnosed with and at what age??")
    public void setTypeOfCancerAndAge(String typeOfCancerAndAge) {

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
    }

    @Step("Have you ever had 10 or more polyps cumulatively from colon screenings?")
    public void colonScreening(String colonSCreening) {
        if (colonSCreening.toLowerCase().equals("yes"))
            webDriverMethods.waitForElementTobeClickable(yes).click();
        else if (colonSCreening.toLowerCase().equals("no"))
            webDriverMethods.waitForElementTobeClickable(no).click();
        else
            webDriverMethods.waitForElementTobeClickable(iDontKnow).click();
    }

    @Step("Did the colorectal cancer happen more than once?")
    public void colorectalMoreThanOnce(String colonSCreening) {
        if (colonSCreening.toLowerCase().equals("yes"))
            webDriverMethods.waitForElementTobeClickable(yes).click();
        else if (colonSCreening.toLowerCase().equals("no"))
            webDriverMethods.waitForElementTobeClickable(no).click();
        else
            webDriverMethods.waitForElementTobeClickable(iDontKnow).click();
    }

    @Step("Have any of the following blood relatives in your family developed cancer?")
    public void cancerInBloodRelatives(String cancerInBloodRelatives) {
        if (cancerInBloodRelatives.toLowerCase().equals("yes"))
            webDriverMethods.waitForElementTobeClickable(yes).click();
        else
            webDriverMethods.waitForElementTobeClickable(no).click();
    }

    @Step("Has anyone in your family been diagnosed with prostate cancer?")
    public void diagnosedWithCancer(String diagnosedWithCancer) {
        if (diagnosedWithCancer.toLowerCase().equals("yes"))
            webDriverMethods.waitForElementTobeClickable(yes).click();
        else
            webDriverMethods.waitForElementTobeClickable(no).click();
    }

    @Step("Prostate Cancer Education")
    public void cancerEducation() {
        try {
            Thread.sleep(2000);
            webDriverMethods.waitForElementTobeClickable(next).click();
        } catch (Exception e) {
            System.out.println("element can't be clicked");
        }

    }

    @Step("Who in your family (blood relatives only) has a history of cancer? (Select all that apply)")
    public void whoElseHasCancerInFamily(String familyMembers) {
        String[] members = familyMembers.split(",");
        for (String eachMem : members) {
            WebElement typeOfCancer = webDriverMethods.waitForElementTobeClickable("//div[@class='col-md-6 col-xs-12']//div[text()[normalize-space()='" + eachMem + "']]");
            webDriverMethods.click(typeOfCancer);
        }
    }

    @Step("Which of your parents had cancer?")
    public void parentsHistory(String parent) {
        if (parent.toLowerCase().equals("father"))
            webDriverMethods.click(father);
        else
            webDriverMethods.click(mother);
    }

    @Step("What types of cancer did (S)he have?")
    public void typeOfCancers(String cancerType) {
        WebElement typeOfCancer = webDriverMethods.waitForElementTobeClickable("//div[@class='col-xs-4 ng-scope']//label[text()[normalize-space()='" + cancerType + "']]");
        webDriverMethods.click(typeOfCancer);
    }

    @Step("What age was he diagnosed with prostate (metastatic) cancer?")
    public void diagnosedAge(String age) {
        WebElement typeOfCancer = webDriverMethods.waitForElementTobeClickable("//div[@class='col-md-4 col-xs-6']//label[text()[normalize-space()='"+age+"']]");
        webDriverMethods.click(typeOfCancer);
    }

    @Step("Do you have other parents who had cancer?")
    public void otherParentInfo(String otherParent) {
        WebElement typeOfCancer = webDriverMethods.waitForElementTobeClickable("//div[text()[normalize-space()='"+otherParent+"']]");
        webDriverMethods.click(typeOfCancer);
    }

    @Step("Which of your first cousins had cancer?")
    public void cousinThatHadCancer(String cousin) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Female First Cousin (Mother's Side)",1);
        map.put("Female First Cousin (Father's Side)",2);
        map.put("Male First Cousin (Mother's Side)",3);
        map.put("Male First Cousin (Father's Side)",4);
        Integer integer = map.get(cousin);
        WebElement typeOfCancer = webDriverMethods.waitForElementTobeClickable("(//div[@class='col-xs-6 ng-scope']//label)["+integer+"]");
        webDriverMethods.click(typeOfCancer);
    }

    @Step("What is your current height?")
    public void enterHeight(String height) {
            WebElement heightEle = webDriverMethods.waitForElementTobeClickable("//select[@name='selectBox']");
            webDriverMethods.selectDropDownByText(heightEle, height);
    }

    @Step("What is your current weight? (lbs)")
    public void enterWeight(String weightText) {
        webDriverMethods.enterText(weight,weightText);
    }

    @Step("Have you ever/do you currently smoke cigarettes?")
    public void doYouSmoke(String doSmoke) {
        webDriverMethods.locateElement("xpath","//div[@class='col-md-6 col-xs-12']//div[text()[normalize-space()='"+doSmoke+"']]").click();
    }

    @Step("For how many years did you smoke/have you been smoking? (Fill in the blank with the number of years.)")
    public void yearsOfSmoke(String yearsOfSmoke) {
        WebElement webElement = webDriverMethods.waitForElementTobeClickable("//div[@class='col-md-offset-5 col-md-2 center-question']//input");
        webDriverMethods.enterText(webElement, yearsOfSmoke);
    }

    @Step("On average, how many packs of cigarettes did/do you smoke per day?")
    public void cigarettesPerDay(String noOfCigarettes) {
        WebElement webElement = webDriverMethods.waitForElementTobeClickable("//div[@class='col-md-2 col-xs-3']//div[text()[normalize-space()='"+noOfCigarettes+"']]");
        webDriverMethods.click(webElement);
    }

    @Step("Have you been screened for colorectal cancer?")
    public void screenColorectalCancer(String screen) {
        webDriverMethods.locateElement("xpath","//div[@class='col-md-6 col-xs-12']//div[text()[normalize-space()='"+screen+"']]").click();
    }

    @Step("How were you screened for colorectal cancer during your most recent screening?")
    public void colorectalRecentScreening(String screen) {
        webDriverMethods.locateElement("xpath","//div[@class='col-md-6 col-xs-12']//div[text()[normalize-space()='"+screen+"']]").click();
    }

    @Step("When was your most recent colorectal cancer screening?")
    public void whenWasLastColorectalScreening(String duration) {
        webDriverMethods.locateElement("xpath","//div[@class='col-md-2 col-xs-3']//div[text()[normalize-space()='"+duration+"']]").click();
    }

    @Step("Have you ever had 10 or more polyps cumulatively from colon screenings?")
    public void cumulativeScreening(String cumulativeScreening) {
        webDriverMethods.locateElement("xpath","//div[@class='col-md-6 col-xs-12']//div[text()[normalize-space()='"+cumulativeScreening+"']]").click();
    }

    @Step("Have you ever had a screening test for prostate cancer called a PSA (Prostate-Specific Antigen) test?")
    public void psaTest(String pas) {
        webDriverMethods.locateElement("xpath","//div[@class='col-md-6 col-xs-12']//div[text()[normalize-space()='"+pas+"']]").click();
    }

    @Step("When was your last PSA (Prostate-Specific Antigen) test?")
    public void lastPsaTest(String lastPsatest) {
        webDriverMethods.locateElement("xpath","//div[@class='col-md-2 col-xs-3']//div[text()[normalize-space()='"+lastPsatest+"']]").click();
    }

    @Step("Click submit")
    public void clickSubmit() {
        webDriverMethods.click(submit);
    }

}

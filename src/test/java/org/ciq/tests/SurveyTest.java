package org.ciq.tests;

import io.cucumber.java.eo.Se;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.ciq.pages.RegisterPage;
import org.ciq.pages.SurveyPage;
import org.ciq.utils.ConfigLoader;
import org.ciq.utils.ExcelUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Map;

public class SurveyTest extends BaseTest {

    @Test
    public void completeSurvey() throws InterruptedException {

        ExcelUtils excelUtils = new ExcelUtils();
        Map data = excelUtils.getData("maleSurveyWIthAllYes", "male", "./src/test/resources/testdata.xlsx");

        WebDriver driver = launchAppAndSurveyLogin();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//button[text()='Start Assessment']")).click();
      //  Thread.sleep(15000);
      //  WebElement firstName = driver.findElement(By.xpath("//input[@class='ciq-text-box ng-pristine ng-isolate-scope ng-invalid ng-invalid-required ng-touched']"));
        WebElement firstName = driver.findElement(By.xpath("//div[@class='col-xs-12']//input"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(firstName)).sendKeys("totto");
        driver.findElement(By.xpath("(//div[@class='center-button']//button)[2]")).click();

        WebElement lastName = driver.findElement(By.xpath("//div[@class='col-xs-12']//input"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(lastName)).sendKeys("t");
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='center-button']//button)[2]")).click();

      //  driver.findElement(By.xpath("//input[@class='ciq-text-box ng-isolate-scope ng-valid-mask ng-invalid ng-invalid-required ng-valid-pattern ng-touched ng-dirty ng-valid-parse']")).sendKeys("08/06/2023");
        WebElement date = driver.findElement(By.xpath("//input[@class='ciq-text-box ng-isolate-scope ng-valid-mask ng-invalid ng-invalid-required ng-valid-pattern ng-touched ng-dirty ng-valid-parse']"));
      //  WebElement date = driver.findElement(By.xpath("//div[@class='col-xs-12']//input"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(date)).sendKeys("06/06/1994");
        driver.findElement(By.xpath("(//div[@class='center-button']//button)[2]")).click();

      //  driver.findElement(By.xpath("//input[@class='ciq-text-box ng-pristine ng-isolate-scope ng-invalid ng-invalid-required ng-touched']")).sendKeys("titto");
     //   driver.findElement(By.xpath("(//div[@class='center-button']//button)[2]")).click();
      //  Thread.sleep(14000);

     //   driver.findElement(By.xpath("//input[@class='ciq-text-box ng-pristine ng-isolate-scope ng-invalid ng-invalid-required ng-touched']")).sendKeys("d");
     //   driver.findElement(By.xpath("(//div[@class='center-button']//button)[2]")).click();
     /*   Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@class='ciq-text-box ng-isolate-scope ng-valid-mask ng-invalid ng-invalid-required ng-valid-pattern ng-touched ng-dirty ng-valid-parse']")).sendKeys("08/06/2023");
        driver.findElement(By.xpath("(//div[@class='center-button']//button)[2]")).click();
        Thread.sleep(3000);*/

        // for male
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        // for female
      //  Thread.sleep(3000);
      //  driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[3]")).click();

        // for Ashkenzi yes
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        // adopted - yes
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        // bilogical family - yes
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        // dcis - yes
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        // diagnoised with cancer
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        // type of cancers
        Thread.sleep(3000);
        WebElement cancerType = driver.findElement(By.xpath("//select[@name='selectBox']"));
        Select s=new Select(cancerType);
        s.selectByIndex(1);

        // age at diagnosis
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='col-sm-2 col-xs-2']//input")).sendKeys("35");
        driver.findElement(By.xpath("(//div[@class='center-button']//button)[2]")).click();

        driver.findElement(By.xpath("(//div[@class='center-button']//button)[2]")).click();

        //10 or more polyps cumulatively from colon
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        //of the following blood relatives in your family developed cancer?
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        //family been diagnosed with prostate cancer
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        // prostate cancer education
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        //Who in your family (blood relatives only) has a history of cancer?
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='col-md-6 col-xs-12']//div//i)[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='center-button']//button)[2]")).click();

        //Please tell us about your parent's history of cancer- father
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='col-xs-6 ng-scope']//label")).click();

        // adrenile
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='col-xs-4 ng-scope']//label//i")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='col-xs-3 right-button']//span")).click();

        // what age he diagnoised
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='col-md-4 col-xs-6']//label")).click();

        //Do you have other parents who had cancer?
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='col-xs-12']//div[2]//div[2]")).click();

        Thread.sleep(3000);
        WebElement height = driver.findElement(By.xpath("//select[@name='selectBox']"));
        Select select = new Select(height);
        select.selectByIndex(2);

        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='center-button']//button)[2]")).click();

        // current weight
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='col-md-offset-5 col-md-2 center-question']//input")).sendKeys("57");

        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='center-button']//button)[2]")).click();

        // Have you ever/do you currently smoke cigarettes?
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        //Do you currently smoke cigarettes?
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

      //  For how many years did you smoke/have you been smoking?
        driver.findElement(By.xpath("//div[@class='col-md-offset-5 col-md-2 center-question']//input")).sendKeys("5");

        driver.findElement(By.xpath("(//div[@class='center-button']//button)[2]")).click();

        //On average, how many packs of cigarettes did/do you smoke per day?
        driver.findElement(By.xpath("(//div[@class='col-md-2 col-xs-3'])[3]//div[1]")).click();

        //Have you been screened for colorectal cancer?
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        //How were you screened for colorectal cancer during your most recent screening?
        driver.findElement(By.xpath("(//div[@class='col-md-6 col-xs-12'])[1]/div[1]")).click();

        //When was your most recent colorectal cancer screening?
        driver.findElement(By.xpath("(//div[@class='col-md-2 col-xs-3'])[1]/div[1]")).click();

        // Have you ever had 10 or more polyps cumulatively from colon screenings?
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        //Have you ever had a screening test for prostate cancer called a PSA (Prostate-Specific Antigen) test?
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        //When was your last PSA (Prostate-Specific Antigen) test?
        driver.findElement(By.xpath("(//div[@class='col-md-2 col-xs-3'])[1]/div[1]")).click();

        //submit
        driver.findElement(By.xpath("//div[@class='center-button']//span/span/button")).click();

        // continue
        driver.findElement(By.xpath("//button[text()='Continue']")).click();

    }

    @Test
    public void completeSurveyPOM() throws InterruptedException {

        ExcelUtils excelUtils = new ExcelUtils();
        Map data = excelUtils.getData("maleSurveyWIthAllYes", "male", "./src/test/resources/testdata.xlsx");

        WebDriver driver = launchAppAndSurveyLogin();
        SurveyPage surveyPage=new SurveyPage( driver);
        surveyPage.startSurvey();
        surveyPage.enterFirstName("first name");
        surveyPage.clickNext();
        surveyPage.enterLastName("last name");
        surveyPage.clickNext();
        surveyPage.enterDob("06/07/1987");
        surveyPage.clickNext();
        surveyPage.choosingGender("male");
        surveyPage.clickNext();
        surveyPage.choosingAncestry("yes");
        surveyPage.clickNext();
        surveyPage.choosingAdoption("yes");
        surveyPage.clickNext();
        surveyPage.biologicalInfo("yes");
        surveyPage.clickNext();
        surveyPage.isCancerous("yes");
        surveyPage.clickNext();
        surveyPage.cancerInRecentTimes("yes");
        surveyPage.clickNext();
        surveyPage.setTypeOfCancerAndAge("Prostate, Colon or Rectal, Gallbladder");
        surveyPage.clickNext();
        surveyPage.colorectalMoreThanOnce("yes");
        surveyPage.clickNext();
        surveyPage.colonScreening("yes");
        surveyPage.clickNext();
        surveyPage.cancerInBloodRelatives("yes");
        surveyPage.clickNext();
        surveyPage.diagnosedWithCancer("yes");
        surveyPage.clickNext();
        surveyPage.cancerEducation();
        surveyPage.whoElseHasCancerInFamily("A Parent, A First Cousin (My Aunt or Uncle's Child)");
        surveyPage.parentsHistory("Father");
        surveyPage.typeOfCancers("Prostate");
        surveyPage.clickNext();
        surveyPage.diagnosedAge("30 - 39");
        surveyPage.clickNext();
        surveyPage.otherParentInfo("Yes, another parent had cancer");
        surveyPage.clickNext();
        surveyPage.parentsHistory("mother");
        surveyPage.clickNext();
        surveyPage.typeOfCancers("Prostate");
        surveyPage.clickNext();
        surveyPage.diagnosedAge("30 - 39");
        surveyPage.clickNext();
        surveyPage.cousinThatHadCancer("Female First Cousin (Mother's Side)");
        surveyPage.clickNext();
        surveyPage.typeOfCancers("Colon, Breast( Both breast)");
        surveyPage.clickNext();
        surveyPage.diagnosedAge("40 - 45");
        surveyPage.clickNext();
        surveyPage.otherParentInfo("No, only 1 first cousin had cancer");
        surveyPage.clickNext();
        surveyPage.enterHeight("4 ft 8 in");
        surveyPage.clickNext();
        surveyPage.enterWeight("166");
        surveyPage.clickNext();
        surveyPage.doYouSmoke("yes");
        surveyPage.clickNext();
        surveyPage.doYouSmoke("yes");
        surveyPage.clickNext();
        surveyPage.yearsOfSmoke("20");
        surveyPage.clickNext();
        surveyPage.cigarettesPerDay("3");
        surveyPage.clickNext();
        surveyPage.colonScreening("yes");
        surveyPage.clickNext();
        surveyPage.colorectalRecentScreening("Colonoscopy");
        surveyPage.clickNext();
        surveyPage.whenWasLastColorectalScreening("Within the past year");
        surveyPage.clickNext();
        surveyPage.cumulativeScreening("Yes");
        surveyPage.clickNext();
        surveyPage.psaTest("Yes");
        surveyPage.clickNext();
        surveyPage.lastPsaTest("Within the past year");
        surveyPage.clickSubmit();











        ////div[@class='col-md-6 col-xs-12']//i


        Thread.sleep(5000);

        driver.findElement(By.xpath("//button[text()='Start Assessment']")).click();
        //  Thread.sleep(15000);
        //  WebElement firstName = driver.findElement(By.xpath("//input[@class='ciq-text-box ng-pristine ng-isolate-scope ng-invalid ng-invalid-required ng-touched']"));
        WebElement firstName = driver.findElement(By.xpath("//div[@class='col-xs-12']//input"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(firstName)).sendKeys("totto");
        driver.findElement(By.xpath("(//div[@class='center-button']//button)[2]")).click();

        WebElement lastName = driver.findElement(By.xpath("//div[@class='col-xs-12']//input"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(lastName)).sendKeys("t");
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='center-button']//button)[2]")).click();

        //  driver.findElement(By.xpath("//input[@class='ciq-text-box ng-isolate-scope ng-valid-mask ng-invalid ng-invalid-required ng-valid-pattern ng-touched ng-dirty ng-valid-parse']")).sendKeys("08/06/2023");
        WebElement date = driver.findElement(By.xpath("//input[@class='ciq-text-box ng-isolate-scope ng-valid-mask ng-invalid ng-invalid-required ng-valid-pattern ng-touched ng-dirty ng-valid-parse']"));
        //  WebElement date = driver.findElement(By.xpath("//div[@class='col-xs-12']//input"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(date)).sendKeys("06/06/1994");
        driver.findElement(By.xpath("(//div[@class='center-button']//button)[2]")).click();

        //  driver.findElement(By.xpath("//input[@class='ciq-text-box ng-pristine ng-isolate-scope ng-invalid ng-invalid-required ng-touched']")).sendKeys("titto");
        //   driver.findElement(By.xpath("(//div[@class='center-button']//button)[2]")).click();
        //  Thread.sleep(14000);

        //   driver.findElement(By.xpath("//input[@class='ciq-text-box ng-pristine ng-isolate-scope ng-invalid ng-invalid-required ng-touched']")).sendKeys("d");
        //   driver.findElement(By.xpath("(//div[@class='center-button']//button)[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@class='ciq-text-box ng-isolate-scope ng-valid-mask ng-invalid ng-invalid-required ng-valid-pattern ng-touched ng-dirty ng-valid-parse']")).sendKeys("08/06/2023");
        driver.findElement(By.xpath("(//div[@class='center-button']//button)[2]")).click();
        Thread.sleep(3000);

        // for male
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        // for female
        //  Thread.sleep(3000);
        //  driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[3]")).click();

        // for Ashkenzi yes
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        // adopted - yes
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        // bilogical family - yes
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        // dcis - yes
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        // diagnoised with cancer
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        // type of cancers
        Thread.sleep(3000);
        WebElement cancerType = driver.findElement(By.xpath("//select[@name='selectBox']"));
        Select s=new Select(cancerType);
        s.selectByIndex(1);

        // age at diagnosis
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='col-sm-2 col-xs-2']//input")).sendKeys("35");
        driver.findElement(By.xpath("(//div[@class='center-button']//button)[2]")).click();

        driver.findElement(By.xpath("(//div[@class='center-button']//button)[2]")).click();

        //10 or more polyps cumulatively from colon
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        //of the following blood relatives in your family developed cancer?
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        //family been diagnosed with prostate cancer
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        // prostate cancer education
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        //Who in your family (blood relatives only) has a history of cancer?
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='col-md-6 col-xs-12']//div//i)[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='center-button']//button)[2]")).click();

        //Please tell us about your parent's history of cancer- father
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='col-xs-6 ng-scope']//label")).click();

        // adrenile
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='col-xs-4 ng-scope']//label//i")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='col-xs-3 right-button']//span")).click();

        // what age he diagnoised
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='col-md-4 col-xs-6']//label")).click();

        //Do you have other parents who had cancer?
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='col-xs-12']//div[2]//div[2]")).click();

        Thread.sleep(3000);
        WebElement height = driver.findElement(By.xpath("//select[@name='selectBox']"));
        Select select = new Select(height);
        select.selectByIndex(2);

        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='center-button']//button)[2]")).click();

        // current weight
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='col-md-offset-5 col-md-2 center-question']//input")).sendKeys("57");

        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='center-button']//button)[2]")).click();

        // Have you ever/do you currently smoke cigarettes?
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        //Do you currently smoke cigarettes?
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        //  For how many years did you smoke/have you been smoking?
        driver.findElement(By.xpath("//div[@class='col-md-offset-5 col-md-2 center-question']//input")).sendKeys("5");

        driver.findElement(By.xpath("(//div[@class='center-button']//button)[2]")).click();

        //On average, how many packs of cigarettes did/do you smoke per day?
        driver.findElement(By.xpath("(//div[@class='col-md-2 col-xs-3'])[3]//div[1]")).click();

        //Have you been screened for colorectal cancer?
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        //How were you screened for colorectal cancer during your most recent screening?
        driver.findElement(By.xpath("(//div[@class='col-md-6 col-xs-12'])[1]/div[1]")).click();

        //When was your most recent colorectal cancer screening?
        driver.findElement(By.xpath("(//div[@class='col-md-2 col-xs-3'])[1]/div[1]")).click();

        // Have you ever had 10 or more polyps cumulatively from colon screenings?
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        //Have you ever had a screening test for prostate cancer called a PSA (Prostate-Specific Antigen) test?
        driver.findElement(By.xpath("(//div[@class='row']/div/div/div)[1]")).click();

        //When was your last PSA (Prostate-Specific Antigen) test?
        driver.findElement(By.xpath("(//div[@class='col-md-2 col-xs-3'])[1]/div[1]")).click();

        //submit
        driver.findElement(By.xpath("//div[@class='center-button']//span/span/button")).click();

        // continue
        driver.findElement(By.xpath("//button[text()='Continue']")).click();

    }
}

package org.ciq.tests;

import com.github.javafaker.Faker;
import org.ciq.pages.SurveyPage;
import org.ciq.utils.DataGenerationUtils;
import org.ciq.utils.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Map;

public class SurveyTest extends BaseTest {

    @Test
    public void maleGenericSurvey()  {

        ExcelUtils excelUtils = new ExcelUtils();
        Map<String, String> data = excelUtils.getData("maleSurvey", "male", "./src/test/resources/testdata.xlsx");

        WebDriver driver = launchAppAndSurveyLogin();
        SurveyPage surveyPage = new SurveyPage(driver);
        DataGenerationUtils dataGenerationUtils=new DataGenerationUtils(new Faker());

        surveyPage.startSurvey()
                .enterFirstName(dataGenerationUtils.randomFirstName())
                .clickNext()
                .enterLastName(dataGenerationUtils.randomLastName())
                .clickNext()
                .enterDob(data.get("DOB"))
                .clickNext()
                .choosingGender(data.get("Sex"))
                .clickNext()
                .choosingAncestry(data.get("Ashkenazi or Eastern European Jewish ancestry"))
                .clickNext()
                .choosingAdoption(data.get("Adopted"))
                .clickNext()
                .biologicalInfo(data.get("Medical information about your biological family"))
                .clickNext()
                .isCancerous(data.get("Ever had Cancer"))
                .clickNext()
                .cancerInRecentTimes(data.get("Cancer in the past 12 months"))
                .clickNext()
                .setTypeOfCancerAndAge(data.get("Type of Cancer"))
                .clickNext()
                .colorectalMoreThanOnce(data.get("Did the colorectal cancer happen more than once?"))
                .clickNext()
                .colonScreening(data.get("10 or more colon polyps"))
                .clickNext()
                .cancerInBloodRelatives(data.get("Any family developed cancer"))
                .clickNext()
                .diagnosedWithCancer(data.get("Has anyone in family with prostate"))
                .clickNext()
                .cancerEducation()
                .whoElseHasCancerInFamily(data.get("Who in Family has cancer"))
                .clickNext()
                .parentsHistory(data.get("Family1"), 1)
                .typeOfCancers(data.get("Type of Cancer Father"), 1)
                .clickRightNext(1)
                .diagnosedAge(data.get("Age of Diagnosis Father"), 1)
                .otherParentInfo(data.get("Do you have other parents who had cancer-1?"))
                .parentsHistory(data.get("Family 2"), 2)
                .clickNext()
                .typeOfCancers(data.get("Type of cancer Mother"), 2)
                .clickRightNext(2)
                .diagnosedAge(data.get("Age of diagnosis Mother"), 2)
                .clickNext()
                .otherParentInfo(data.get("Do you have other parents who had cancer-2?"))
                .cousinThatHadCancer(data.get("Family 3"))
                .clickNext()
                .typeOfCancers(data.get("Type of cancer cousin"), 1)
                .clickRightNext(1)
                .diagnosedAge(data.get("Age of diagnosis cousin"), 1)
                .diagnosedAge(data.get("Age of diagnosis cousin"), 2)
                .clickNext()
                .otherParentInfo(data.get("Do you have other first cousins who had cancer?"))
                .clickNext()
                .enterHeight(data.get("Height"))
                .clickNext()
                .enterWeight(data.get("Weight"))
                .clickNext()
                .doYouSmoke(data.get("have a habit of smoke?"))
                .clickNext()
                .doYouSmoke(data.get("Do you currently smoke"))
                .clickNext()
                .yearsOfSmoke(data.get("For how many years did you smoke/have you been smoking?"))
                .clickNext()
                .cigarettesPerDay(data.get("how many packs of cigarettes"))
                .clickNext()
                .colonScreening(data.get("Screened for colorectal cancer"))
                .clickNext()
                .colorectalRecentScreening(data.get("Colorectal screenings"))
                .clickNext()
                .whenWasLastColorectalScreening(data.get("most recent colorectal cancer screening?"))
                .clickNext()
                .cumulativeScreening(data.get("Have you ever had 10 or more polyps cumulatively from colon screenings?"))
                .clickNext()
                .psaTest(data.get("ever had a screening test for prostate cancer called a PSA"))
                .clickNext()
                .lastPsaTest(data.get("last PSA (Prostate-Specific Antigen) test"))
                .clickSubmit();
    }


    @Test
    public void maleSurveyWithNoCancer()  {

        ExcelUtils excelUtils = new ExcelUtils();
        Map<String, String> data = excelUtils.getData("maleSurvey-6", "male", "./src/test/resources/testdata.xlsx");

        WebDriver driver = launchAppAndSurveyLogin();
        SurveyPage surveyPage = new SurveyPage(driver);
        DataGenerationUtils dataGenerationUtils=new DataGenerationUtils(new Faker());

        surveyPage.startSurvey()
                .enterFirstName(dataGenerationUtils.randomFirstName())
                .clickNext()
                .enterLastName(dataGenerationUtils.randomLastName())
                .clickNext()
                .enterDob(data.get("DOB"))
                .clickNext()
                .choosingGender(data.get("Sex"))
                .clickNext()
                .choosingAncestry(data.get("Ashkenazi or Eastern European Jewish ancestry"))
                .clickNext()
                .choosingAdoption(data.get("Adopted"))
                .clickNext()
                .isCancerous(data.get("Ever had Cancer"))
                .clickNext()
                .colonScreening(data.get("10 or more colon polyps"))
                .clickNext()
                .cancerInBloodRelatives(data.get("Any family developed cancer"))
                .clickNext()
                .enterHeight(data.get("Height"))
                .clickNext()
                .enterWeight(data.get("Weight"))
                .clickNext()
                .doYouSmoke(data.get("have a habit of smoke?"))
                .clickNext()
                .colonScreening(data.get("Screened for colorectal cancer"))
                .clickNext()
                .colorectalRecentScreening(data.get("Colorectal screenings"))
                .clickNext()
                .whenWasLastColorectalScreening(data.get("most recent colorectal cancer screening?"))
                .clickNext()
                .cumulativeScreening(data.get("Have you ever had 10 or more polyps cumulatively from colon screenings?"))
                .clickNext()
                .psaTest(data.get("ever had a screening test for prostate cancer called a PSA"))
                .clickSubmit();
    }


    @Test
    public void maleGenericWithNoAncestry()  {

        ExcelUtils excelUtils = new ExcelUtils();
        Map<String, String> data = excelUtils.getData("maleSurvey-7", "male", "./src/test/resources/testdata.xlsx");

        WebDriver driver = launchAppAndSurveyLogin();
        SurveyPage surveyPage = new SurveyPage(driver);
        DataGenerationUtils dataGenerationUtils=new DataGenerationUtils(new Faker());

        surveyPage.startSurvey()
                .enterFirstName(dataGenerationUtils.randomFirstName())
                .clickNext()
                .enterLastName(dataGenerationUtils.randomLastName())
                .clickNext()
                .enterDob(data.get("DOB"))
                .clickNext()
                .choosingGender(data.get("Sex"))
                .clickNext()
                .choosingAncestry(data.get("Ashkenazi or Eastern European Jewish ancestry"))
                .clickNext()
                .choosingAdoption(data.get("Adopted"))
                .clickNext()
                .biologicalInfo(data.get("Medical information about your biological family"))
                .clickNext()
                .isCancerous(data.get("Ever had Cancer"))
                .clickNext()
                .colonScreening(data.get("10 or more colon polyps"))
                .clickNext()
                .cancerInBloodRelatives(data.get("Any family developed cancer"))
                .clickNext()
                .diagnosedWithCancer(data.get("Has anyone in family with prostate"))
                .clickNext()
                .enterHeight(data.get("Height"))
                .clickNext()
                .enterWeight(data.get("Weight"))
                .clickNext()
                .doYouSmoke(data.get("have a habit of smoke?"))
                .clickNext()
                .doYouSmoke(data.get("Do you currently smoke"))
                .clickNext()
                .yearsOfSmoke(data.get("For how many years did you smoke/have you been smoking?"))
                .clickNext()
                .cigarettesPerDay(data.get("how many packs of cigarettes"))
                .clickNext()
                .whenDidYouQuitSmoking(data.get("How long ago did you quit smoking?"))
                .clickNext()
                .colonScreening(data.get("Screened for colorectal cancer"))
                .clickNext()
                .colorectalRecentScreening(data.get("Colorectal screenings"))
                .clickNext()
                .whenWasLastColorectalScreening(data.get("most recent colorectal cancer screening?"))
                .clickNext()
                .cumulativeScreening(data.get("Have you ever had 10 or more polyps cumulatively from colon screenings?"))
                .clickNext()
                .psaTest(data.get("ever had a screening test for prostate cancer called a PSA"))
                .clickNext()
                .lastPsaTest(data.get("last PSA (Prostate-Specific Antigen) test"))
                .clickSubmit();
    }

    @Test
    public void maleGenericSurveyJewish()  {

        ExcelUtils excelUtils = new ExcelUtils();
        Map<String, String> data = excelUtils.getData("maleSurvey-8", "male", "./src/test/resources/testdata.xlsx");

        WebDriver driver = launchAppAndSurveyLogin();
        SurveyPage surveyPage = new SurveyPage(driver);
        DataGenerationUtils dataGenerationUtils=new DataGenerationUtils(new Faker());

        surveyPage.startSurvey()
                .enterFirstName(dataGenerationUtils.randomFirstName())
                .clickNext()
                .enterLastName(dataGenerationUtils.randomLastName())
                .clickNext()
                .enterDob(data.get("DOB"))
                .clickNext()
                .choosingGender(data.get("Sex"))
                .clickNext()
                .choosingAncestry(data.get("Ashkenazi or Eastern European Jewish ancestry"))
                .clickNext()
                .choosingAdoption(data.get("Adopted"))
                .clickNext()
                .biologicalInfo(data.get("Medical information about your biological family"))
                .clickNext()
                .isCancerous(data.get("Ever had Cancer"))
                .clickNext()
                .cancerInRecentTimes(data.get("Cancer in the past 12 months"))
                .clickNext()
                .setTypeOfCancerAndAge(data.get("Type of Cancer"))
                .clickNext()
                .colonScreening(data.get("10 or more colon polyps"))
                .clickNext()
                .cancerInBloodRelatives(data.get("Any family developed cancer"))
                .clickNext()
                .diagnosedWithCancer(data.get("Has anyone in family with prostate"))
                .clickNext()
              //  .cancerEducation()
                .enterHeight(data.get("Height"))
                .clickNext()
                .enterWeight(data.get("Weight"))
                .clickNext()
                .doYouSmoke(data.get("have a habit of smoke?"))
                .clickNext()
                .colonScreening(data.get("Screened for colorectal cancer"))
                .clickNext()
              /*  .colorectalRecentScreening(data.get("Colorectal screenings"))
                .clickNext()
                .whenWasLastColorectalScreening(data.get("most recent colorectal cancer screening?"))
                .clickNext()
                .cumulativeScreening(data.get("Have you ever had 10 or more polyps cumulatively from colon screenings?"))
                .clickNext()
                .psaTest(data.get("ever had a screening test for prostate cancer called a PSA"))
                .clickNext()
                .lastPsaTest(data.get("last PSA (Prostate-Specific Antigen) test"))*/
                .clickSubmit();
    }

    @Test
    public void maleGenericSurveyWithNoOneInFamilyHasCancer()  {

        ExcelUtils excelUtils = new ExcelUtils();
        Map<String, String> data = excelUtils.getData("maleSurvey-9", "male", "./src/test/resources/testdata.xlsx");

        WebDriver driver = launchAppAndSurveyLogin();
        SurveyPage surveyPage = new SurveyPage(driver);
        DataGenerationUtils dataGenerationUtils=new DataGenerationUtils(new Faker());

        surveyPage.startSurvey()
                .enterFirstName(dataGenerationUtils.randomFirstName())
                .clickNext()
                .enterLastName(dataGenerationUtils.randomLastName())
                .clickNext()
                .enterDob(data.get("DOB"))
                .clickNext()
                .choosingGender(data.get("Sex"))
                .clickNext()
                .choosingAncestry(data.get("Ashkenazi or Eastern European Jewish ancestry"))
                .clickNext()
                .choosingAdoption(data.get("Adopted"))
                .clickNext()
                .biologicalInfo(data.get("Medical information about your biological family"))
                .clickNext()
                .isCancerous(data.get("Ever had Cancer"))
                .clickNext()
                .cancerInRecentTimes(data.get("Cancer in the past 12 months"))
                .clickNext()
                .setTypeOfCancerAndAge(data.get("Type of Cancer"))
                .clickNext()
                .colorectalMoreThanOnce(data.get("Did the colorectal cancer happen more than once?"))
                .clickNext()
                .colonScreening(data.get("10 or more colon polyps"))
                .clickNext()
                .cancerInBloodRelatives(data.get("Any family developed cancer"))
                .clickNext()
                .enterHeight(data.get("Height"))
                .clickNext()
                .enterWeight(data.get("Weight"))
                .clickNext()
                .doYouSmoke(data.get("have a habit of smoke?"))
                .clickNext()
                .doYouSmoke(data.get("Do you currently smoke"))
                .clickNext()
                .yearsOfSmoke(data.get("For how many years did you smoke/have you been smoking?"))
                .clickNext()
                .cigarettesPerDay(data.get("how many packs of cigarettes"))
                .clickNext()
                .colonScreening(data.get("Screened for colorectal cancer"))
                .clickNext()
                .psaTest(data.get("ever had a screening test for prostate cancer called a PSA"))
                .clickNext()
                .lastPsaTest(data.get("last PSA (Prostate-Specific Antigen) test"))
                .clickSubmit();
    }

    @Test
    public void maleGenericSurveyWithAllNo()  {

        ExcelUtils excelUtils = new ExcelUtils();
        Map<String, String> data = excelUtils.getData("maleSurvey-10", "male", "./src/test/resources/testdata.xlsx");

        WebDriver driver = launchAppAndSurveyLogin();
        SurveyPage surveyPage = new SurveyPage(driver);
        DataGenerationUtils dataGenerationUtils=new DataGenerationUtils(new Faker());

        surveyPage.startSurvey()
                .enterFirstName(dataGenerationUtils.randomFirstName())
                .clickNext()
                .enterLastName(dataGenerationUtils.randomLastName())
                .clickNext()
                .enterDob(data.get("DOB"))
                .clickNext()
                .choosingGender(data.get("Sex"))
                .clickNext()
                .choosingAncestry(data.get("Ashkenazi or Eastern European Jewish ancestry"))
                .clickNext()
                .choosingAdoption(data.get("Adopted"))
                .clickNext()
                .isCancerous(data.get("Ever had Cancer"))
                .clickNext()
                .colonScreening(data.get("10 or more colon polyps"))
                .clickNext()
                .cancerInBloodRelatives(data.get("Any family developed cancer"))
                .clickNext()
                .enterHeight(data.get("Height"))
                .clickNext()
                .enterWeight(data.get("Weight"))
                .clickNext()
                .doYouSmoke(data.get("have a habit of smoke?"))
                .clickNext()
                .doYouSmoke(data.get("Do you currently smoke"))
                .clickNext()
                .yearsOfSmoke(data.get("For how many years did you smoke/have you been smoking?"))
                .clickNext()
                .cigarettesPerDay(data.get("how many packs of cigarettes"))
                .clickNext()
                .colonScreening(data.get("Screened for colorectal cancer"))
                .clickNext()
                .colorectalRecentScreening(data.get("Colorectal screenings"))
                .clickNext()
                .whenWasLastColorectalScreening(data.get("most recent colorectal cancer screening?"))
                .clickNext()
                .cumulativeScreening(data.get("Have you ever had 10 or more polyps cumulatively from colon screenings?"))
                .clickNext()
                .psaTest(data.get("ever had a screening test for prostate cancer called a PSA"))
                .clickSubmit();
    }

    @Test
    public void maleGenericSurveyWithNoFamilyNoCancer()  {

        ExcelUtils excelUtils = new ExcelUtils();
        Map<String, String> data = excelUtils.getData("maleSurvey-11", "male", "./src/test/resources/testdata.xlsx");

        WebDriver driver = launchAppAndSurveyLogin();
        SurveyPage surveyPage = new SurveyPage(driver);
        DataGenerationUtils dataGenerationUtils=new DataGenerationUtils(new Faker());

        surveyPage.startSurvey()
                .enterFirstName(dataGenerationUtils.randomFirstName())
                .clickNext()
                .enterLastName(dataGenerationUtils.randomLastName())
                .clickNext()
                .enterDob(data.get("DOB"))
                .clickNext()
                .choosingGender(data.get("Sex"))
                .clickNext()
                .choosingAncestry(data.get("Ashkenazi or Eastern European Jewish ancestry"))
                .clickNext()
                .choosingAdoption(data.get("Adopted"))
                .clickNext()
                .isCancerous(data.get("Ever had Cancer"))
                .clickNext()
                .colonScreening(data.get("10 or more colon polyps"))
                .clickNext()
                .cancerInBloodRelatives(data.get("Any family developed cancer"))
                .clickNext()
                .enterHeight(data.get("Height"))
                .clickNext()
                .enterWeight(data.get("Weight"))
                .clickNext()
                .doYouSmoke(data.get("have a habit of smoke?"))
                .clickNext()
                .colonScreening(data.get("Screened for colorectal cancer"))
                .clickNext()
                .psaTest(data.get("ever had a screening test for prostate cancer called a PSA"))
                .clickNext()
                .lastPsaTest(data.get("last PSA (Prostate-Specific Antigen) test"))
                .clickSubmit();
    }

    @Test
    public void maleGenericSurveyWithLungCancer()  {

        ExcelUtils excelUtils = new ExcelUtils();
        Map<String, String> data = excelUtils.getData("maleSurvey-12", "male", "./src/test/resources/testdata.xlsx");

        WebDriver driver = launchAppAndSurveyLogin();
        SurveyPage surveyPage = new SurveyPage(driver);
        DataGenerationUtils dataGenerationUtils=new DataGenerationUtils(new Faker());

        surveyPage.startSurvey()
                .enterFirstName(dataGenerationUtils.randomFirstName())
                .clickNext()
                .enterLastName(dataGenerationUtils.randomLastName())
                .clickNext()
                .enterDob(data.get("DOB"))
                .clickNext()
                .choosingGender(data.get("Sex"))
                .clickNext()
                .choosingAncestry(data.get("Ashkenazi or Eastern European Jewish ancestry"))
                .clickNext()
                .choosingAdoption(data.get("Adopted"))
                .clickNext()
                .isCancerous(data.get("Ever had Cancer"))
                .clickNext()
                .cancerInRecentTimes(data.get("Cancer in the past 12 months"))
                .clickNext()
                .setTypeOfCancerAndAge(data.get("Type of Cancer"))
                .clickNext()
                .colonScreening(data.get("10 or more colon polyps"))
                .clickNext()
                .cancerInBloodRelatives(data.get("Any family developed cancer"))
                .clickNext()
                .enterHeight(data.get("Height"))
                .clickNext()
                .enterWeight(data.get("Weight"))
                .clickNext()
                .doYouSmoke(data.get("have a habit of smoke?"))
                .clickNext()
                .doYouSmoke(data.get("Do you currently smoke"))
                .clickNext()
                .yearsOfSmoke(data.get("For how many years did you smoke/have you been smoking?"))
                .clickNext()
                .cigarettesPerDay(data.get("how many packs of cigarettes"))
                .clickNext()
                .whenDidYouQuitSmoking(data.get("How long ago did you quit smoking?"))
                .clickNext()
                .colonScreening(data.get("Screened for colorectal cancer"))
                .clickNext()
                .colorectalRecentScreening(data.get("Colorectal screenings"))
                .clickNext()
                .whenWasLastColorectalScreening(data.get("most recent colorectal cancer screening?"))
                .clickNext()
                .cumulativeScreening(data.get("Have you ever had 10 or more polyps cumulatively from colon screenings?"))
                .clickNext()
                .psaTest(data.get("ever had a screening test for prostate cancer called a PSA"))
                .clickNext()
                .lastPsaTest(data.get("last PSA (Prostate-Specific Antigen) test"))
                .clickSubmit();
    }


    @Test
    public void maleGenericSurveyWithBreastCancer() {

        ExcelUtils excelUtils = new ExcelUtils();
        Map<String, String> data = excelUtils.getData("maleSurvey-14", "male", "./src/test/resources/testdata.xlsx");

        WebDriver driver = launchAppAndSurveyLogin();
        SurveyPage surveyPage = new SurveyPage(driver);
        DataGenerationUtils dataGenerationUtils=new DataGenerationUtils(new Faker());

        surveyPage.startSurvey()
                .enterFirstName(dataGenerationUtils.randomFirstName())
                .clickNext()
                .enterLastName(dataGenerationUtils.randomLastName())
                .clickNext()
                .enterDob(data.get("DOB"))
                .clickNext()
                .choosingGender(data.get("Sex"))
                .clickNext()
                .choosingAncestry(data.get("Ashkenazi or Eastern European Jewish ancestry"))
                .clickNext()
                .choosingAdoption(data.get("Adopted"))
                .clickNext()
                .isCancerous(data.get("Ever had Cancer"))
                .clickNext()
                .cancerInRecentTimes(data.get("Cancer in the past 12 months"))
                .clickNext()
                .setTypeOfCancerAndAge(data.get("Type of Cancer"))
                .clickNext()
                .cancerInBothBreasts("yes")
                .clickNext()
                .breastCancerHappenedMoreThanOnce("yes")
                .clickNext()
                .tripleNegativeBreast("yes")
                .clickNext()
                .enterHeight(data.get("Height"))
                .clickNext()
                .enterWeight(data.get("Weight"))
                .clickNext()
                .doYouSmoke(data.get("have a habit of smoke?"))
                .clickNext()
                .colonScreening(data.get("Screened for colorectal cancer"))
                .clickNext()
                .colorectalRecentScreening(data.get("Colorectal screenings"))
                .clickNext()
                .psaTest(data.get("ever had a screening test for prostate cancer called a PSA"))
                .clickNext()
                .clickSubmit();
    }




    /**female survey scenarios*/

    @Test
    public void feMaleGenericSurvey() {

        ExcelUtils excelUtils = new ExcelUtils();
        Map<String, String> data = excelUtils.getData("femaleSurvey-1", "female", "./src/test/resources/testdata.xlsx");

        WebDriver driver = launchAppAndSurveyLogin();
        SurveyPage surveyPage = new SurveyPage(driver);
        DataGenerationUtils dataGenerationUtils=new DataGenerationUtils(new Faker());

        surveyPage.startSurvey()
                .enterFirstName(dataGenerationUtils.randomFirstName())
                .clickNext()
                .enterLastName(dataGenerationUtils.randomLastName())
                .clickNext()
                .enterDob(data.get("DOB"))
                .clickNext()
                .choosingGender(data.get("Sex"))
                .clickNext()
                .choosingAncestry(data.get("Ashkenazi or Eastern European Jewish ancestry"))
                .clickNext()
                .choosingAdoption(data.get("Adopted"))
                .clickNext()
                .biologicalInfo(data.get("Medical information about your biological family"))
                .clickNext()
                .isCancerous(data.get("Ever had Cancer"))
                .clickNext()
                .cancerInRecentTimes(data.get("Cancer in the past 12 months"))
                .clickNext()
                .setTypeOfCancerAndAge(data.get("Type of Cancer"))
                .clickNext()
                .cancerInBothBreasts(data.get("Breast cancer in both breast"))
                .clickNext()
                .breastCancerHappenedMoreThanOnce(data.get("Breast Cancer happen more than once"))
                .clickNext()
                .tripleNegativeBreast(data.get("Triple negative breast cancer"))
                .clickNext()
                .colonScreening(data.get("10 or more colon polyps"))
                .clickNext()
                .cancerInBloodRelatives(data.get("Any family developed cancer"))
                .clickNext()
                .diagnosedWithCancer(data.get("Has anyone in family with prostate"))
                .clickNext()
                .cancerEducation()
                .whoElseHasCancerInFamily(data.get("Who in Family has cancer"))
                .clickNext()
                .parentsHistory(data.get("Family1"), 1)
                .typeOfCancers(data.get("Type of Cancer Parent"), 1)
                .clickRightNext(1)
                .diagnosedAge(data.get("Age of Diagnosis parent"), 1)
                .otherParentInfo(data.get("Do you have other parents who had cancer-1?"))
                .parentsHistory(data.get("Family 2"), 1)
                .clickNext()
                .typeOfCancers(data.get("Type of cancer family-2"), 1)
                .clickRightNext(1)
                .diagnosedAge(data.get("Age of Diagnosis family-2"), 1)
                .clickNext()
                .otherParentInfo(data.get("Do you have other family-2 who had cancer?"))
                .cousinThatHadCancer(data.get("Family 3"))
                .clickNext()
                .typeOfCancers(data.get("Type of cancer family-3"), 1)
                .clickRightNext(1)
                .diagnosedAge(data.get("Age of diagnosis family-3"), 1)
                .clickNext()
                .otherParentInfo(data.get("Do you have other family-3 who had cancer?"))
                .clickNext()
                .ageWhenFirstMenstrualPeriod(data.get("Menstrual period"))
                .clickNext()
                .goneThroughMenoPause(data.get("Menopause"))
                .clickNext()
                .howManyTimesPregnant(data.get("Pregnant"))
                .clickNext()
                .timesGivenBirth(data.get("Times given birth"))
                .clickNext()
                .ageWhenFirstBirth(data.get("Age at first birth"))
                .clickNext()
                .enterHeight(data.get("Height"))
                .clickNext()
                .enterWeight(data.get("Weight"))
                .clickNext()
                .doYouSmoke(data.get("have a habit of smoke?"))
                .clickNext()
                .doYouSmoke(data.get("Do you currently smoke"))
                .clickNext()
                .yearsOfSmoke(data.get("For how many years did you smoke/have you been smoking?"))
                .clickNext()
                .cigarettesPerDay(data.get("how many packs of cigarettes"))
                .clickNext()
                .colonScreening(data.get("Screened for colorectal cancer"))
                .clickNext()
                .colorectalRecentScreening(data.get("Colorectal screenings"))
                .clickNext()
                .whenWasLastColorectalScreening(data.get("most recent colorectal cancer screening?"))
                .clickNext()
                .cumulativeScreening(data.get("Have you ever had 10 or more polyps cumulatively from colon screenings?"))
                .clickNext()
                .mammogramForBreastCancerScreening(data.get("Prior Mammogram"))
                .clickNext()
                .lastMammogram(data.get("Last mamogram"))
                .clickNext()
                .everHadPapSmear(data.get("Pap smear"))
                .clickNext()
                .lastPapSmear(data.get("Last Papsmear"))
                .clickSubmit();
    }

    @Test
    public void feMaleGenericSurveyAdoptedNo() {

        ExcelUtils excelUtils = new ExcelUtils();
        Map<String, String> data = excelUtils.getData("femaleSurvey-2", "female", "./src/test/resources/testdata.xlsx");

        WebDriver driver = launchAppAndSurveyLogin();
        SurveyPage surveyPage = new SurveyPage(driver);
        DataGenerationUtils dataGenerationUtils=new DataGenerationUtils(new Faker());

        surveyPage.startSurvey()
                .enterFirstName(dataGenerationUtils.randomFirstName())
                .clickNext()
                .enterLastName(dataGenerationUtils.randomLastName())
                .clickNext()
                .enterDob(data.get("DOB"))
                .clickNext()
                .choosingGender(data.get("Sex"))
                .clickNext()
                .choosingAncestry(data.get("Ashkenazi or Eastern European Jewish ancestry"))
                .clickNext()
                .choosingAdoption(data.get("Adopted"))
                .clickNext()
                .isCancerous(data.get("Ever had Cancer"))
                .clickNext()
                .cancerInRecentTimes(data.get("Cancer in the past 12 months"))
                .clickNext()
                .setTypeOfCancerAndAge(data.get("Type of Cancer"))
                .clickNext()
                .colonScreening(data.get("10 or more colon polyps"))
                .clickNext()
                .cancerInBloodRelatives(data.get("Any family developed cancer"))
                .clickNext()
                .diagnosedWithCancer(data.get("Has anyone in family with prostate"))
                .clickNext()
                .cancerEducation()
                .whoElseHasCancerInFamily(data.get("Who in Family has cancer"))
                .clickNext()
                .parentsHistory(data.get("Family1"), 1)
                .typeOfCancers(data.get("Type of Cancer Parent"), 1)
                .clickRightNext(1)
                .diagnosedAge(data.get("Age of Diagnosis parent"), 1)
                .otherParentInfo(data.get("Do you have other parents who had cancer-1?"))
                .parentsHistory(data.get("Family 2"), 1)
                .clickNext()
                .typeOfCancers(data.get("Type of cancer family-2"), 1)
                .clickRightNext(1)
                .diagnosedAge(data.get("Age of Diagnosis family-2"), 1)
                .clickNext()
                .otherParentInfo(data.get("Do you have other family-2 who had cancer?"))
                .cousinThatHadCancer(data.get("Family 3"))
                .clickNext()
                .typeOfCancers(data.get("Type of cancer family-3"), 1)
                .clickRightNext(1)
                .diagnosedAge(data.get("Age of diagnosis family-3"), 1)
                .clickNext()
                .otherParentInfo(data.get("Do you have other family-3 who had cancer?"))
                .clickNext()
                .ageWhenFirstMenstrualPeriod(data.get("Menstrual period"))
                .clickNext()
                .goneThroughMenoPause(data.get("Menopause"))
                .clickNext()
                .howManyTimesPregnant(data.get("Pregnant"))
                .clickNext()
                .timesGivenBirth(data.get("Times given birth"))
                .clickNext()
                .ageWhenFirstBirth(data.get("Age at first birth"))
                .clickNext()
                .enterHeight(data.get("Height"))
                .clickNext()
                .enterWeight(data.get("Weight"))
                .clickNext()
                .doYouSmoke(data.get("have a habit of smoke?"))
                .clickNext()
                .doYouSmoke(data.get("Do you currently smoke"))
                .clickNext()
                .yearsOfSmoke(data.get("For how many years did you smoke/have you been smoking?"))
                .clickNext()
                .cigarettesPerDay(data.get("how many packs of cigarettes"))
                .clickNext()
                .colonScreening(data.get("Screened for colorectal cancer"))
                .clickNext()
                .colorectalRecentScreening(data.get("Colorectal screenings"))
                .clickNext()
                .whenWasLastColorectalScreening(data.get("most recent colorectal cancer screening?"))
                .clickNext()
                .cumulativeScreening(data.get("Have you ever had 10 or more polyps cumulatively from colon screenings?"))
                .clickNext()
                .mammogramForBreastCancerScreening(data.get("Prior Mammogram"))
                .clickNext()
                .lastMammogram(data.get("Last mamogram"))
                .clickNext()
                .everHadPapSmear(data.get("Pap smear"))
                .clickNext()
                .lastPapSmear(data.get("Last Papsmear"))
                .clickSubmit();
    }

    @Test
    public void feMaleGenericSurveyAdoptedNoAncestryNo() {

        ExcelUtils excelUtils = new ExcelUtils();
        Map<String, String> data = excelUtils.getData("femaleSurvey-3", "female", "./src/test/resources/testdata.xlsx");

        WebDriver driver = launchAppAndSurveyLogin();
        SurveyPage surveyPage = new SurveyPage(driver);
        DataGenerationUtils dataGenerationUtils=new DataGenerationUtils(new Faker());

        surveyPage.startSurvey()
                .enterFirstName(dataGenerationUtils.randomFirstName())
                .clickNext()
                .enterLastName(dataGenerationUtils.randomLastName())
                .clickNext()
                .enterDob(data.get("DOB"))
                .clickNext()
                .choosingGender(data.get("Sex"))
                .clickNext()
                .choosingAncestry(data.get("Ashkenazi or Eastern European Jewish ancestry"))
                .clickNext()
                .choosingAdoption(data.get("Adopted"))
                .clickNext()
                .isCancerous(data.get("Ever had Cancer"))
                .clickNext()
                .colonScreening(data.get("10 or more colon polyps"))
                .clickNext()
                .cancerInBloodRelatives(data.get("Any family developed cancer"))
                .clickNext()
                .diagnosedWithCancer(data.get("Has anyone in family with prostate"))
                .clickNext()
                .cancerEducation()
                .whoElseHasCancerInFamily(data.get("Who in Family has cancer"))
                .clickNext()
                .parentsHistory(data.get("Family1"), 1)
                .typeOfCancers(data.get("Type of Cancer Parent"), 1)
                .clickRightNext(1)
                .diagnosedAge(data.get("Age of Diagnosis parent"), 1)
                .otherParentInfo(data.get("Do you have other parents who had cancer-1?"))
                .parentsHistory(data.get("Family 2"), 1)
                .clickNext()
                .typeOfCancers(data.get("Type of cancer family-2"), 1)
                .clickRightNext(1)
                .diagnosedAge(data.get("Age of Diagnosis family-2"), 1)
                .clickNext()
                .otherParentInfo(data.get("Do you have other family-2 who had cancer?"))
                .parentsHistory(data.get("Family 3"),1)
                .clickNext()
                .typeOfCancers(data.get("Type of cancer family-3"), 1)
                .clickRightNext(1)
                .diagnosedAge(data.get("Age of diagnosis family-3"), 1)
                .clickNext()
                .otherParentInfo(data.get("Do you have other family-3 who had cancer?"))
                .clickNext()
                .parentsHistory(data.get("Family 4"),1)
                .clickNext()
                .typeOfCancers(data.get("Type of Cancer family-4"), 1)
                .clickRightNext(1)
                .diagnosedAge(data.get("Age of diagnosis family-4"), 1)
                .clickNext()
                .otherParentInfo(data.get("Do you have other family-4 who had cancer?"))
                .clickNext()
                .ageWhenFirstMenstrualPeriod(data.get("Menstrual period"))
                .clickNext()
                .goneThroughMenoPause(data.get("Menopause"))
                .clickNext()
                .howManyTimesPregnant(data.get("Pregnant"))
                .clickNext()
                .timesGivenBirth(data.get("Times given birth"))
                .clickNext()
                .ageWhenFirstBirth(data.get("Age at first birth"))
                .clickNext()
                .enterHeight(data.get("Height"))
                .clickNext()
                .enterWeight(data.get("Weight"))
                .clickNext()
                .doYouSmoke(data.get("have a habit of smoke?"))
                .clickNext()
                .colonScreening(data.get("Screened for colorectal cancer"))
                .clickNext()
                .colorectalRecentScreening(data.get("Colorectal screenings"))
                .clickNext()
                .whenWasLastColorectalScreening(data.get("most recent colorectal cancer screening?"))
                .clickNext()
                .cumulativeScreening(data.get("Have you ever had 10 or more polyps cumulatively from colon screenings?"))
                .clickNext()
                .mammogramForBreastCancerScreening(data.get("Prior Mammogram"))
                .clickNext()
                .everHadPapSmear(data.get("Pap smear"))
                .clickSubmit();
    }

    @Test
    public void feMaleGenericSurveyNoCancer() {

        ExcelUtils excelUtils = new ExcelUtils();
        Map<String, String> data = excelUtils.getData("femaleSurvey-4", "female", "./src/test/resources/testdata.xlsx");

        WebDriver driver = launchAppAndSurveyLogin();
        SurveyPage surveyPage = new SurveyPage(driver);
        DataGenerationUtils dataGenerationUtils=new DataGenerationUtils(new Faker());

        surveyPage.startSurvey()
                .enterFirstName(dataGenerationUtils.randomFirstName())
                .clickNext()
                .enterLastName(dataGenerationUtils.randomLastName())
                .clickNext()
                .enterDob(data.get("DOB"))
                .clickNext()
                .choosingGender(data.get("Sex"))
                .clickNext()
                .choosingAncestry(data.get("Ashkenazi or Eastern European Jewish ancestry"))
                .clickNext()
                .choosingAdoption(data.get("Adopted"))
                .clickNext()
                .isCancerous(data.get("Ever had Cancer"))
                .clickNext()
                .colonScreening(data.get("10 or more colon polyps"))
                .clickNext()
                .cancerInBloodRelatives(data.get("Any family developed cancer"))
                .clickNext()
                .cancerEducation()
                .ageWhenFirstMenstrualPeriod(data.get("Menstrual period"))
                .clickNext()
                .goneThroughMenoPause(data.get("Menopause"))
                .clickNext()
                .howManyTimesPregnant(data.get("Pregnant"))
                .clickNext()
                .timesGivenBirth(data.get("Times given birth"))
                .clickNext()
                .ageWhenFirstBirth(data.get("Age at first birth"))
                .clickNext()
                .enterHeight(data.get("Height"))
                .clickNext()
                .enterWeight(data.get("Weight"))
                .clickNext()
                .doYouSmoke(data.get("have a habit of smoke?"))
                .clickNext()
                .doYouSmoke(data.get("Do you currently smoke"))
                .clickNext()
                .yearsOfSmoke(data.get("For how many years did you smoke/have you been smoking?"))
                .clickNext()
                .cigarettesPerDay(data.get("how many packs of cigarettes"))
                .clickNext()
                .whenDidYouQuitSmoking(data.get("How long ago did you quit smoking?"))
                .clickNext()
                .colonScreening(data.get("Screened for colorectal cancer"))
                .clickNext()
                .mammogramForBreastCancerScreening(data.get("Prior Mammogram"))
                .clickNext()
                .everHadPapSmear(data.get("Pap smear"))
                .clickSubmit();
    }

    @Test
    public void feMaleGenericSurveyJewish() {

        ExcelUtils excelUtils = new ExcelUtils();
        Map<String, String> data = excelUtils.getData("femaleSurvey-5", "female", "./src/test/resources/testdata.xlsx");

        WebDriver driver = launchAppAndSurveyLogin();
        SurveyPage surveyPage = new SurveyPage(driver);
        DataGenerationUtils dataGenerationUtils=new DataGenerationUtils(new Faker());

        surveyPage.startSurvey()
                .enterFirstName(dataGenerationUtils.randomFirstName())
                .clickNext()
                .enterLastName(dataGenerationUtils.randomLastName())
                .clickNext()
                .enterDob(data.get("DOB"))
                .clickNext()
                .choosingGender(data.get("Sex"))
                .clickNext()
                .choosingAncestry(data.get("Ashkenazi or Eastern European Jewish ancestry"))
                .clickNext()
                .choosingAdoption(data.get("Adopted"))
                .clickNext()
                .biologicalInfo(data.get("Medical information about your biological family"))
                .clickNext()
                .isCancerous(data.get("Ever had Cancer"))
                .clickNext()
                .cancerInRecentTimes(data.get("Cancer in the past 12 months"))
                .clickNext()
                .setTypeOfCancerAndAge(data.get("Type of Cancer"))
                .clickNext()
                .colonScreening(data.get("10 or more colon polyps"))
                .clickNext()
                .cancerInBloodRelatives(data.get("Any family developed cancer"))
                .clickNext()
                .diagnosedWithCancer(data.get("Has anyone in family with prostate"))
                .clickNext()
                .cancerEducation()
                .whoElseHasCancerInFamily(data.get("Who in Family has cancer"))
                .clickNext()
                .parentsHistory(data.get("Family1"), 1)
                .typeOfCancers(data.get("Type of Cancer Parent"), 1)
                .clickRightNext(1)
                .diagnosedAge(data.get("Age of Diagnosis parent"), 1)
                .otherParentInfo(data.get("Do you have other parents who had cancer-1?"))
                .parentsHistory(data.get("Family 2"), 1)
                .clickNext()
                .typeOfCancers(data.get("Type of cancer family-2"), 1)
                .clickRightNext(1)
                .diagnosedAge(data.get("Age of Diagnosis family-2"), 1)
                .diagnosedAge(data.get("Age of Diagnosis sibling"), 1)
                .clickNext()
                .otherParentInfo(data.get("Do you have other family-2 who had cancer?"))
                .cousinThatHadCancer(data.get("Family 3"))
                .clickNext()
                .typeOfCancers(data.get("Type of cancer family-3"), 1)
                .clickRightNext(1)
                .diagnosedAge(data.get("Age of diagnosis family-3"), 1)
                .clickNext()
                .otherParentInfo(data.get("Do you have other family-3 who had cancer?"))
                .clickNext()
                .ageWhenFirstMenstrualPeriod(data.get("Menstrual period"))
                .clickNext()
                .goneThroughMenoPause(data.get("Menopause"))
                .clickNext()
                .howManyTimesPregnant(data.get("Pregnant"))
                .clickNext()
                .timesGivenBirth(data.get("Times given birth"))
                .clickNext()
                .ageWhenFirstBirth(data.get("Age at first birth"))
                .clickNext()
                .enterHeight(data.get("Height"))
                .clickNext()
                .enterWeight(data.get("Weight"))
                .clickNext()
                .doYouSmoke(data.get("have a habit of smoke?"))
                .clickNext()
                .doYouSmoke(data.get("Do you currently smoke"))
                .clickNext()
                .yearsOfSmoke(data.get("For how many years did you smoke/have you been smoking?"))
                .clickNext()
                .cigarettesPerDay(data.get("how many packs of cigarettes"))
                .clickNext()
                .colonScreening(data.get("Screened for colorectal cancer"))
                .clickNext()
                .colorectalRecentScreening(data.get("Colorectal screenings"))
                .clickNext()
                .whenWasLastColorectalScreening(data.get("most recent colorectal cancer screening?"))
                .clickNext()
                .cumulativeScreening(data.get("Have you ever had 10 or more polyps cumulatively from colon screenings?"))
                .clickNext()
                .mammogramForBreastCancerScreening(data.get("Prior Mammogram"))
                .clickNext()
                .lastMammogram(data.get("Last mamogram"))
                .clickNext()
                .everHadPapSmear(data.get("Pap smear"))
                .clickNext()
                .lastPapSmear(data.get("Last Papsmear"))
                .clickSubmit();
    }


    @Test
    public void feMaleGenericSurveyNoMenoPause() {

        ExcelUtils excelUtils = new ExcelUtils();
        Map<String, String> data = excelUtils.getData("femaleSurvey-6", "female", "./src/test/resources/testdata.xlsx");

        WebDriver driver = launchAppAndSurveyLogin();
        SurveyPage surveyPage = new SurveyPage(driver);
        DataGenerationUtils dataGenerationUtils=new DataGenerationUtils(new Faker());

        surveyPage.startSurvey()
                .enterFirstName(dataGenerationUtils.randomFirstName())
                .clickNext()
                .enterLastName(dataGenerationUtils.randomLastName())
                .clickNext()
                .enterDob(data.get("DOB"))
                .clickNext()
                .choosingGender(data.get("Sex"))
                .clickNext()
                .choosingAncestry(data.get("Ashkenazi or Eastern European Jewish ancestry"))
                .clickNext()
                .choosingAdoption(data.get("Adopted"))
                .clickNext()
                .isCancerous(data.get("Ever had Cancer"))
                .clickNext()
                .colonScreening(data.get("10 or more colon polyps"))
                .clickNext()
                .cancerInBloodRelatives(data.get("Any family developed cancer"))
                .clickNext()
                .diagnosedWithCancer(data.get("Has anyone in family with prostate"))
                .clickNext()
                .cancerEducation()
                .whoElseHasCancerInFamily(data.get("Who in Family has cancer"))
                .clickNext()
                .parentsHistory(data.get("Family1"), 1)
                .typeOfCancers(data.get("Type of Cancer Parent"), 1)
                .clickRightNext(1)
                .diagnosedAge(data.get("Age of Diagnosis parent"), 1)
                .otherParentInfo(data.get("Do you have other parents who had cancer-1?"))
                .parentsHistory(data.get("Family 2"), 1)
                .clickNext()
                .typeOfCancers(data.get("Type of cancer family-2"), 1)
                .clickRightNext(1)
                .diagnosedAge(data.get("Age of Diagnosis family-2"), 1)
                .clickNext()
                .otherParentInfo(data.get("Do you have other family-2 who had cancer?"))
                .parentsHistory(data.get("Family 3"),1)
                .clickNext()
                .typeOfCancers(data.get("Type of cancer family-3"), 1)
                .clickRightNext(1)
                .diagnosedAge(data.get("Age of diagnosis family-3"), 1)
                .clickNext()
                .otherParentInfo(data.get("Do you have other family-3 who had cancer?"))
                .clickNext()
                .parentsHistory(data.get("Family 4"),1)
                .clickNext()
                .typeOfCancers(data.get("Type of Cancer family-4"), 1)
                .clickRightNext(1)
                .diagnosedAge(data.get("Age of diagnosis family-4"), 1)
                .clickNext()
                .otherParentInfo(data.get("Do you have other family-4 who had cancer?"))
                .clickNext()
                .ageWhenFirstMenstrualPeriod(data.get("Menstrual period"))
                .clickNext()
                .goneThroughMenoPause(data.get("Menopause"))
                .clickNext()
                .howManyTimesPregnant(data.get("Pregnant"))
                .clickNext()
                .timesGivenBirth(data.get("Times given birth"))
                .clickNext()
                .ageWhenFirstBirth(data.get("Age at first birth"))
                .clickNext()
                .enterHeight(data.get("Height"))
                .clickNext()
                .enterWeight(data.get("Weight"))
                .clickNext()
                .doYouSmoke(data.get("have a habit of smoke?"))
                .clickNext()
                .colonScreening(data.get("Screened for colorectal cancer"))
                .clickNext()
                .colorectalRecentScreening(data.get("Colorectal screenings"))
                .clickNext()
                .whenWasLastColorectalScreening(data.get("most recent colorectal cancer screening?"))
                .clickNext()
                .cumulativeScreening(data.get("Have you ever had 10 or more polyps cumulatively from colon screenings?"))
                .clickNext()
                .mammogramForBreastCancerScreening(data.get("Prior Mammogram"))
                .clickNext()
                .lastMammogram(data.get("Last mamogram"))
                .clickNext()
                .everHadPapSmear(data.get("Pap smear"))
                .clickNext()
                .lastPapSmear(data.get("Last Papsmear"))
                .clickSubmit();
    }

    @Test
    public void feMaleGenericSurveyUterineMenoPause() {

        ExcelUtils excelUtils = new ExcelUtils();
        Map<String, String> data = excelUtils.getData("femaleSurvey-7", "female", "./src/test/resources/testdata.xlsx");

        WebDriver driver = launchAppAndSurveyLogin();
        SurveyPage surveyPage = new SurveyPage(driver);
        DataGenerationUtils dataGenerationUtils=new DataGenerationUtils(new Faker());

        surveyPage.startSurvey()
                .enterFirstName(dataGenerationUtils.randomFirstName())
                .clickNext()
                .enterLastName(dataGenerationUtils.randomLastName())
                .clickNext()
                .enterDob(data.get("DOB"))
                .clickNext()
                .choosingGender(data.get("Sex"))
                .clickNext()
                .choosingAncestry(data.get("Ashkenazi or Eastern European Jewish ancestry"))
                .clickNext()
                .choosingAdoption(data.get("Adopted"))
                .clickNext()
                .isCancerous(data.get("Ever had Cancer"))
                .clickNext()
                .cancerInRecentTimes(data.get("Cancer in the past 12 months"))
                .clickNext()
                .setTypeOfCancerAndAge(data.get("Type of Cancer"))
                .clickNext()
                .colonScreening(data.get("10 or more colon polyps"))
                .clickNext()
                .cancerInBloodRelatives(data.get("Any family developed cancer"))
                .clickNext()
                .cancerEducation()
                .ageWhenFirstMenstrualPeriod(data.get("Menstrual period"))
                .clickNext()
                .goneThroughMenoPause(data.get("Menopause"))
                .clickNext()
                .ageWhenMenoPauseBegan(data.get("Age of menopause"))
                .clickNext()
                .reasonForMenoPause(data.get("Reason for Menopause"))
                .clickNext()
                .howManyTimesPregnant(data.get("Pregnant"))
                .clickNext()
                .timesGivenBirth(data.get("Times given birth"))
                .clickNext()
                .ageWhenFirstBirth(data.get("Age at first birth"))
                .clickNext()
                .enterHeight(data.get("Height"))
                .clickNext()
                .enterWeight(data.get("Weight"))
                .clickNext()
                .doYouSmoke(data.get("have a habit of smoke?"))
                .clickNext()
                .colonScreening(data.get("Screened for colorectal cancer"))
                .clickNext()
                .mammogramForBreastCancerScreening(data.get("Prior Mammogram"))
                .clickNext()
                .lastMammogram(data.get("Last mamogram"))
                .clickNext()
                .everHadPapSmear(data.get("Pap smear"))
                .clickNext()
                .lastPapSmear(data.get("Last Papsmear"))
                .clickSubmit();
    }

    @Test
    public void feMaleGenericSurveyUterineCancerMenoPause() {

        ExcelUtils excelUtils = new ExcelUtils();
        Map<String, String> data = excelUtils.getData("femaleSurvey-8", "female", "./src/test/resources/testdata.xlsx");

        WebDriver driver = launchAppAndSurveyLogin();
        SurveyPage surveyPage = new SurveyPage(driver);
        DataGenerationUtils dataGenerationUtils=new DataGenerationUtils(new Faker());

        surveyPage.startSurvey()
                .enterFirstName(dataGenerationUtils.randomFirstName())
                .clickNext()
                .enterLastName(dataGenerationUtils.randomLastName())
                .clickNext()
                .enterDob(data.get("DOB"))
                .clickNext()
                .choosingGender(data.get("Sex"))
                .clickNext()
                .choosingAncestry(data.get("Ashkenazi or Eastern European Jewish ancestry"))
                .clickNext()
                .choosingAdoption(data.get("Adopted"))
                .clickNext()
                .isCancerous(data.get("Ever had Cancer"))
                .clickNext()
                .cancerInRecentTimes(data.get("Cancer in the past 12 months"))
                .clickNext()
                .setTypeOfCancerAndAge(data.get("Type of Cancer"))
                .clickNext()
                .colonScreening(data.get("10 or more colon polyps"))
                .clickNext()
                .cancerInBloodRelatives(data.get("Any family developed cancer"))
                .clickNext()
                .cancerEducation()
                .ageWhenFirstMenstrualPeriod(data.get("Menstrual period"))
                .clickNext()
                .goneThroughMenoPause(data.get("Menopause"))
                .clickNext()
                .ageWhenMenoPauseBegan(data.get("Age of menopause"))
                .clickNext()
                .reasonForMenoPause(data.get("Reason for Menopause"))
                .clickNext()
                .howManyTimesPregnant(data.get("Pregnant"))
                .clickNext()
                .timesGivenBirth(data.get("Times given birth"))
                .clickNext()
                .ageWhenFirstBirth(data.get("Age at first birth"))
                .clickNext()
                .enterHeight(data.get("Height"))
                .clickNext()
                .enterWeight(data.get("Weight"))
                .clickNext()
                .doYouSmoke(data.get("have a habit of smoke?"))
                .clickNext()
                .colonScreening(data.get("Screened for colorectal cancer"))
                .clickNext()
                .mammogramForBreastCancerScreening(data.get("Prior Mammogram"))
                .clickNext()
                .lastMammogram(data.get("Last mamogram"))
                .clickNext()
                .everHadPapSmear(data.get("Pap smear"))
                .clickNext()
                .lastPapSmear(data.get("Last Papsmear"))
                .clickSubmit();
    }

    @Test
    public void feMaleGenericSurveyEndometrialCancerMenoPause() {

        ExcelUtils excelUtils = new ExcelUtils();
        Map<String, String> data = excelUtils.getData("femaleSurvey-9", "female", "./src/test/resources/testdata.xlsx");

        WebDriver driver = launchAppAndSurveyLogin();
        SurveyPage surveyPage = new SurveyPage(driver);
        DataGenerationUtils dataGenerationUtils=new DataGenerationUtils(new Faker());

        surveyPage.startSurvey()
                .enterFirstName(dataGenerationUtils.randomFirstName())
                .clickNext()
                .enterLastName(dataGenerationUtils.randomLastName())
                .clickNext()
                .enterDob(data.get("DOB"))
                .clickNext()
                .choosingGender(data.get("Sex"))
                .clickNext()
                .choosingAncestry(data.get("Ashkenazi or Eastern European Jewish ancestry"))
                .clickNext()
                .choosingAdoption(data.get("Adopted"))
                .clickNext()
                .isCancerous(data.get("Ever had Cancer"))
                .clickNext()
                .cancerInRecentTimes(data.get("Cancer in the past 12 months"))
                .clickNext()
                .setTypeOfCancerAndAge(data.get("Type of Cancer"))
                .clickNext()
                .colonScreening(data.get("10 or more colon polyps"))
                .clickNext()
                .cancerInBloodRelatives(data.get("Any family developed cancer"))
                .clickNext()
                .cancerEducation()
                .ageWhenFirstMenstrualPeriod(data.get("Menstrual period"))
                .clickNext()
                .goneThroughMenoPause(data.get("Menopause"))
                .clickNext()
                .ageWhenMenoPauseBegan(data.get("Age of menopause"))
                .clickNext()
                .reasonForMenoPause(data.get("Reason for Menopause"))
                .clickNext()
                .howManyTimesPregnant(data.get("Pregnant"))
                .clickNext()
                .timesGivenBirth(data.get("Times given birth"))
                .clickNext()
                .ageWhenFirstBirth(data.get("Age at first birth"))
                .clickNext()
                .enterHeight(data.get("Height"))
                .clickNext()
                .enterWeight(data.get("Weight"))
                .clickNext()
                .doYouSmoke(data.get("have a habit of smoke?"))
                .clickNext()
                .colonScreening(data.get("Screened for colorectal cancer"))
                .clickNext()
                .mammogramForBreastCancerScreening(data.get("Prior Mammogram"))
                .clickNext()
                .lastMammogram(data.get("Last mamogram"))
                .clickNext()
                .everHadPapSmear(data.get("Pap smear"))
                .clickNext()
                .lastPapSmear(data.get("Last Papsmear"))
                .clickSubmit();
    }

}



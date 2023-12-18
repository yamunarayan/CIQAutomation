package org.ciq.tests.surveys;

import com.github.javafaker.Faker;
import org.ciq.pages.AmericanCancerSocietyPage;
import org.ciq.pages.SurveyPage;
import org.ciq.tests.BaseTest;
import org.ciq.utils.DataGenerationUtils;
import org.ciq.utils.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Map;

public class AmericanCancerSocietySurveyTest extends BaseTest {
    DataGenerationUtils dataGenerationUtils = new DataGenerationUtils(new Faker());

    String firstName = dataGenerationUtils.randomFirstName();
    String lastName = dataGenerationUtils.randomLastName();

    @Test(groups = {"survey", "male", "maleGenericSurvey","americanCancerSocietyMaleGenericSurvey"})
    public void americanCancerSocietyMaleGenericSurvey() {


        ExcelUtils excelUtils = new ExcelUtils();
        Map<String, String> data = excelUtils.getData("maleSurvey-1", "americansurvey", "./src/test/resources/testdata.xlsx");

        WebDriver driver = launchAppAndAmericanCancerSocietySurveyLogin();
        AmericanCancerSocietyPage americanCancerSocietyPage = new AmericanCancerSocietyPage(driver);

        americanCancerSocietyPage.clickTakeTheSurvey()
                .navigateToSurveyPage()
                .clickBeginAssessment()
                .enterFirstName(firstName)
                .clickNext()
                .enterLastName(lastName)
                .clickNext()
                .enterDob(data.get("DOB"))
                .clickNext()
                .enterEmail(firstName + lastName + "@email.com")
                .enterConfirmEmail(firstName + lastName + "@email.com")
                .clickNext()
                .choosingGender(data.get("Sex"))
                .clickNext()
                .choosingAdoption(data.get("Adopted"))
                .clickNext()
                .biologicalInfo(data.get("Medical information about your biological family"))
                .clickNext()
                .choosingAncestry(data.get("Ashkenazi or Eastern European Jewish ancestry"))
                .clickNext()
                .isCancerous(data.get("Ever had Cancer"))
                .clickNext()
                .cancerInRecentTimes(data.get("Cancer in the past 12 months"))
                .clickNext()
                .setTypeOfCancerAndAge(data.get("Type of Cancer"))
                .clickNext()
                .colorectalMoreThanOnce(data.get("Did the colorectal cancer happen more than once?"))
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
                .colonScreening(data.get("Screened for colorectal cancer"))
                .clickNext()
                .colorectalRecentScreening(data.get("Colorectal screenings"))
                .clickNext()
                .whenWasLastColorectalScreening(data.get("most recent colorectal cancer screening?"))
                .clickNext()
                .cumulativeScreening(data.get("Have you ever had 10 or more polyps cumulatively from colon screenings?"))
                .clickNext()
                .doYouSmoke(data.get("have a habit of smoke?"))
                .clickNext()
                .doYouSmoke(data.get("Do you currently smoke"))
                .clickNext()
                .yearsOfSmoke(data.get("For how many years did you smoke/have you been smoking?"))
                .clickNext()
                .cigarettesPerDay(data.get("how many packs of cigarettes"))
                .clickNext()
                .psaTest(data.get("ever had a screening test for prostate cancer called a PSA"))
                .clickNext()
                .lastPsaTest(data.get("last PSA (Prostate-Specific Antigen) test"))
                .clickNext()
                .hereditaryCancerSyndrome(data.get("Had genetic test for hereditary cancer syndromes"))
                .clickNext()
                .testedForBRCA1Or2(data.get("Tested positive for BRCA1 or BRCA2"))
                .clickNext()
                .testedForLynchSyndrome(data.get("Tested positive for lynch syndrome"))
                .clickSubmit();
    }
}













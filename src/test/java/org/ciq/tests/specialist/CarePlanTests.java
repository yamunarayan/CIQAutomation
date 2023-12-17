package org.ciq.tests.specialist;

import com.github.javafaker.Faker;
import org.ciq.pages.SpecialistPendingDashBoardPage;
import org.ciq.tests.BaseTest;
import org.ciq.utils.DataGenerationUtils;
import org.ciq.utils.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Map;

public class CarePlanTests extends BaseTest {

    ExcelUtils excelUtils = new ExcelUtils();
    Map<String, String> data;
    WebDriver driver;
    String path = "./src/test/resources/testdata.xlsx";
    SpecialistPendingDashBoardPage specialistPendingDashBoardPage;
    DataGenerationUtils dataGenerationUtils=new DataGenerationUtils(new Faker());
    String firstName = dataGenerationUtils.randomFirstName();
    String lastName = dataGenerationUtils.randomLastName();

    @Test(groups = {"specialist","specialistCarePlanCheck", "CarePlan", "mammogram", "GenerateReports"})
    public void specialistCarePlanCheck() throws InterruptedException {

        ExcelUtils excelUtils = new ExcelUtils();
        Map<String, String> data = excelUtils.getData("SpecialistMamogramCheck", "specialist", "./src/test/resources/testdata.xlsx");

        WebDriver driver = launchAppAndLogin("specialistUrl");

        SpecialistPendingDashBoardPage specialistPendingDashBoardPage = new SpecialistPendingDashBoardPage(driver);
        DataGenerationUtils dataGenerationUtils=new DataGenerationUtils(new Faker());

        String firstName = dataGenerationUtils.randomFirstName();
        String lastName = dataGenerationUtils.randomLastName();

        specialistPendingDashBoardPage.clickCreatePatientButton()
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .chooseGender(data.get("Sex"))
                .enterDob(data.get("DOB"))
                .chooseLocation(data.get("Location"))
                .enterEmail(firstName+lastName+"@email.com")
                .enterConfirmEmail(firstName+lastName+"@email.com")
                .chooseStatPatient(data.get("STAT patient"))
                .clickNext()
                .clickSkipAddPatient()
                .clickPatientRecord(firstName)
                .clickReviewPatient()
                .scrollDownByXY(0,900)
                .scrollToElementAndClick("Reproductive History")
                .enterAgeOfMenarche(data.get("Age of Menarche"),"Age of Menarche")
                .chooseMenopauseStatus(data.get("Menopausal Status"),"Menopausal Status")
                .clickSaveChanges()
                .scrollDownByXY(0,1800)
                .scrollToElementAndClick("Screening History")
                .enterBreastBiopsies(data.get("Number of Breast Biopsies"),"Number of Breast Biopsies")
                .enterColonPolyps(data.get("Number of Colon Polyps"),"Number of Colon Polyps")
                .clickSaveChanges()
                .clickPatientNavigationTab("Risk Assessment")
                .ValidateCarePlanEligibilities(data.get("Care Plan"))
                .clickPatientNavigationTab("Generate Reports")
                .chooseReports("For Patients")
                .viewReports(data.get("ReportName"),"PDF","save")
                .viewSavedReports(data.get("ReportName"));
    }


    //TC2 : CIQ-3350
    @Test(groups = {"specialist","specialistAromatasePlanCheck", "Aromatase","CarePlan"})
    public void specialistAromatasePlanCheck() throws InterruptedException {

        ExcelUtils excelUtils = new ExcelUtils();
        Map<String, String> data = excelUtils.getData("SpecialistAromataseCheck", "specialist", "./src/test/resources/testdata.xlsx");

        WebDriver driver = launchAppAndLogin("specialistUrl");

        SpecialistPendingDashBoardPage specialistPendingDashBoardPage = new SpecialistPendingDashBoardPage(driver);
        DataGenerationUtils dataGenerationUtils=new DataGenerationUtils(new Faker());

        String firstName = dataGenerationUtils.randomFirstName();
        String lastName = dataGenerationUtils.randomLastName();

        specialistPendingDashBoardPage.clickCreatePatientButton()
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .chooseGender(data.get("Sex"))
                .enterDob(data.get("DOB"))
                .chooseLocation(data.get("Location"))
                .enterEmail(firstName+lastName+"@email.com")
                .enterConfirmEmail(firstName+lastName+"@email.com")
                .chooseStatPatient(data.get("STAT patient"))
                .clickNext()
                .clickSkipAddPatient()
                .clickPatientRecord(firstName)
                .clickReviewPatient()
                .scrollDownByXY(0,600)
                .scrollToElementAndClick("Basic Information")
                .selectGeneticTestResult(data.get("Has Had Genetic Testing"),"Has Had Genetic Testing")
                .addPathogenicMutations(data.get("Add Pathogenic Mutations1"),"Add Pathogenic Mutations")
                .clickAddMutation("Add Pathogenic Mutations")
                .addPathogenicMutations(data.get("Add Pathogenic Mutations2"),"Add Pathogenic Mutations")
                .clickAddMutation("Add Pathogenic Mutations")
                .clickSaveChanges()
                .scrollDownByXY(0,1500)
                .scrollToElementAndClick("Specialist-Entered Patient Info")
                .selectBreastERStatus(data.get("Breast ER Status"),"Breast ER Status")
                .clickSaveChanges()
                .ValidateCarePlanEligibilities(data.get("Care Plan"));

    }
}


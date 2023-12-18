package org.ciq.tests.specialist;

import com.github.javafaker.Faker;

import org.ciq.pages.SpecialistPendingDashBoardPage;
import org.ciq.tests.BaseTest;
import org.ciq.utils.ConfigLoader;
import org.ciq.utils.DataGenerationUtils;
import org.ciq.utils.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class SpecialistTests extends BaseTest {
    ExcelUtils excelUtils = new ExcelUtils();
    Map<String, String> data;
    WebDriver driver;
    String path = "./src/test/resources/testdata.xlsx";
    SpecialistPendingDashBoardPage specialistPendingDashBoardPage;
    DataGenerationUtils dataGenerationUtils=new DataGenerationUtils(new Faker());
    String firstName = dataGenerationUtils.randomFirstName();
    String lastName = dataGenerationUtils.randomLastName();

    @Test(groups = {"specialist","addSpecialist"})
    public void addSpecialist() throws InterruptedException {

        data =excelUtils.getData("addSpecialist", "specialist", path);
        driver = launchAppAndLogin("specialistUrl");
        specialistPendingDashBoardPage = new SpecialistPendingDashBoardPage(driver);
        specialistPendingDashBoardPage.clickCreatePatientButton()
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .chooseGender(data.get("Sex"))
                .enterDob(data.get("DOB"))
                .chooseLocation(data.get("Location"))
                .enterEmail(firstName+lastName+"@email.com")
                .enterConfirmEmail(firstName+lastName+"@email.com")
                .chooseStatPatient(data.get("STAT patient"))
                .enterMRNNumber(data.get("Mrn"))
                .clickNext()
                .clickSkipAddPatient();
    }

    @Test(groups = {"specialist","specialistE2e", "carePlan"})
    public void specialistE2e() throws InterruptedException {


        data = excelUtils.getData("specialistE2e-1", "specialist", "./src/test/resources/testdata.xlsx");
        WebDriver driver = launchAppAndLogin("specialistUrl");
        specialistPendingDashBoardPage = new SpecialistPendingDashBoardPage(driver);

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
                .getMRNNumber("MRN",data.get("Mrn"))
                .scrollDownByXY(0,1200)
                .scrollToElementAndClick("Medical History")
                .chooseCancer(data.get("Type of Cancer-1"))
                .enterAgeOfDiagnosis(data.get("Age of Diagnosis-1"),1)
                .clickAnyAddButton("Add Cancer")
                .chooseCancer(data.get("Type of Cancer-2"))
                .enterAgeOfDiagnosis(data.get("Age of Diagnosis-2"),2)
                .clickSaveChanges()
                .clickPatientNavigationTab("Testing")
                .navigateToEthicaUrl(ConfigLoader.getConfigValue("registryUrl"))
                .clickPatientRecord(firstName, lastName)
                .validateListOfPatientEligibilities(data.get("eligibilities"));
    }

    @Test(groups = {"sendEmail"})
    public void email() throws InterruptedException {
        data =excelUtils.getData("addSpecialist-1", "specialist", path);
        driver = launchAppAndLogin("specialistUrl");
        specialistPendingDashBoardPage = new SpecialistPendingDashBoardPage(driver);
        specialistPendingDashBoardPage
               .clickCreatePatientButton()
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
                .navigateToEthicaUrl(ConfigLoader.getConfigValue("registryUrl"))
                .clickPatientRecord(firstName, lastName)
                .clickStartScreening("Start Screening")
                .clickOnlineScreening("Online Screening")
                .clickButton("Change")
                .enterEmail("yjayaraman+03214@canceriq.com")
                .enterConfirmEmail("yjayaraman+03214@canceriq.com")
                .clickButton("Save")
                .clickButton("Initiate")
                .navigateToOutlookUrl(ConfigLoader.getConfigValue("outlookUrl"))
                .sendEmail();


    }




}

package org.ciq.tests.specialist;

import com.github.javafaker.Faker;
import org.ciq.pages.RegistryPage;
import org.ciq.pages.SpecialistPendingDashBoardPage;
import org.ciq.pages.SurveyPage;
import org.ciq.tests.BaseTest;
import org.ciq.utils.ConfigLoader;
import org.ciq.utils.DataGenerationUtils;
import org.ciq.utils.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Map;

public class SpecialistTests extends BaseTest {

    @Test(groups = {"specialist","specialistE2e"})
    public void specialistE2e(){

        ExcelUtils excelUtils = new ExcelUtils();
        Map<String, String> data = excelUtils.getData("specialistE2e-1", "specialist", "./src/test/resources/testdata.xlsx");

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
                .clickPatientRecord(firstName, lastName);

    }


}

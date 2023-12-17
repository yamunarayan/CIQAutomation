package org.ciq.tests.specialist;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.github.javafaker.Faker;
import org.ciq.pages.SpecialistPendingDashBoardPage;
import org.ciq.tests.BaseTest;
import org.ciq.utils.ConfigLoader;
import org.ciq.utils.DataGenerationUtils;
import org.ciq.utils.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Map;

public class PatientDetailsTests extends BaseTest {

    ExcelUtils excelUtils = new ExcelUtils();
    Map<String, String> data;
    WebDriver driver;
    String path = "./src/test/resources/testdata.xlsx";
    SpecialistPendingDashBoardPage specialistPendingDashBoardPage;
    DataGenerationUtils dataGenerationUtils=new DataGenerationUtils(new Faker());
    String firstName = dataGenerationUtils.randomFirstName();
    String lastName = dataGenerationUtils.randomLastName();

    @Test(groups = {"specialist","addSpecialist", "validateMRNFieldWithValue", "CIQ-4773", "InSprint"})
    public void validateMRNFieldWithValue() throws InterruptedException {
        data =excelUtils.getData("addSpecialist-1", "specialist", path);
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
                .clickSkipAddPatient()
                .clickPatientRecord(firstName)
                .clickReviewPatient()
                .getMRNNumber("MRN",data.get("Mrn"))
                .navigateToEthicaUrl(ConfigLoader.getConfigValue("registryUrl"))
                .clickPatientRecord(firstName, lastName)
                .getMRNNumber("MRN", data.get("Mrn"));

    }

    @Test(groups = {"specialist","addSpecialist", "validateMRNFieldOptional", "CIQ-4773", "InSprint"})
    public void validateMRNFieldOptional() throws InterruptedException {
        data =excelUtils.getData("addSpecialist-1", "specialist", path);
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
                .clickSkipAddPatient()
                .clickPatientRecord(firstName)
                .clickReviewPatient()
                .getMRNNumber("MRN",data.get("Mrn"))
                .navigateToEthicaUrl(ConfigLoader.getConfigValue("registryUrl"))
                .clickPatientRecord(firstName, lastName)
                .getMRNNumber("MRN",data.get("Mrn"));


    }
}

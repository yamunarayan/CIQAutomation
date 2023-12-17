package org.ciq.tests.specialist;

import com.github.javafaker.Faker;
import org.ciq.pages.SpecialistPendingDashBoardPage;
import org.ciq.tests.BaseTest;
import org.ciq.utils.DataGenerationUtils;
import org.ciq.utils.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class GenerateReportTests extends BaseTest {

    @Test(groups = {"specialist","reportsRead", "CarePlan", "mammogram", "GenerateReports"})
    public void reportsRead() throws InterruptedException, IOException {

        ExcelUtils excelUtils = new ExcelUtils();
        Map<String, String> data = excelUtils.getData("readReports", "specialist", "./src/test/resources/testdata.xlsx");

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
                .clickPatientNavigationTab("Generate Reports")
                .chooseReports("For Patients")
                .downloadReports(data.get("ReportName"),"PDF","download");
    }
}

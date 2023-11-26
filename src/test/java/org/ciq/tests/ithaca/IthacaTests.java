package org.ciq.tests.ithaca;

import com.github.javafaker.Faker;
import org.ciq.pages.RegistryPage;
import org.ciq.pages.SpecialistPendingDashBoardPage;
import org.ciq.tests.BaseTest;
import org.ciq.utils.DataGenerationUtils;
import org.ciq.utils.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.Map;

public class IthacaTests extends BaseTest {

    @Test(groups = {"ithaca","checkRecommendedCarePlanIthaca", "addPatientithaca", "lung screening"})
    public void checkRecommendedCarePlanIthaca() throws InterruptedException {
        ExcelUtils excelUtils= new ExcelUtils();
        Map<String, String> data = excelUtils.getData("ithacaCarePlanEligibility", "ithaca", "./src/test/resources/testdata.xlsx");

        WebDriver driver= launchAppAndLogin("registryUrl");

        RegistryPage registryPage = new RegistryPage(driver);
        DataGenerationUtils dataGenerationUtils=new DataGenerationUtils(new Faker());

        String firstName = dataGenerationUtils.randomFirstName();
        String lastName = dataGenerationUtils.randomLastName();

        registryPage.clickCreateNewPatient()
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .chooseBirthSex(data.get("Sex"))
                .enterDay(data.get("DayOfBirth"))
                .enterMonth(data.get("MonthOfBirth"))
                .enterYear(data.get("YearOfBirth"))
                .clickSubmit()
                .clickPatientRecord(firstName,lastName)
                .clickStartScreening()
                .clickPrescreenedReferral("PRESCREENED_REFERRAL")
                .clickButton("Initiate")
                .scrollDownByXY(1122,2506)
                .enterYearsSmoked(data.get("Years Smoked"))
                .enterNumberOfPacks(data.get("Number of Packs Per Day"))
                //.selectCurrentlySmokes(data.get("Currently Smokes"),"Currently Smokes")
                .clickButton("Review Changes")
                .clickButton("Save")
                .clickAddCarePlan("Lung Screening")
                .clickIthacaTab("Care Plans")
               .checkRecommendedCarePlan(data.get("Recommended CarePlan"));
        
    }

}

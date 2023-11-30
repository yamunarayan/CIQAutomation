package org.ciq.tests.specialist;

import com.github.javafaker.Faker;
import org.ciq.pages.SpecialistPendingDashBoardPage;
import org.ciq.tests.BaseTest;
import org.ciq.utils.ConfigLoader;
import org.ciq.utils.DataGenerationUtils;
import org.ciq.utils.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
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

    //TC1 : CIQ-3582, TC7
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

    //TC3, TC5 , TC6
    @Test(groups = {"specialist","specialistHBOCAndHCC", "HBOC", "HCC", "updateTestResult", "printAssessment"})
    public void specialistHBOCAndHCC() throws InterruptedException {

        ExcelUtils excelUtils = new ExcelUtils();
        Map<String, String> data = excelUtils.getData("SpecialistHBOCAndHCCCheck", "specialist", "./src/test/resources/testdata.xlsx");

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
                .enterWeight(data.get("Weight(lb)"),"Weight(lb)")
                .enterHeight(data.get("Height"),"Height")
                .addComorbidity(data.get("Comorbidity"),"Comorbidity")
                .enterAgeOfDiagnosis(data.get("Age of Diagnosis"),1,"Comorbidity")
                .selectSurgey(data.get("Surgery"),"Surgery",1)
                .clickSaveChanges()
                .scrollDownByXY(0,600)
                .scrollToElementAndClick("Basic Information")
                .chooseRace(data.get("Race"),"Race")
                .chooseSubRace(data.get("Sub Race"),"Sub Race")
                .selectGeneticTestResult(data.get("Has Had Genetic Testing"),"Has Had Genetic Testing")
                .clickSaveChanges()
                .scrollDownByXY(0,900)
                .scrollToElementAndClick("Reproductive History")
                .chooseMenopauseStatus(data.get("Menopausal Status"),"Menopausal Status")
                .enterGravida(data.get("Gravida"),"Gravida")
                .enterParity(data.get("Parity"),"Parity")
                .enterAgeOfFirstBirth(data.get("Age of First Birth"),"Age of First Birth")
                .clickSaveChanges()
                .navigateToEthicaUrl(ConfigLoader.getConfigValue("registryUrl"))
                .clickPatientRecord(firstName, lastName)
                .addFamilyMember("Family Cancer History", data.get("Family Grouping1"))
                .addRelationshipCancer(data.get("Relationship1"),data.get("Cancer Type1"),data.get("Age Of Diagnosis1"))
                .clickButton("Submit")
                .addFamilyMember("Family Cancer History", data.get("Family Grouping2"))
                .addRelationshipCancer(data.get("Relationship2"),data.get("Cancer Type2"),data.get("Age Of Diagnosis2"))
                .clickButton("Submit")
                .navigateToSpecialistUrl(ConfigLoader.getConfigValue("specialistUrl"))
                .clickPatientRecord(firstName)
                .clickReviewPatient()
                .clickPatientNavigationTab("Testing")
                .validateHbocAndHccStatus("class","switch ng-valid checked","fa check-icon fa-check-circle bg-green")
                .testSelectionPanelEligibilities("Primary","HBOC")
                .testSelectionPanelEligibilities("Secondary","Lynch Syndrome")
                .selectVendors(data.get("Vendors"))
                .selecttest(data.get("Test"))
                .clickButton("Next")
                .clickButton("Next")
                .clickButton("Next")
                .clickButton("Next")
                .clickButton("Next")
                .clickButton("Print")
                .checkTestResultPanel(data.get("Test Result"))
                .enterTestResult(data.get("TestName1"),data.get("TestResultOption1"))
                .enterTestResult(data.get("TestName2"),data.get("TestResultOption2"))
                .clickButton("Save Test Results")
                .validateSavedResults(data.get("TestName1"),data.get("TestResultOption1"))
                .validateSavedResults(data.get("TestName2"),data.get("TestResultOption2"))
                .clickViewCompletedForms()
                .downloadForms(data.get("FormNames"))
                .clickToClosePopup()
                .clickButton("Update Test Results")
                .enterTestResult(data.get("TestName3"),data.get("TestResultOption3"))
                .addAdditionalVariant(data.get("TestName3"),data.get("AdditionalTestResultOption"))
                .clickButton("Save Test Results")
                .validateSavedResults(data.get("TestName3"),data.get("AdditionalTestResultOption"))
                .clickRunRiskAssessmentButton()
                .clickPrintAssessment("CIQ|Specialist");
         }

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
                     //.getMRNNumber("MRN",data.get("Mrn"))
                     .navigateToEthicaUrl(ConfigLoader.getConfigValue("registryUrl"))
                     .clickPatientRecord(firstName, lastName);
                    // .getMRNNumber("MRN", data.get("Mrn"));

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

    @Test(groups = {"specialist","Tempus", "updateTestResult", "regression"})
    public void validatWithTempusVendor() throws InterruptedException {

        ExcelUtils excelUtils = new ExcelUtils();
        Map<String, String> data = excelUtils.getData("ValidateTempus", "specialist", "./src/test/resources/testdata.xlsx");

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
                .enterMRNNumber(data.get("Mrn"))
                .clickNext()
                .clickSkipAddPatient()
                .clickPatientRecord(firstName)
                .clickReviewPatient()
                .navigateToEthicaUrl(ConfigLoader.getConfigValue("registryUrl"))
                .clickPatientRecord(firstName, lastName)
                .addFamilyMember("Family Cancer History", data.get("Family Grouping1"))
                .addRelationshipCancer(data.get("Relationship1"),data.get("Cancer Type1"),data.get("Age Of Diagnosis1"))
                .clickButton("Submit")
                .addFamilyMember("Family Cancer History", data.get("Family Grouping2"))
                .addRelationshipCancer(data.get("Relationship2"),data.get("Cancer Type2"),data.get("Age Of Diagnosis2"))
                .clickButton("Submit")
                .navigateToSpecialistUrl(ConfigLoader.getConfigValue("specialistUrl"))
                .clickPatientRecord(firstName)
                .clickReviewPatient()
                .clickPatientNavigationTab("Testing")
                .validateHbocAndHccStatus("class","switch ng-valid checked","fa check-icon fa-check-circle bg-green")
                .testSelectionPanelEligibilities("Primary","HBOC")
                .testSelectionPanelEligibilities("Secondary","Lynch Syndrome")
                .selectVendors(data.get("Vendors"))
                .selecttest(data.get("Test"))
                .clickButton("Next")
                .clickButton("Next")
                .clickButton("Next")
                .clickButton("Next")
                .clickButton("Next")
                .clickButton("Print")
                .checkTestResultPanel(data.get("Test Result"))
                .enterTestResult(data.get("TestName1"),data.get("TestResultOption1"))
                .enterTestResult(data.get("TestName2"),data.get("TestResultOption2"))
                .clickButton("Save Test Results")
                .validateSavedResults(data.get("TestName1"),data.get("TestResultOption1"))
                .validateSavedResults(data.get("TestName2"),data.get("TestResultOption2"))
                .clickViewCompletedForms()
                .downloadForms(data.get("FormNames"))
                .clickToClosePopup()
                .clickButton("Update Test Results")
                .enterTestResult(data.get("TestName3"),data.get("TestResultOption3"))
                .addAdditionalVariant(data.get("TestName3"),data.get("AdditionalTestResultOption"))
                .clickButton("Save Test Results")
                .validateSavedResults(data.get("TestName3"),data.get("AdditionalTestResultOption"))
                .clickRunRiskAssessmentButton()
                .clickPrintAssessment("CIQ|Specialist");
    }

    }

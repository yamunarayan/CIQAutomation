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

public class TestingTests extends BaseTest {

    @Test(groups = {"specialist","Tempus", "updateTestResult", "regression", "validatWithTempusVendorWithMandatoryCheck"})
    public void validatWithTempusVendorWithMandatoryCheck() throws InterruptedException {

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
                .selectSampleType(data.get("Sample Type"))
                .clickButton("Next")
                .chooseICD10(data.get("ICD-10 Options"))
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

    @Test(groups = {"specialist","validatWithTempusVendorE2E","Tempus", "updateTestResult", "regression", "validatWithTempusVendorWithMandatoryCheck"})
    public void validatWithTempusVendorE2E() throws InterruptedException {

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
                .getProviderName(data.get("Ordering Provider Name"))
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
                .getTestGeneNames(data.get("Test"), data.get("TestGene"))
                .selecttest(data.get("Test"))
                .selectOrderingPhysician(data.get("Ordering Physician"))
                .selectProvideSignature()
                .clickButton("Next")
                .enterPatientMailingAddress1(data.get("Patient Mailing Address1"))
                .enterPatientMailingAddress2(data.get("Patient Mailing Address2"))
                .enterPatientCity(data.get("Patient City"))
                .enterPatientState(data.get("Patient State"))
                .enterPatientZip(data.get("Patient Zip"))
                .selectPatientRace(data.get("Patient Race"))
                .selectPatientEthnicity(data.get("Patient Ethnicity"))
                .clickButton("Next")
                .selectBillType(data.get("Bill Type"))
                .selectRelationshipToPolicyHolder(data.get("Relationship To Policy Holder"))
                .selectPrimaryInsurance(data.get("Primary Insurance"))
                .enterPolicy(data.get("Policy No"))
                .enterGroup(data.get("Group No"))
                .clickButton("Next")
                .selectSampleType(data.get("Sample Type"))
                .chooseMobilePhlebotomy(data.get("Mobile Phlebotomy"))
                .clickButton("Next")
                .chooseICD10(data.get("ICD-10 Options"))
                .clickButton("Next")
                .chooseTumorTesting(data.get("Tumor testing"))
                .chooseGermlineTesting(data.get("Germline Testing"))
                .clickButton("Next")
                .verifyCounselorSignatureText(data.get("Counselor Signature Text"))
                .clickButton("Next")
                .verifyConfirmationTestNameText(data.get("Test"))
                .verifyConfirmationGenesText(data.get("ConfirmGenes"))
                .verifyConfirmationRelationshipText(data.get("Relationship To Policy Holder"))
                .verifyConfirmationOrderingProviderName(data.get("Ordering Provider Name"))
                .verifyGeneName(data.get("ConfirmGenes"), data.get("TestGene"))
                //.verifyConfirmationNPI(data.get(""))
                .verifyConfirmationAddress1Text(data.get("Patient Mailing Address1"))
                .verifyConfirmationAddress2Text(data.get("Patient Mailing Address2"))
                .verifyConfirmationCityText(data.get("Patient City"))
                .verifyConfirmationStateText(data.get("Patient State"))
                .verifyConfirmationPostalCodeText(data.get("Patient Zip"))
                .verifyConfirmationRaceText(data.get("Patient Race"))
                .verifyConfirmationEthnicityext(data.get("Patient Ethnicity"))
                .verifyConfirmationHowTestPaidText(data.get("Bill Type"))
                .verifyConfirmationPolicyHolderText(firstName+" "+lastName)
                .verifyConfirmationPolicyHolderDOBText(data.get("DOB"))
                .verifyConfirmationRelationshipToPolicyHolderText(data.get("Relationship To Policy Holder"))
                .verifyConfirmationPrimaryInsuranceCompanyText(data.get("Primary Insurance"))
                .verifyConfirmationInsurancePolicyNumberText(data.get("Policy No"))
                .verifyConfirmationInsuranceGroupNumberText(data.get("Group No"))
                .verifyConfirmationSampleTypeText(data.get("Sample Type"))
                .verifyConfirmationMobilePhlebotomyText(data.get("Mobile Phlebotomy"))
                .verifyConfirmationPrimaryDiagnosisCodeText(data.get("ICD-10 Options"))
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

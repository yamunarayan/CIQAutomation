package org.ciq.tests.reports;

import org.ciq.pages.ReadPDF;
import org.ciq.tests.BaseTest;
import org.ciq.utils.ExcelUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class TRFTests extends BaseTest {

    ExcelUtils excelUtils = new ExcelUtils();
    Map<String, String> data;
    String path = "./src/test/resources/testdata.xlsx";
    ReadPDF readPDF;
    WebDriver driver;
    String pdfFilePath = "./src/main/resources/Patient Letter.pdf";

    @Test(groups = {"pdfValidation"})
    public void readTRFReport() throws IOException {
        data=excelUtils.getData("readReports","specialist",path);
        //driver=launchAppAndLogin("reportsurl");
        readPDF = new ReadPDF(driver);
        //readPDF.readPDFCont(pdfFilePath);
        readPDF.patientLetter(pdfFilePath);
        //readPDF.readParticularFiled(data.get("Location"));




    }
}

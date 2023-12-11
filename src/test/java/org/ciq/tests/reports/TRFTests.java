package org.ciq.tests.reports;

import org.ciq.pages.ReadPDF;
import org.ciq.tests.BaseTest;
import org.ciq.utils.ExcelUtils;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class TRFTests extends BaseTest {

    ExcelUtils excelUtils = new ExcelUtils();
    Map<String, String> data;
    String path = "./src/test/resources/testdata.xlsx";
    ReadPDF readPDF;
    WebDriver driver;

    public void readTRFReport(){
        driver=launchAppAndLogin("reportsurl");
        readPDF = new ReadPDF(driver);
      // readPDF.readPDFContent();

    }
}

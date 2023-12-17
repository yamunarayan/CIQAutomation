package org.ciq.pages;

import io.qameta.allure.Step;
import net.bytebuddy.asm.MemberSubstitution;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.ciq.utils.WebDriverMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


public class ReadPDF {

    WebDriver driver;
    WebDriverMethods webDriverMethods;

    public ReadPDF(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
        webDriverMethods = new WebDriverMethods(driver);
    }

    @Step("read reports pdf in sp ")
    public static String readPDFContent(String pdfFilePath) throws IOException {

        PDDocument document = null;
        try {
            document = PDDocument.load(new File(pdfFilePath));
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document);
        } finally {
            if (document != null) {
                document.close();
            }
        }
    }

    @Step("read reports pdf ")
    public String readPDFCont(String pdfFilePath) throws IOException {
        String pdfText ;
        PDDocument document = null;
        try {
            document = PDDocument.load(new File(pdfFilePath));
            System.out.println(document.getNumberOfPages());
            PDFTextStripper pdfStripper = new PDFTextStripper();
             pdfText= pdfStripper.getText(document);
            //System.out.println(pdfText);

        } finally {
            if (document != null) {
                document.close();
            }
        }
        return pdfText;
    }

    public ReadPDF patientLetter(String filePath) throws IOException {
        String s = readPDFCont(filePath);
        Assert.assertTrue(s.contains("YOUR RESULTS"));
        Assert.assertTrue(s.contains("YOUR RISK FACTORS"));
        Assert.assertTrue(s.contains("Breast Cancer Risk"));
        return this;
    }

    public ReadPDF generateHBOCEducation(String filePath) throws IOException {
        String s = readPDFCont(filePath);
        Assert.assertTrue(s.contains("YOUR RESULTS"));
        Assert.assertTrue(s.contains("YOUR RISK FACTORS"));
        Assert.assertTrue(s.contains("Breast Cancer Risk"));
        return this;
    }



    public ReadPDF readParticularFiled(String expectedValue){
    JavascriptExecutor js = (JavascriptExecutor) driver;
    String fieldValue = (String) js.executeScript("return PDFViewerApplication.pdfViewer._pages[0].getTextContent().items[0].str;");
        System.out.println(fieldValue);
    //Assert.assertEquals(fieldValue,expectedValue);
    return this;
}


    }


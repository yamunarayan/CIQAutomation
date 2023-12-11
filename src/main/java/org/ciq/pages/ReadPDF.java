package org.ciq.pages;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.ciq.utils.WebDriverMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import java.io.File;
import java.io.IOException;


public class ReadPDF {

    WebDriver driver;
    WebDriverMethods webDriverMethods;

    public ReadPDF(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);
        webDriverMethods = new WebDriverMethods(driver);
    }

    public String readPDFContent(String pdfFilePath) throws IOException {

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

    /*public static String readPDFContentWithFileName(String pdfFilePath) throws IOException {
        String url =driver.getCurrentUrl();
            document = PDDocument.load(new File(pdfFilePath));
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document);
        } finally {
            if (document != null) {
                document.close();
            }
        }*/
    }


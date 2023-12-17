package org.ciq.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class PdfBoxUtils {
    public static String getFieldValue(String pdfUrl, String fieldName) {
        try {
            URL url = new URL(pdfUrl);
            PDDocument document = PDDocument.load(url.openStream());

            // Use PDFTextStripper to extract text from the PDF
            PDFTextStripper stripper = new PDFTextStripper();
            String pdfText = stripper.getText(document);

            // Implement logic to extract the field value based on the field name
            // ...

            document.close();
            return pdfText; // Replace with the actual logic
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

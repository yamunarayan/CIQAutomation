package org.ciq.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExcelUtils {

    private XSSFSheet excelSheet;
    private XSSFWorkbook excelWorkbook;
    private XSSFCell cell;
    private XSSFRow row;

    public void setExcelFilePath(String path, String sheetName) throws FileNotFoundException {

        try {
            FileInputStream fileInputStream = new FileInputStream(new File(path));
            excelWorkbook = new XSSFWorkbook(fileInputStream);
            excelSheet = excelWorkbook.getSheet(sheetName);

        } catch (Exception e) {
            System.out.println("exception occurred");
        }
    }

    public int getTestCaseRow(String testName, int columnCount) {
        int row = 0;
        try {
            int lastRowNum = excelSheet.getLastRowNum();
            for (row = 0; row < lastRowNum; row++) {
                if (getCellData(row, columnCount).equals((testName))) break;
            }
        } catch (Exception e) {
            System.out.println("");
        }

        return row;
    }

    public String getCellData(int rowNumb, int colNumb) {
        cell = excelSheet.getRow(rowNumb).getCell(colNumb);
        if (cell.getCellType().equals(CellType.NUMERIC)) {
            cell.setCellType(CellType.STRING);
        }
        String stringCellValue = cell.getStringCellValue();
        return stringCellValue;
    }

    public Map<String, String> getData(String testCaseName, String testCaseSheetName, String path) {

        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        try {
            setExcelFilePath(path,testCaseSheetName);
            int testCaseRow = getTestCaseRow(testCaseName.trim(), 0);
            short columnCount = excelSheet.getRow(testCaseRow).getLastCellNum();
            for (int i=0;i<columnCount;i++){
                String cellData=null;
                 cell = excelSheet.getRow(testCaseRow).getCell(i);
                 if(cell!=null && cell.getCellType().equals(CellType.NUMERIC))
                     cell.setCellType(CellType.STRING);
                 if (cell!=null) {
                      cellData = cell.getStringCellValue();
                 }
                 map.put(excelSheet.getRow(0).getCell(i).getStringCellValue(),cellData);
            }
        } catch (Exception e) {

        }
        return map;
    }

}

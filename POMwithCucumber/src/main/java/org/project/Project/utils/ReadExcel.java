package org.project.Project.utils;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ReadExcel {
    public static String[][] readData(String fileName) throws IOException {

        XSSFWorkbook book = new XSSFWorkbook("data/" + fileName + ".xlsx");

        XSSFSheet sheet = book.getSheetAt(0);

        XSSFRow row = sheet.getRow(1);

        int rowCount = sheet.getLastRowNum();

        int colCount = row.getLastCellNum();

        //to integrate the data read from the excel push to the testcase
        String[][] data = new String[rowCount][colCount];//empty @D string array with row size and col size


        for (int i = 1; i <= rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                String stringCellValue = sheet.getRow(i).getCell(j).getStringCellValue();

                data[i - 1][j] = stringCellValue;
            }
        }
        book.close(); //mandatory step
        return data;

    }
}

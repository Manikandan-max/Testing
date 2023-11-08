package org.example.Files;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ReadExcelFile {
    public static void main(String[] args) throws IOException {
        FileInputStream readFile=new FileInputStream("sampleFile.xlsx");

        //Excel
        XSSFWorkbook workbook=new XSSFWorkbook(readFile);
        XSSFSheet sheet= workbook.getSheet("SampleSheet");
        Row row;
        Cell cell;


        Iterator<Row> rowIterator= sheet.iterator();
        while (rowIterator.hasNext()){
            row=rowIterator.next();

            Iterator<Cell>cellIterator= row.cellIterator();
            while (cellIterator.hasNext()){
                cell=cellIterator.next();

                DataFormatter formatter=new DataFormatter();
                String text= formatter.formatCellValue(cell);
                System.out.println(text);
            }
        }
    }
}

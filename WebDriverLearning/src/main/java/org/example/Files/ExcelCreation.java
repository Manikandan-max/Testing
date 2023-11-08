package org.example.Files;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ExcelCreation {
    public static void main(String[] args)  {

        //Creating Workbook
        XSSFWorkbook workbook=new XSSFWorkbook();

        //Creating Sheet
        XSSFSheet sheet=workbook.createSheet("SampleSheet");

        //Creating the Data
        Map<String,Object[]>dataSet=new TreeMap<String,Object[]>();
        dataSet.put("1",new Object[]{"Id","Name","Company"});
        dataSet.put("2",new Object[]{"1","John","TCS"});
        dataSet.put("3",new Object[]{"2","Vimal","Wipro"});
        dataSet.put("4",new Object[]{"3","Dhanush","Zoho"});
        dataSet.put("5",new Object[]{"4","Dinesh","HTC"});
        dataSet.put("6",new Object[]{"5","Sathish","HCL"});


        //Iterate Over the Data
        Set<String> set=dataSet.keySet();
        int rowNum=0;
        for (String Key:set
             ) {
            Row row= sheet.createRow(rowNum++);
            Object[] data= dataSet.get(Key);
            int cellNum=0;
            for (Object value:data
                 ) {
                Cell cell=row.createCell(cellNum++);
                if (value instanceof String){
                    cell.setCellValue((String) value);
                }else if (value instanceof Integer){
                    cell.setCellValue((Integer)value);
                }
                
            }
            //Write Down the File in HardDisk
            try {
                FileOutputStream fileOutputStream=new FileOutputStream("sampleFile.xlsx");
                workbook.write(fileOutputStream);

                fileOutputStream.close();
                System.out.println("Sample File Created Successfully");
            }catch (FileNotFoundException e){
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
    }
}

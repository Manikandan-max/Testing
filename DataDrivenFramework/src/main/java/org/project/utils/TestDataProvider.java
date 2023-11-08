package org.project.utils;

import java.util.Hashtable;

public class TestDataProvider {

//    @Test(dataProvider = "getTestData")
//    public void sampleTestOne(Hashtable<String,String> table){
//
//
//    }

    public static Object[][] getTestData(String DataFileName,String SheetName,String TestName){
        ReadExcelDataFile readData=new ReadExcelDataFile("src/test/testData/"+DataFileName+".xlsx");
        String sheetName=SheetName;
        String testName=TestName;

        /****************  Find Start Row of TestCase    **********************/
        int startRowNum=1;
        while (!readData.getCellData(sheetName,0,startRowNum).equalsIgnoreCase(testName)){
            startRowNum++;
        }
        System.out.println("Test starts from RowNumber: "+startRowNum);

        /********************** Find Number of Rows in Testcase   *********************************/
        int startTestColumn=startRowNum+1;
        int startTestRow=startRowNum+2;

        int rows=0;
        while (!readData.getCellData(sheetName,0,startTestRow+rows).equals("")){
            rows++;

        }
        System.out.println("Total number of rows : "+testName+" is: "+rows);

        /******************************  Find Number of Columns in TestCase   *************************************/

        int columns=0;
        while (!readData.getCellData(sheetName,columns,startTestColumn).equals("")){
            columns++;
        }
        System.out.println("Total Number of Columns: "+ testName+" is: "+columns);

        //Define 2D Object Array for DataProvider
        Object[][] dataSet=new Object[rows][1];
        Hashtable<String,String> dataTable=null;
        int dataRowNumber=0;
        /***************** Print All testCase Data ***************************/
        for (int rowNumber=startTestRow;rowNumber<startTestRow+rows;rowNumber++){
            dataTable=new Hashtable<String,String>();

            for (int colNumber=0;colNumber<columns;colNumber++){
                String key= readData.getCellData(sheetName,colNumber,startTestColumn);
                String value= readData.getCellData(sheetName,colNumber,rowNumber);
                dataTable.put(key,value);


//                dataSet[dataRowNumber][colNumber]=readData.getCellData(sheetName,colNumber,rowNumber);
//                System.out.println(readData.getCellData(sheetName,colNumber,rowNumber));

            }
            dataSet[dataRowNumber][0]=dataTable;
            dataRowNumber++;
        }



        return dataSet;
    }
}

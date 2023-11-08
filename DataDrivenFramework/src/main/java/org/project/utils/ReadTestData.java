package org.project.utils;

/********
 *
 * This class is for Testing the ReadData from Excel with Specific Testcase.
 *
 */


public class ReadTestData {

    public static void main(String[] args) {

        ReadExcelDataFile readData=new ReadExcelDataFile("data/TestData.xlsx");
        String sheetName="Feature1";
        String testName="TestOne";

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

        /***************** Print All testCase Data ***************************/
        for (int rowNumber=startTestRow;rowNumber<startTestRow+rows;rowNumber++){
            for (int colNumber=0;colNumber<columns;colNumber++){
                System.out.println(readData.getCellData(sheetName,colNumber,rowNumber));

            }
        }

    }
}

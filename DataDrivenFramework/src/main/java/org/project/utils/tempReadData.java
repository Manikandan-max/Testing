package org.project.utils;

public class tempReadData {
    public static void main(String[] args) {
        ReadExcelDataFile readData=new ReadExcelDataFile("data/User.xlsx");
        int rowCount = readData.getRowCount("UserDetails");
        String data = readData.getCellData("UserDetails", "Password", 4);
        System.out.println(rowCount);
        System.out.println(data);

    }
}

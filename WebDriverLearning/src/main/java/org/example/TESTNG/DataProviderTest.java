package org.example.TESTNG;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

    @Test(dataProvider = "set1")
    public void calculate(int actual,int expected){
        int actualValue=actual+20;
        Assert.assertEquals(actualValue,expected);
    }

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                {110,130},
                {200,220},
                {300,212},
                {400,420}
        };
    }
    @DataProvider(name = "set1")
    public Object[][] getDataSet1(){
        return new Object[][]{
                {10,30},
                {20,40},
                {30,50}
        };
    }
}

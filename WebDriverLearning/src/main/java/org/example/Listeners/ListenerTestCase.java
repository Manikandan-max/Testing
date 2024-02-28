package org.example.Listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ListenerTestCase extends DemoListener {

    @Test
    public void testOne(){
        System.out.println("Test One");
    }
    @Test(dataProvider = "dataProvider")
    public void testGetDate(String s){
        System.out.println("Get the value --> "+s);
    }

    @DataProvider
    public Object[] dataProvider(){
    return new Object[]{"A","B"};
    }

    @Test
    public void testThree(){
        Assert.assertEquals(5,5);
    }

    @Test
    public void testFour(){
        System.out.println("This test should be Skipped");
        throw new SkipException(null);
    }


}

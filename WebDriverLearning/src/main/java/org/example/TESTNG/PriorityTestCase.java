package org.example.TESTNG;

import org.testng.annotations.Test;

@Test
public class PriorityTestCase {
    @Test(priority = 3)
    public void testMethod1(){
        System.out.println("Method 1");
    }
    @Test(priority = 1)
    public void testMethod2(){
        System.out.println("Method 2");
    }
    @Test(priority = 2)
    public void testMethod3(){
        System.out.println("Method 3");
    }
    @Test
    public void testMethod4(){
        System.out.println("Method 4");
    }

}

package org.example.TESTNG;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class SampleTest {
    @BeforeSuite
    public void beforeTest(){
        System.out.println("Before Testing");

    }
    @AfterSuite
    public void afterTest(){
        System.out.println("After Testing");
    }
}

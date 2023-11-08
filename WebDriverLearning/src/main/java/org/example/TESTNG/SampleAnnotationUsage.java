package org.example.TESTNG;

import org.testng.annotations.*;

public class SampleAnnotationUsage {

    @BeforeTest
    public void sampleMethod1(){
        System.out.println("-----------Before Test Annotation");
    }
    @BeforeSuite
    public void sampleMethod2(){
        System.out.println("-------------Before Suite Method");
    }
    @BeforeMethod
    public void sampleMethod3(){
        System.out.println("------------Before Method");
    }
    @AfterSuite
    public void sampleMethod4(){
        System.out.println("After Suite Method------------");
    }
    @AfterTest(enabled = false)
    public void sampleMethod5(){
        System.out.println("After Test Methods--------");
    }
    @AfterMethod
    public void sampleMethod6(){
        System.out.println("After Method-----");
    }
}

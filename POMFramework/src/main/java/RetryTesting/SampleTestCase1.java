package RetryTesting;

import org.testng.annotations.Test;

public class SampleTestCase1 {

    @Test
    public void testCase1(){
        System.out.println("Testcase 1");
    }

    @Test
    public void testCase2() {
        try {
            int i = 1 / 0;
            System.out.println("TestCase 2");
        } catch (Exception e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }

}

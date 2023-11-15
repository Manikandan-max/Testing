package RetryTesting;

import org.testng.annotations.Test;

public class SampleTestCase2 {
    @Test
    public void testCase3(){
        System.out.println("TestCase3");
    }

    @Test
    public void testCase4(){
        int i=1/0;
        System.out.println("TestCase4");
    }
}

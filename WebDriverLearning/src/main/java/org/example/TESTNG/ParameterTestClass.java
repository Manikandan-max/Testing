package org.example.TESTNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTestClass {


    @Test(description = "Example for Parameter Testing")
    @Parameters("browser")
    public void browserDetails(String browerName) {
        System.out.println("Browser name is " + browerName);
    }


    @Test(description = "Example for Parameter Testing")
    @Parameters({"userName", "password"})
    public void userDetails(String userName, String password) {
        System.out.println("Username: " + userName);
        System.out.println("Password: " + password);
    }
}

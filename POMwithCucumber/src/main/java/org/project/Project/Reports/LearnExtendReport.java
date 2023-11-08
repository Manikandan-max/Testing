package org.project.Project.Reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.IOException;

public class LearnExtendReport {
    public static void main(String[] args) {


        //Set the path to create the report
        ExtentHtmlReporter reporter=new ExtentHtmlReporter("reports-out/report.html");
        reporter.setAppendExisting(true);

        //Create an object of ExtentReports to attach the data in report.html
        ExtentReports extentReports=new ExtentReports();
        extentReports.attachReporter(reporter);

        ExtentTest loginFunctionality = extentReports.createTest("Login Functionality", "Creating the Report for Login functionality with valid credentials");
        loginFunctionality.assignCategory("Regression");
        try {
            loginFunctionality.pass("Login Successfully done", MediaEntityBuilder.createScreenCaptureFromPath("screenshots/screenshot1.png").build());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        loginFunctionality.fail("Login failed");
        loginFunctionality.assignAuthor("King");

        extentReports.flush();
    }
}

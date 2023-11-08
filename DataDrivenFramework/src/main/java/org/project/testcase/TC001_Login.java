package org.project.testcase;

import org.openqa.selenium.TimeoutException;
import org.project.base.BaseUI;
import org.project.utils.TestDataProvider;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Hashtable;

public class TC001_Login extends BaseUI {


    @Test(dataProvider = "fetchData")
    public void testOne(Hashtable<String,String> datatable)  {
        logger = report.createTest("Enter UserName and Password DashBoard");
        try {
            invokeBrowser("chrome");
            openUrl("url");
            elementClick("signin_button_Xpath");
            enterText("username_Xpath", datatable.get("Col1"));
            enterText("password_Xpath", datatable.get("Col3"));
            elementClick("login_button_Xpath");
            System.out.println(driver.getCurrentUrl());
            System.out.println(driver.getTitle());
        } catch (TimeoutException e) {
            reportFail("Timeout occurred: " + e.getMessage());
            takeScreenShotOnFailure();
        } catch (Exception e) {
            reportFail("Exception occurred: " + e.getMessage());
            takeScreenShotOnFailure();
        } finally {
            tearDown();
        }

    }

    @DataProvider(name = "fetchData")
    public Object[][] getTestOneData(){
        return TestDataProvider.getTestData("TestData","Feature1","TestTwo");
    }

    @AfterTest
    public void endReport() {
        report.flush();
    }

   //  @Test
    public void testTwo() throws IOException {
         logger = report.createTest("LeafTap Login Test");
        invokeBrowser("chrome");
        openUrl("leaftap_url");
        enterText("leaftap_username_Xpath", "DemoCsr");
        enterText("leaftap_password_Xpath", "crmsfa");
        elementClick("leaftap_login_button_Xpath");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        tearDown();
    }

    //@Test(dependsOnMethods = "testTwo")
    public void testThree() {
        invokeBrowser("browserName");
        openUrl("url");
        enterText("username_xpath", "demosalesManager");
        enterText("password_xpath", "crmsfa");
        elementClick("login_button");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        tearDown();
    }
}

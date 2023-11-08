package org.project.testcase;

import org.project.base.BaseUI;
import org.project.utils.TestDataProvider;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class ZohoLoginTest extends BaseUI {

    @Test(dataProvider = "sendData")
    public void doZohoLoginTest(Hashtable<String,String> datatable){

        logger= report.createTest("Zoho Login Test Case: "+datatable.get("Comments"));
        invokeBrowser("chrome");
        openUrl("zoho_url");
        elementClick("signin_linkText");
        enterText("email_Xpath", datatable.get("Username"));
        elementClick("email_submit_Xpath");
        enterText("zoho_password_Xpath", datatable.get("Password"));
        elementClick("zoho_sigin_button_Xpath");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        verifyTitle(datatable.get("PageTitle"));

    }
    @AfterTest
    public void endReport() {
        report.flush();
    }

    @DataProvider(name = "sendData")
    public Object[][] getDatadoZohoLoginTest(){
        return TestDataProvider.getTestData("ZohoTestData","LoginTestData","doZohoLoginTest");
    }

}

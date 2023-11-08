package org.project.Project.testcase;


import org.project.Project.base.ProjectSpecification;
import org.project.Project.pages.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginFunctionalityTest extends ProjectSpecification {

    @BeforeTest
    public void setValues() {
        // filename="Leads"
        testName = "Login Functionality";
        testDesc = "Login with Positive Credentials";
        testAuthor = "Manikandan";
        testCategory = "Funtional";
    }

    @Test
    public void runLogin() throws  IOException {

        LoginPage lp = new LoginPage(driver, prop);
        lp.enterUsername().enterPassword().clickLogin().verifyWelcomePage().clickCRMSFA().clickLeads();


    }

}



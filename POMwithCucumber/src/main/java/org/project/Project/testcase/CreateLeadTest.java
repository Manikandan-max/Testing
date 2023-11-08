package org.project.Project.testcase;


import org.project.Project.base.ProjectSpecification;
import org.project.Project.pages.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateLeadTest extends ProjectSpecification {



    @BeforeTest
    public void setFileName() {
        fileName = "CreateLead";
    }

    @Test(dataProvider = "fetchData")
    public void runCreateLeadTest(String cname, String fname, String lname, String email) {

//         new LoginPage().enterUserName().enterPassword().clickLoginButton().clickCRMSFA().clickLeads()
//                .clickCreateLeads()
//                .enterCompanyName(cname)
//                .enterFirstName(fname)
//                .enterLastName(lname)
//                .enterEmail(email)
//                .clickSubmit()
//                .verifyCreateLead();

    }
}

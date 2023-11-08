package org.project.Project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.project.Project.base.ProjectSpecification;

import java.util.Properties;

public class CreateLeadsPage extends ProjectSpecification {

    public CreateLeadsPage(ChromeDriver driver, Properties prop) {
        this.driver=driver;
        this.prop=prop;
    }


    public CreateLeadsPage enterCompanyName(String cname) {
        driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
        return this;
    }

    public CreateLeadsPage enterFirstName(String fname) {
        driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
        return this;

    }

    public CreateLeadsPage enterLastName(String lname) {
        driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
        return this;
    }

    public CreateLeadsPage enterEmail(String email) {
        driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(email);
        return this;

    }
    public ViewPage clickSubmit(){
        driver.findElement(By.name("submitButton")).click();
        return new ViewPage();
    }

}

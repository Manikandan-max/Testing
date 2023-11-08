package org.project.Project.pages;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.project.Project.base.ProjectSpecification;

import java.util.Properties;

public class WelcomePage extends ProjectSpecification {


    public WelcomePage(ChromeDriver driver, Properties prop) {
        this.driver=driver;
        this.prop=prop;
    }

    public HomePage clickCRMSFA() {
        driver.findElement(By.linkText("CRM/SFA")).click();
        return new HomePage(driver,prop);
    }

    public LoginPage clickLogout() {
        return new LoginPage(driver,prop);
    }

    @Then("WelcomePage is Displayed")
    public WelcomePage verifyWelcomePage() {
        String title = driver.getTitle();
        System.out.println(title);
        System.out.println(driver.findElement(By.tagName("h2")).getText());
        //return new WelcomePage();
        return this;
    }
}





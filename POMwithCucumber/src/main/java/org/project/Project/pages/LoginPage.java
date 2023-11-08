package org.project.Project.pages;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.project.Project.base.ProjectSpecification;

import java.io.IOException;
import java.util.Properties;

public class LoginPage extends ProjectSpecification {

    public LoginPage(ChromeDriver driver, Properties prop) {
        this.driver=driver;
        this.prop=prop;
    }

    @Given("Enter the Username")
    public LoginPage enterUsername() throws IOException {

        try {
            driver.findElement(By.id("username")).sendKeys(prop.getProperty("username"));
            reportStep("pass", "Username is entered Successfully ");
        } catch (Exception e) {
            reportStep("fail", "Username is not entered Successfully " +e);
        }
        return this; //this represents the current class object/constructor
    }
    @And("Enter the Password")
    public LoginPage enterPassword() throws IOException {
        try {
            driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
            reportStep("pass", "Password is entered Successfully ");

        } catch (Exception e) {
            reportStep("fail", "Password is not entered Successfully " +e);
        }

        return this;
    }

    @When("click on the login Button")
    public WelcomePage clickLogin() throws IOException {
        try {
            driver.findElement(By.className("decorativeSubmit")).click();
            reportStep("pass", "Login button is clicked Successfully ");
        } catch (Exception e) {
            reportStep("fail", "Login button is not clicked Successfully "+e);

        }

        return 	new WelcomePage(driver,prop);
    }

}

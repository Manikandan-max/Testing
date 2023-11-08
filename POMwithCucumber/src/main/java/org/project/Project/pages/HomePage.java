package org.project.Project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.project.Project.base.ProjectSpecification;

import java.util.Properties;

public class HomePage extends ProjectSpecification {




    public HomePage(ChromeDriver driver, Properties prop) {
        this.driver=driver;
        this.prop=prop;
    }

    public LeadsPage clickLeads() {
        driver.findElement(By.linkText(prop.getProperty("MyHomePage.LinkText.Leads"))).click();
        return new LeadsPage(driver,prop);
    }
}

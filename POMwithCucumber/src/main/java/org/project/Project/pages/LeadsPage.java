package org.project.Project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.project.Project.base.ProjectSpecification;

import java.util.Properties;

public class LeadsPage extends ProjectSpecification {


    public LeadsPage(ChromeDriver driver, Properties prop) {
        this.driver=driver;
        this.prop=prop;
    }
    public CreateLeadsPage clickCreateLead() {
        return new CreateLeadsPage(driver,prop);
    }


}

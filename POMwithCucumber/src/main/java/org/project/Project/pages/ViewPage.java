package org.project.Project.pages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.project.Project.base.ProjectSpecification;

public class ViewPage extends ProjectSpecification {




    public ViewPage verifyCreateLead(){
        System.out.println(driver.getTitle());
        return this;
    }
}

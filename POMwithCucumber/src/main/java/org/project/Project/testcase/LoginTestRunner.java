package org.project.Project.testcase;

import io.cucumber.testng.CucumberOptions;
import org.project.Project.base.ProjectSpecification;

@CucumberOptions(features = {"src/main/java/org/project/Project/feature/TC001_Login.feature"},glue = "org.project.Project.pages",plugin = {"pretty","html:target/login_reports.html"})
public class LoginTestRunner extends ProjectSpecification {
}

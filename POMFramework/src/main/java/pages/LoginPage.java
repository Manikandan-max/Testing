package pages;

import base.PageBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageBaseClass {


    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public void enterUsername(){}
    public void enterPassword(){}

    public RediffMailPage clickLogin(){
        return PageFactory.initElements(driver,RediffMailPage.class);
    }
}

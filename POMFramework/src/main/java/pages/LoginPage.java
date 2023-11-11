package pages;

import base.PageBaseClass;
import base.TopMenuClass;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageBaseClass {

    public TopMenuClass topMenu;

    public ExtentTest logger;
    public LoginPage(WebDriver driver, ExtentTest logger)
    {
        super(driver,logger);
        topMenu=new TopMenuClass(driver,logger);
        PageFactory.initElements(driver,topMenu);
    }

    public void enterUsername(){}
    public void enterPassword(){}

    public TopMenuClass getTopMenu() {
        return topMenu;
    }

    public RediffMailPage clickLogin(){
        RediffMailPage rediffMailPage=new RediffMailPage(driver,logger);
        PageFactory.initElements(driver,rediffMailPage);
        return rediffMailPage;
    }
}

package pages;

import base.PageBaseClass;
import base.TopMenuClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage extends PageBaseClass {
    public TopMenuClass topMenu;
    public LogOutPage(WebDriver driver, ExtentTest logger)
    {
        super(driver,logger);
        topMenu=new TopMenuClass(driver,logger);
        PageFactory.initElements(driver, topMenu);
    }

    @FindBy(xpath = "//*[@id='wrapper']/div[4]/a")
    public WebElement loginAgainLink;

    public LoginPage loginAgain(){
        logger.log(Status.INFO,"LoginAgain Initiating..");
        loginAgainLink.click();
        logger.log(Status.PASS,"Login Again Executed");
        LoginPage loginPage=new LoginPage(driver,logger);
        PageFactory.initElements(driver,loginPage);
        return loginPage;
    }
}

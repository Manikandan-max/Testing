package base;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.LogOutPage;

public class TopMenuClass extends PageBaseClass{

    public TopMenuClass(WebDriver driver, ExtentTest logger){
        super(driver,logger);
    }

    @FindBy(xpath = "//*[@id='wrapper']/div[2]/ul/li[2]/a")
    public WebElement myportfolioLink;

    @FindBy(xpath = "//*[@id='signin_info']/a")
    public WebElement signoutLink;

    public LogOutPage signOutPortfolio(){
        logger.log(Status.INFO,"SignOut Initiating");
        signoutLink.click();
        logger.log(Status.PASS,"SignedOut Successfully");
        LogOutPage logOutPage=new LogOutPage(driver,logger);
        PageFactory.initElements(driver, logOutPage);
        return logOutPage;
    }

}

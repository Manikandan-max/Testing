package pages;

import base.PageBaseClass;
import base.TopMenuClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoneyPage extends PageBaseClass {

    public TopMenuClass topMenu;
    public MoneyPage(WebDriver driver, ExtentTest logger) {
        super(driver,logger);
        topMenu=new TopMenuClass(driver,logger);
        PageFactory.initElements(driver, topMenu);
    }

    @FindBy(xpath = "//*[@id='signin_info']/a[1]")
    public WebElement signinLink;

    public PortfolioLoginPage clickSigninLink(){
        logger.log(Status.INFO,"Signin Initiated");
        signinLink.click();
        logger.log(Status.PASS,"SignedIn Sucessfully to Portfolio Page");
        PortfolioLoginPage portfolioLoginPage=new PortfolioLoginPage(driver,logger);
        PageFactory.initElements(driver, portfolioLoginPage);
        return portfolioLoginPage;
    }

}

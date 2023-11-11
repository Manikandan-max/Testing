package pages;

import base.PageBaseClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends PageBaseClass {

    public LandingPage(WebDriver driver,ExtentTest logger)
    {

        super(driver,logger);
    }


    public LoginPage clickSignin() {

        LoginPage loginPage=new LoginPage(driver,logger);
        PageFactory.initElements(driver, loginPage);
        return loginPage;
    }

    @FindBy(linkText = "Money")
    public WebElement moneylink;

    public MoneyPage clickMoneyLink() {
        logger.log(Status.INFO,"Clicking the Money Link in Header");
        moneylink.click();
        logger.log(Status.PASS,"Clicked the Money Link");
        MoneyPage moneyPage=new MoneyPage(driver,logger);
        PageFactory.initElements(driver, moneyPage);
        return moneyPage;
    }

}

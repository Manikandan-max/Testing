package pages;

import base.PageBaseClass;
import base.TopMenuClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PortfolioLoginPage extends PageBaseClass {
    public TopMenuClass topMenu;

    public PortfolioLoginPage(WebDriver driver, ExtentTest logger) {

        super(driver,logger);
        topMenu=new TopMenuClass(driver,logger);
        PageFactory.initElements(driver, topMenu);
    }

    @FindBy(id = "useremail")
    public WebElement userName_textBox;
    @FindBy(id = "userpass")
    public WebElement password_textBox;
    @FindBy(id = "rememberflag")
    public WebElement rememberCheckbox;
    @FindBy(id = "loginsubmit")
    public WebElement loginButton;

    public MyPortfolioPage doLogin(String userName,String password){
        userName_textBox.sendKeys(userName);
        logger.log(Status.PASS,"Username Entered Successfully");
        password_textBox.sendKeys(password);
        logger.log(Status.PASS,"Password Entered Successfully");
        rememberCheckbox.click();
        loginButton.click();
        logger.log(Status.PASS,"Login Button Clicked Successfully");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String title = driver.getTitle();
        if (title.equals("Indian stock markets: mutual funds, Sensex, Nifty"))
            Assert.fail("Login Failed");
        MyPortfolioPage myPortfolioPage=new MyPortfolioPage(driver,logger);
        PageFactory.initElements(driver, myPortfolioPage);
        return myPortfolioPage;
    }

    public void enterUsername(String userName){
        userName_textBox.sendKeys(userName);
        logger.log(Status.PASS,"Entered Username: "+userName);
    }
    public void enterPassword(String password){
        password_textBox.sendKeys(password);
        logger.log(Status.PASS,"Entered Password: "+password);

    }
    public MyPortfolioPage submitLogin(){
        rememberCheckbox.click();
        logger.log(Status.INFO,"Login Initiated");
        loginButton.click();
        logger.log(Status.PASS,"LogIn Button Clicked Successfully");
        reportPass("LogIn Successful");
        MyPortfolioPage myPortfolioPage=new MyPortfolioPage(driver,logger);
        PageFactory.initElements(driver, myPortfolioPage);
        return myPortfolioPage;
    }
}

package pages;

import base.PageBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PortfolioLoginPage extends PageBaseClass {

    public PortfolioLoginPage(WebDriver driver) {
        this.driver=driver;
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
        password_textBox.sendKeys(password);
        rememberCheckbox.click();
        loginButton.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String title = driver.getTitle();
        if (title.equals("Indian stock markets: mutual funds, Sensex, Nifty"))
            Assert.fail("Login Failed");
        return PageFactory.initElements(driver, MyPortfolioPage.class);
    }
}

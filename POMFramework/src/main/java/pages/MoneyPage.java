package pages;

import base.PageBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoneyPage extends PageBaseClass {
    public MoneyPage(WebDriver driver) {
        this.driver=driver;
    }

    @FindBy(xpath = "//*[@id='signin_info']/a[1]")
    public WebElement signinLink;

    public PortfolioLoginPage clickSigninLink(){
        signinLink.click();
        return PageFactory.initElements(driver, PortfolioLoginPage.class);
    }

}

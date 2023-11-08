package pages;

import base.PageBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends PageBaseClass {
    public LandingPage(WebDriver driver) {
        this.driver=driver;
    }


    public LoginPage clickSignin() {

        return PageFactory.initElements(driver, LoginPage.class);
    }

    @FindBy(linkText = "Money")
    public WebElement moneylink;

    public MoneyPage clickMoneyLink() {
        moneylink.click();
        return PageFactory.initElements(driver, MoneyPage.class);
    }

}

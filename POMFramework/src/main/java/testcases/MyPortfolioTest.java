package testcases;

import base.PageBaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.MoneyPage;
import pages.MyPortfolioPage;
import pages.PortfolioLoginPage;

public class MyPortfolioTest {

    LandingPage landingPage;
    MoneyPage moneyPage;
    PortfolioLoginPage portfolioLoginPage;
    MyPortfolioPage myPortfolioPage;
    @Test
    public void openPortfolio(){
        PageBaseClass pageBaseClass=new PageBaseClass();
        pageBaseClass.invokeBrowser("chrome");
        landingPage=pageBaseClass.openApplication();
        moneyPage=landingPage.clickMoneyLink();
        portfolioLoginPage=moneyPage.clickSigninLink();
        myPortfolioPage=portfolioLoginPage.doLogin("anshulc55@rediffmail.com","Test@1234");
        myPortfolioPage.getTitle("Rediff Moneywiz | My Portfolio(s)");

    }
}

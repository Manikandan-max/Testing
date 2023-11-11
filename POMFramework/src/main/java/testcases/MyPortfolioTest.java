package testcases;

import base.BaseTestClass;
import base.PageBaseClass;
import base.TopMenuClass;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.MoneyPage;
import pages.MyPortfolioPage;
import pages.PortfolioLoginPage;

public class MyPortfolioTest extends BaseTestClass{

    LandingPage landingPage;
    MoneyPage moneyPage;
    PortfolioLoginPage portfolioLoginPage;
    MyPortfolioPage myPortfolioPage;
    TopMenuClass topMenu;
    @Test
    public void openPortfolio(){
        logger= report.createTest("Rediff Portfolio Login Test");

        invokeBrowser("chrome");
        PageBaseClass pageBaseClass=new PageBaseClass(driver,logger);
        PageFactory.initElements(driver,pageBaseClass);
        landingPage=pageBaseClass.openApplication();
        moneyPage=landingPage.clickMoneyLink();
        portfolioLoginPage=moneyPage.clickSigninLink();
        myPortfolioPage=portfolioLoginPage.doLogin("anshulc55@rediffmail.com","Test@1234");
        myPortfolioPage.getTitle("Rediff Moneywiz | My Portfolio(s)");
        topMenu=myPortfolioPage.getTopMenu();
        topMenu.signOutPortfolio();


    }
}

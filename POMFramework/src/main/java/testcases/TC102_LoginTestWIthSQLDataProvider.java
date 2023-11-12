package testcases;

import base.BaseTestClass;
import base.PageBaseClass;
import base.SQLDataBaseConnection;
import base.TopMenuClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.MoneyPage;
import pages.MyPortfolioPage;
import pages.PortfolioLoginPage;

import java.sql.SQLException;
import java.util.Hashtable;

public class TC102_LoginTestWIthSQLDataProvider extends BaseTestClass {
    LandingPage landingPage;
    MoneyPage moneyPage;
    PortfolioLoginPage portfolioLoginPage;
    MyPortfolioPage myPortfolioPage;
    TopMenuClass topMenu;
    @Test(dataProvider = "loginData")
    public void doPortfolioTest(Hashtable<String,String> dataTable){
        String username = dataTable.get("username");
        String password = dataTable.get("password");
        String comments = dataTable.get("comments");
        String pageTitle = dataTable.get("pageTitle");
        logger= report.createTest("Rediff Portfolio Login Test With Data Provider: "+ comments);
        invokeBrowser("chrome");
        PageBaseClass pageBaseClass=new PageBaseClass(driver,logger);
        PageFactory.initElements(driver,pageBaseClass);
        landingPage=pageBaseClass.openApplication();
        waitForPageLoad();
        moneyPage=landingPage.clickMoneyLink();
        portfolioLoginPage=moneyPage.clickSigninLink();
        myPortfolioPage=portfolioLoginPage.doLogin(username,password);
        myPortfolioPage.getTitle(pageTitle);
        topMenu=myPortfolioPage.getTopMenu();
        topMenu.signOutPortfolio();

    }
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        try {
            return SQLDataBaseConnection.getLoginTestDataFromDatabase();
        } catch (SQLException e) {
            e.printStackTrace();
            return new Object[0][0];
        }
    }
    @AfterMethod
    public void flushReport(){
        report.flush();
    }
}

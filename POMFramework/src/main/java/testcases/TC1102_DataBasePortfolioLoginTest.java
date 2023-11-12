package testcases;

import base.BaseTestClass;
import base.PageBaseClass;
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
import java.util.List;

public class TC1102_DataBasePortfolioLoginTest extends BaseTestClass {
    LandingPage landingPage;
    MoneyPage moneyPage;
    PortfolioLoginPage portfolioLoginPage;
    MyPortfolioPage myPortfolioPage;
    TopMenuClass topMenu;

    @Test(dataProvider = "loginData")
    public void doPortfolioTest(Hashtable<String, String> dataTable) {
        logger = report.createTest("Rediff Portfolio Login Test With SQL Data Provider: " + dataTable.get("comments"));
        invokeBrowser("chrome");
        PageBaseClass pageBaseClass = new PageBaseClass(driver, logger);
        PageFactory.initElements(driver, pageBaseClass);
        landingPage = pageBaseClass.openApplication();
        moneyPage = landingPage.clickMoneyLink();
        waitForPageLoad();
        portfolioLoginPage = moneyPage.clickSigninLink();
        myPortfolioPage = portfolioLoginPage.doLogin(dataTable.get("username"), dataTable.get("password"));
        myPortfolioPage.getTitle(dataTable.get("pageTitle"));
        topMenu = myPortfolioPage.getTopMenu();
        topMenu.signOutPortfolio();
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        setDatabaseName("logintest");
        setTableName("login_data");

        List<Hashtable<String, String>> tableData = getTableData();
        Object[][] dataArray = new Object[tableData.size()][1];

        for (int i = 0; i < tableData.size(); i++) {
            dataArray[i][0] = tableData.get(i);
        }

        return dataArray;
    }

}


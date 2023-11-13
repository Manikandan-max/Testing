package testcases;

import base.BaseTestClass;
import base.PageBaseClass;
import base.TopMenuClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LandingPage;
import pages.MoneyPage;
import pages.MyPortfolioPage;
import pages.PortfolioLoginPage;
import utils.ConstantUtils;
import utils.TestDataProvider;

import java.util.Hashtable;

public class MyStockTest extends BaseTestClass {
    LandingPage landingPage;
    MoneyPage moneyPage;
    PortfolioLoginPage portfolioLoginPage;
    MyPortfolioPage myPortfolioPage;
    TopMenuClass topMenu;


    @Test(dataProvider = "sendData")
    public void AddStockTest(Hashtable<String,String>testData){
        logger=report.createTest("Add Stock In"+testData.get("PortfolioName")+" - Stock Name : "+ testData.get("StockName"));
        invokeBrowser("chrome");
        PageBaseClass pageBaseClass=new PageBaseClass(driver,logger);
        PageFactory.initElements(driver,pageBaseClass);
        landingPage=pageBaseClass.openApplication();
        moneyPage=landingPage.clickMoneyLink();
        portfolioLoginPage=moneyPage.clickSigninLink();
        myPortfolioPage=portfolioLoginPage.doLogin(ConstantUtils.USERONE.getUsername(), ConstantUtils.USERONE.getPassword());
        waitForPageLoad();
        myPortfolioPage.verifyMoneyBiz();
        myPortfolioPage.clickCreatePortfolio();
        waitForPageLoad();
        myPortfolioPage.enterPortfolioName(testData.get("PortfolioName"));
        myPortfolioPage=myPortfolioPage.submitCreatePortfolio();
        waitForPageLoad();
        myPortfolioPage.verifyPortfolioList(testData.get("PortfolioName"));
        waitForPageLoad();
        myPortfolioPage.clickAddStockBtn();
        myPortfolioPage.enterStockName(testData.get("StockName"));
        myPortfolioPage.stockPurchaseCalender();
        selectDateIncalendar("11/02/2022");
        myPortfolioPage.addStockQty(testData.get("StockQty"));
        myPortfolioPage.addStockPrice(testData.get("StockPrice"));
        myPortfolioPage=myPortfolioPage.submitStock();
        waitForPageLoad();
        myPortfolioPage.verifyStock(testData.get("StockName"));


    }
    @DataProvider(name = "sendData")
    public Object[][] getDatadoPortfolioTest(){
        return TestDataProvider.getTestData("RediffTestData","StockTestData","AddStockTest");
    }

}

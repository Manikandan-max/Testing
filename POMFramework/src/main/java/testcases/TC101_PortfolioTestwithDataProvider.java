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

public class TC101_PortfolioTestwithDataProvider extends BaseTestClass {
    LandingPage landingPage;
    MoneyPage moneyPage;
    PortfolioLoginPage portfolioLoginPage;
    MyPortfolioPage myPortfolioPage;
    TopMenuClass topMenu;

    @Test(dataProvider = "sendData",groups = {"Regression","LoginTest"})
    public void doPortfolioTest(Hashtable<String,String> dataTable){
        logger= report.createTest("Rediff Portfolio Login Test With Data Provider: "+ dataTable.get("Comments"));
        invokeBrowser("chrome");
        PageBaseClass pageBaseClass=new PageBaseClass(driver,logger);
        PageFactory.initElements(driver,pageBaseClass);
        landingPage=pageBaseClass.openApplication();
        moneyPage=landingPage.clickMoneyLink();
        portfolioLoginPage=moneyPage.clickSigninLink();
        myPortfolioPage=portfolioLoginPage.doLogin(dataTable.get("Username"),dataTable.get("Password"));
        myPortfolioPage.getTitle(dataTable.get("PageTitle"));
        topMenu=myPortfolioPage.getTopMenu();
        topMenu.signOutPortfolio();

    }
    @Test(dataProvider = "VerifyData",groups = {"Regression","LoginTest"})
    public void verifyLogin(Hashtable<String,String> testData){
        logger= report.createTest("Portfolio Login Test With Data Provider: "+ testData.get("Comments"));
        invokeBrowser("chrome");
        PageBaseClass pageBaseClass=new PageBaseClass(driver,logger);
        PageFactory.initElements(driver,pageBaseClass);
        landingPage=pageBaseClass.openApplication();
        moneyPage=landingPage.clickMoneyLink();
        portfolioLoginPage=moneyPage.clickSigninLink();
        portfolioLoginPage.enterUsername(testData.get("Username"));
        portfolioLoginPage.enterPassword(testData.get("Password"));

    }

    @Test(dataProvider = "portfolioData",groups = {"Regression","DeletePortfolio"})
    public void deletePortfolio(Hashtable<String,String>testData){
        logger= report.createTest(" Delete Portfolio  Test : "+ testData.get("Comments"));
        invokeBrowser("chrome");
        PageBaseClass pageBaseClass=new PageBaseClass(driver,logger);
        PageFactory.initElements(driver,pageBaseClass);
        landingPage=pageBaseClass.openApplication();
        moneyPage=landingPage.clickMoneyLink();
        portfolioLoginPage=moneyPage.clickSigninLink();
        myPortfolioPage=portfolioLoginPage.doLogin(ConstantUtils.USERONE.getUsername(), ConstantUtils.USERONE.getPassword());
        waitForPageLoad();
        myPortfolioPage.verifyMoneyBiz();
        myPortfolioPage=myPortfolioPage.selectPortfolio(testData.get("PortfolioName"));
        myPortfolioPage=myPortfolioPage.deletePortfolio();
        waitForPageLoad();
        myPortfolioPage.isPortfolioDeleted(testData.get("PortfolioName"));

    }

    @Test(dataProvider = "portfolioData",groups = {"Regression","AddPortfolio"})
    public void createPortfolioTest(Hashtable<String,String> testData){
        logger= report.createTest("Rediff Portfolio  Test : "+ testData.get("Comments"));
        invokeBrowser("chrome");
        PageBaseClass pageBaseClass=new PageBaseClass(driver,logger);
        PageFactory.initElements(driver,pageBaseClass);
        landingPage=pageBaseClass.openApplication();
        moneyPage=landingPage.clickMoneyLink();
        portfolioLoginPage=moneyPage.clickSigninLink();
        myPortfolioPage=portfolioLoginPage.doLogin(ConstantUtils.USERONE.getUsername(), ConstantUtils.USERONE.getPassword());
        myPortfolioPage.verifyMoneyBiz();
        myPortfolioPage.clickCreatePortfolio();
        waitForPageLoad();
        myPortfolioPage.enterPortfolioName(testData.get("PortfolioName"));
        myPortfolioPage=myPortfolioPage.submitCreatePortfolio();
        waitForPageLoad();
        myPortfolioPage.verifyPortfolioList(testData.get("PortfolioName"));
    }
    @DataProvider(name = "sendData")
    public Object[][] getDatadoPortfolioTest(){
        return TestDataProvider.getTestData("RediffTestData","RediffLoginTest","Portfolio_Credentials");
    }
    @DataProvider(name = "VerifyData")
    public Object[][] getDatadoVerifyLoginTest(){
        return TestDataProvider.getTestData("RediffTestData","RediffLoginTest","Verify_Login");
    }
    @DataProvider(name = "portfolioData")
    public Object[][] getDatadoPortfolioNameTest(){
        return TestDataProvider.getTestData("RediffTestData","RediffLoginTest","Add_Portfolio");
    }
}

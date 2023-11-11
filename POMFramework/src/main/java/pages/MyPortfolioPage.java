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

import java.util.List;

public class MyPortfolioPage extends PageBaseClass {

    public TopMenuClass topMenu;

    public MyPortfolioPage(WebDriver driver, ExtentTest logger) {
        super(driver, logger);
        topMenu = new TopMenuClass(driver, logger);
        PageFactory.initElements(driver, topMenu);
    }

    /******************* Creating the New Portfolio  **********************/
    @FindBy(xpath = "//a[@id='createPortfolio']")
    public WebElement createPortfolioBtn;

    @FindBy(id = "createPortfolioButton")
    public WebElement submitCreatePortfolioBtn;

    public void clickCreatePortfolio() {
        try {
            createPortfolioBtn.click();
            logger.log(Status.PASS, "Clicked Create Portfolio Button");
        } catch (Exception e) {
            reportFail(e.getMessage());
        }
    }

    /******************* Entering the Portfolio Name ***************************/
    @FindBy(id = "create")
    public WebElement createPortfolio_textBox;

    public void enterPortfolioName(String portfolioName) {
        try {
            createPortfolio_textBox.clear();
            createPortfolio_textBox.sendKeys(portfolioName);
            logger.log(Status.PASS, "Entered Portfolio Name: " + portfolioName);

        } catch (Exception e) {
            reportFail(e.getMessage());

        }

    }

    /******************* Submit the Portfolio Creation *****************************/
    public MyPortfolioPage submitCreatePortfolio() {
        try {
            submitCreatePortfolioBtn.click();
            logger.log(Status.PASS, "Portfolio Created...");
        } catch (Exception e) {
            reportFail(e.getMessage());
        }
        MyPortfolioPage myPortfolioPage=new MyPortfolioPage(driver,logger);
        PageFactory.initElements(driver,myPortfolioPage);
        return myPortfolioPage;
    }


    /****************** Check the Header of MyPortfolio Page  ************************/
    @FindBy(xpath = "//*[@id='headcontent']/div[1]/div[1]/a/span")
    public WebElement moneywiz;

    public void verifyMoneyBiz() {

        moneywiz.isDisplayed();
    }

    /*************** Selecting the Created Portfolio *******************/
    @FindBy(id = "portfolioid")
    public WebElement myPortfolioList;

    public void verifyPortfolioList(String portfolio) {
        boolean flag = false;
        try {
            List<WebElement> alloptions = getAllElementsDropdown(myPortfolioList);
            for (WebElement element : alloptions) {
                if (element.getText().equalsIgnoreCase(portfolio)) {
                    flag = true;
                } else
                    flag = false;
            }
            Assert.assertTrue(flag);
            logger.log(Status.PASS,"Given Portfolio: "+portfolio+" is Present");
        } catch (Exception e) {
            reportFail(e.getMessage());
        }
    }

    public TopMenuClass getTopMenu() {
        return topMenu;
    }
}

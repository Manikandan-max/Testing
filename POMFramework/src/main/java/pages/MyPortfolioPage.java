package pages;

import base.PageBaseClass;
import base.TopMenuClass;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.an.E;
import org.openqa.selenium.By;
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
    @FindBy(xpath = "//a[@id='createPortfolio']")
    public WebElement createPortfolioBtn;

    @FindBy(id = "createPortfolioButton")
    public WebElement submitCreatePortfolioBtn;
    @FindBy(id = "create")
    public WebElement createPortfolio_textBox;
    @FindBy(xpath = "//*[@id='headcontent']/div[1]/div[1]/a/span")
    public WebElement moneywiz;
    @FindBy(id = "portfolioid")
    public WebElement myPortfolioList;
    @FindBy(id = "deletePortfolio")
    public WebElement deletePortfolioBtn;

    @FindBy(id = "addStock")
    public WebElement addStockBtn;

    @FindBy(id = "addstockname")
    public WebElement stockName_textBox;
    @FindBy(xpath = "//*[@id='ajax_listOfOptions']/div[1]")
    public WebElement stockValue;

    @FindBy(id = "stockPurchaseDate")
    public WebElement stockPurchaseDate;
    @FindBy(id = "addstockqty")
    public WebElement addStockQty_textBox;

    @FindBy(id = "addstockprice")
    public WebElement addStockPrice_TextBox;

    @FindBy(id = "addStockButton")
    public WebElement submitStockBtn;

    @FindBy(id = "stock")
    public WebElement stockTable;

    public void stockPurchaseCalender(){
        stockPurchaseDate.click();
    }
    public MyPortfolioPage submitStock(){
        try {
            submitStockBtn.click();
            logger.log(Status.PASS,"Submitted the Stock");
        }catch (Exception e){
            reportFail(e.getMessage());
        }
        MyPortfolioPage myPortfolioPage=new MyPortfolioPage(driver,logger);
        PageFactory.initElements(driver,myPortfolioPage);
        return myPortfolioPage;

    }
    public void addStockPrice(String stockPrice){
        try {
            addStockPrice_TextBox.sendKeys(stockPrice);
            logger.log(Status.PASS,"Stock Price Added: "+stockPrice);
        }catch (Exception e){
            reportFail(e.getMessage());
        }
    }
    public void verifyStock(String stockName) {
        boolean flag = false;
        try {
            List<WebElement> tableRows = stockTable.findElements(By.xpath("/tbody/tr"));

            for (WebElement row : tableRows) {
                List<WebElement> tableColumns = row.findElements(By.tagName("td"));

                for (WebElement column : tableColumns) {
                    if (column.getText().contains(stockName)) {
                        flag = true;
                        break; // Exit the inner loop if the stock is found
                    }
                }

                if (flag) {
                    break; // Exit the outer loop if the stock is found
                }
            }

            Assert.assertTrue(flag, "Given Stock : " + stockName + " is not present in this Portfolio");
            logger.log(Status.PASS, "Given Stock : " + stockName + " is present in this Portfolio");
        } catch (Exception e) {
            reportFail(e.getMessage());
        }
    }


    public void addStockQty(String stockQty){
        try {
            addStockQty_textBox.sendKeys(stockQty);
            logger.log(Status.PASS,"Stock Quantity Added: "+stockQty);
        }catch (Exception e){
            reportFail(e.getMessage());
        }
    }

    public void enterStockName(String stockName){
        try {
            stockName_textBox.sendKeys(stockName);
            stockValue.click();
            logger.log(Status.PASS,"Stock Name: "+stockName+" Entered");
        }catch (Exception e){
            reportFail(e.getMessage());
        }

    }

    public void clickAddStockBtn(){
        try {
            addStockBtn.click();
            logger.log(Status.PASS,"Clicked the Add Stock Button");
        }catch (Exception e){
            reportFail(e.getMessage());
        }
    }
    /******************* Creating the New Portfolio  **********************/


    public void clickCreatePortfolio() {
        try {
            createPortfolioBtn.click();
            logger.log(Status.PASS, "Clicked Create Portfolio Button");
        } catch (Exception e) {
            reportFail(e.getMessage());
        }
    }

    /******************* Entering the Portfolio Name ***************************/


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


    public void verifyMoneyBiz() {

        moneywiz.isDisplayed();
    }

    /*************** Selecting the Created Portfolio *******************/


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
    /************  Delete Portfolio  *******************/
    public MyPortfolioPage deletePortfolio(){
        try {
            deletePortfolioBtn.click();
            acceptAlert();
            logger.log(Status.PASS,"Deleted the Portfolio..");
        }catch (Exception e){
            reportFail(e.getMessage());
        }
        MyPortfolioPage myPortfolioPage=new MyPortfolioPage(driver,logger);
        PageFactory.initElements(driver,myPortfolioPage);
        return myPortfolioPage;
    }
    public MyPortfolioPage selectPortfolio(String value){
        selectDropdownMenu(myPortfolioList,value);
        MyPortfolioPage myPortfolioPage=new MyPortfolioPage(driver,logger);
        PageFactory.initElements(driver,myPortfolioPage);
        return myPortfolioPage;
    }
    public void isPortfolioDeleted(String portfolio) {
        boolean flag = false;
        try {
            List<WebElement> alloptions = getAllElementsDropdown(myPortfolioList);
            for (WebElement element : alloptions) {
                if (!element.getText().equalsIgnoreCase(portfolio)) {
                    flag = true;
                } else
                    flag = false;
            }
            Assert.assertTrue(flag);
            logger.log(Status.PASS,"Given Portfolio: "+portfolio+" is not Present");
        } catch (Exception e) {
            reportFail(e.getMessage());
        }
    }


    public TopMenuClass getTopMenu() {
        return topMenu;
    }
}

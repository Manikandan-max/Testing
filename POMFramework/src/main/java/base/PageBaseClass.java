package base;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pages.LandingPage;
import utils.DateUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PageBaseClass extends BaseTestClass {

    public ExtentTest logger;

    public PageBaseClass(WebDriver driver,ExtentTest logger) {
        this.driver=driver;
        this.logger=logger;
    }
    /***************   Open the Application*******************/
    public LandingPage openApplication() {
        logger.log(Status.INFO, "Opening the Application");
        driver.get("https://www.rediff.com/");
        logger.log(Status.PASS, "Successfully Opened the URL");
        LandingPage landingPage=new LandingPage(driver,logger);
        PageFactory.initElements(driver, landingPage);
        return landingPage;
    }
    /**************  Get the Application Title    **********************/
    public void getTitle(String expectedTitle) {
        try {
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, expectedTitle);
            reportPass("Actual Title: " + actualTitle + " - equals to Expected Title: " + expectedTitle);
        } catch (Exception e) {
            reportFail(e.getMessage());
        }

    }

    /*************     Reporting Function   *******************/

    public void reportFail(String reportString) {
        logger.log(Status.FAIL, reportString);
        takeScreenShotOnFailure();
        Assert.fail(reportString);
    }

    public void reportPass(String reportString) {
        logger.log(Status.PASS, reportString);
    }

    /***************** Capture the Screenshot ************************/

    public void takeScreenShotOnFailure() {
        TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
        File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);

        File destFile = new File(System.getProperty("user.dir") + "/Screenshots/" + DateUtils.getTimeStamp() + ".png");
        try {
            FileUtils.copyFile(sourceFile, destFile);
            logger.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + "/Screenshots/" + DateUtils.getTimeStamp() + ".png");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /************* Verify Element is Displayed *******************/
    public void verifyElementIsDisplayed(WebElement element){
        try {
            if (element.isDisplayed()){
                reportPass(element+ " WebElement is Displayed..");
            }
            else {
                reportFail("WebElement is not Appeared...");
            }
        }catch (Exception e){
            reportFail(e.getMessage());

        }
    }
    /***************** Get All Elements of DropDown************************/
    public List<WebElement> getAllElementsDropdown(WebElement element){
        try {
            Select select=new Select(element);
            List<WebElement> allElements = select.getOptions();
            return allElements;
        }catch (Exception e){
            reportFail(e.getMessage());

        }
        return null;
    }
}

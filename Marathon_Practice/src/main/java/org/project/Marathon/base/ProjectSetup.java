package org.project.Marathon.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.project.Marathon.pages.LandingPage;
import org.project.Marathon.utils.DateUtils;
import org.project.Marathon.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class ProjectSetup {

    public WebDriver driver;
    public Properties prop;
    public ExtentTest logger;
    public SoftAssert softAssert;
    public ExtentReports report = ExtentReportManager.getReportInstance();

    /***************** Open the Browser ****************************/

    public void openBrowser(String browserName){

        if (browserName.equalsIgnoreCase("chrome")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver=new ChromeDriver(options);

        } else if (browserName.equalsIgnoreCase("edge")) {
            EdgeOptions options=new EdgeOptions();
            options.setCapability("dom.webnotifications.enabled",false);
            driver=new EdgeDriver(options);

        } else if (browserName.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.addPreference("dom.webnotifications.enabled", false);
            driver=new FirefoxDriver();

        }else {
            driver=new SafariDriver();
        }
    }


    /*************************** Open the Url  ************************************/

    public void loadUrl(String urlKey){
        try {
            driver.get(prop.getProperty(urlKey));
            reportPass(urlKey + " : Identified Successfully..");
        } catch (Exception e) {
            reportFail(e.getMessage());
        }

    }

    /******************************** Close the Browser       ***********************************************/

    public void tearDown(){
        driver.close();
    }

    /*************************** Quit Browser ******************************/

    public void quitBrowser(){
        driver.quit();
    }

    /******************  Enter the Text in Data Field  ****************************/

    public void enterText(String elementKey,String data){
        try {
            getElement(elementKey).sendKeys(data);
            reportPass(data + " : Entered Successfully in Locator Element :" + elementKey);
        } catch (Exception e) {
            reportFail(e.getMessage());
        }
    }
    /*******************Click Operation**********************/
    public void elementClick(String xpathKey) {
        try {
            getElement(xpathKey).click();
            reportPass(xpathKey + " : Element Clicked Successfully");
        } catch (Exception e) {
            reportFail(e.getMessage());
        }
    }
    public LandingPage openApplication() {
        logger.log(Status.INFO, "Opening the Application");
        driver.get("https://www.justickets.in/");
        logger.log(Status.PASS, "Successfully Opened the URL");
        return new LandingPage(driver);
    }

    /******************** Verify Title  ******************************/
    public void verifyTitle(String expectedTitle){
        try {
            String actualTitle=driver.getTitle();
            reportPass("Actual title : "+actualTitle+"  equals to expectedTitle: "+expectedTitle);
        }catch (Exception e){
            reportFail(e.getMessage());
            Assert.fail("Failed to Perform");
        }


    }

    /************* Getting the Element  *********************/
    public WebElement getElement(String locatorKey) {
        WebElement element = null;
        try {


            if (locatorKey.endsWith("_Id")) {
                element = driver.findElement(By.id(prop.getProperty(locatorKey)));
                logger.log(Status.INFO, "Locator Identified: " + locatorKey);

            } else if (locatorKey.endsWith("_Xpath")) {
                element = driver.findElement(By.xpath(prop.getProperty(locatorKey)));
                logger.log(Status.INFO, "Locator Identified: " + locatorKey);
            } else if (locatorKey.endsWith("_CSS")) {
                element = driver.findElement(By.cssSelector(prop.getProperty(locatorKey)));
                logger.log(Status.INFO, "Locator Identified: " + locatorKey);

            } else if (locatorKey.endsWith("_Class")) {
                element = driver.findElement(By.className(prop.getProperty(locatorKey)));
                logger.log(Status.INFO, "Locator Identified: " + locatorKey);

            } else if (locatorKey.endsWith("_linkText")) {
                element = driver.findElement(By.linkText(prop.getProperty(locatorKey)));
                logger.log(Status.INFO, "Locator Identified: " + locatorKey);

            } else if (locatorKey.endsWith("_partialLinkText")) {
                element = driver.findElement(By.partialLinkText(prop.getProperty(locatorKey)));
                logger.log(Status.INFO, "Locator Identified: " + locatorKey);
            } else if (locatorKey.endsWith("_Name")) {
                element = driver.findElement(By.name(prop.getProperty(locatorKey)));
                logger.log(Status.INFO, "Locator Identified: " + locatorKey);

            } else {
                reportFail("Failing the Testcase, Invalid Property Key: " + locatorKey);
                Assert.fail("Failing the Testcase, Invalid Property Key: " + locatorKey);
            }
        } catch (Exception e) {
            // Report the Failure Occured
            reportFail(e.getMessage());
            e.printStackTrace();

            Assert.fail("Failing the Testcases: " + e.getMessage());
        }
        return element;

    }

    /************************* Verify Element ****************************/
    public boolean isElementPresent(String locatorKey) {
        try {
            if (getElement(locatorKey).isDisplayed()) {
                reportPass(locatorKey + "Element is Displayed");
                return true;
            }
        } catch (Exception e) {
            reportFail(e.getMessage());
        }
        return false;
    }

    public boolean isElementSelected(String locatorKey) {
        try {
            if (getElement(locatorKey).isSelected()) {
                reportPass(locatorKey + "Element is Selected");
                return true;
            }
        } catch (Exception e) {
            reportFail(e.getMessage());
        }
        return false;
    }

    public boolean isElementEnabled(String locatorKey) {
        try {
            if (getElement(locatorKey).isEnabled()) {
                reportPass(locatorKey + "Element is Enabled");
                return true;
            }
        } catch (Exception e) {
            reportFail(e.getMessage());
        }
        return false;
    }

    @AfterMethod
    public void afterTest() {
        softAssert.assertAll();
    }

    /************************ Assertion Function ********************************/
    public void assertTrue(boolean flag) {
        softAssert.assertTrue(flag);
    }

    public void assertfalse(boolean flag) {
        softAssert.assertFalse(flag);
    }

    public void assertequal(String actual, String expected) {
        softAssert.assertEquals(actual, expected);
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

    public void takeScreenShotOnFailure(){
        TakesScreenshot screenshot= (TakesScreenshot) driver;
        File sourceFile=screenshot.getScreenshotAs(OutputType.FILE);
        File destnFile=new File(System.getProperty("user.dir")+"/Screenshots/"+ DateUtils.getTimeStamp()+".png");

        try {
            FileUtils.copyFile(sourceFile,destnFile);
            logger.addScreenCaptureFromPath(System.getProperty("user.dir")+"/Screenshots/"+ DateUtils.getTimeStamp()+".png");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}

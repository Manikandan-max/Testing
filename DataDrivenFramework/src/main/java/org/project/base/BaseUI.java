package org.project.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.project.utils.DateUtils;
import org.project.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseUI {

    public WebDriver driver;
    public Properties prop;
    public ExtentReports report = ExtentReportManager.getReportInstance();
    public ExtentTest logger;
    SoftAssert softAssert = new SoftAssert();

    /******************Invoke the Browser***********************/
    public void invokeBrowser(String browserName) {
        try {


            if (browserName.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();

            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();

            } else {
                driver = new SafariDriver();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        } catch (Exception e) {
            reportFail(e.getMessage());
        }
        if (prop == null) {
            prop = new Properties();
            FileInputStream readFile = null;
            try {
                readFile = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/ObjectRepository/project-config.properties");
                prop.load(readFile);
            } catch (IOException e) {
                reportFail(e.getMessage());
                throw new RuntimeException(e);
            }

        }
        driver.manage().window().maximize();


    }

    /******************Open the URL*********************/
    public void openUrl(String urlKey) {

        try {
            driver.get(prop.getProperty(urlKey));
            reportPass(urlKey + " : Identified Successfully..");
        } catch (Exception e) {
            reportFail(e.getMessage());
        }


    }

    /**********************Close The Browser****************************/
    public void tearDown() {
        driver.close();

    }

    /*******************************Quit the Browser*************************************/
    public void quitBrowser() {
        driver.quit();
    }

    /********************Enter the data in Text Field*************************/
    public void enterText(String elementKey, String data) {

        try {
            getElement(elementKey).sendKeys(data);
            reportPass(data + " : Entered Successfully in Locator Element :" + elementKey);
        } catch (Exception e) {
            reportFail(e.getMessage());
        }

        //driver.findElement(By.xpath(prop.getProperty(elementKey))).sendKeys(data);

    }

    /*******************Click Operation**********************/
    public void elementClick(String xpathKey) {
        try {
            getElement(xpathKey).click();
            reportPass(xpathKey + " : Element Clicked Successfully");
        } catch (Exception e) {
            reportFail(e.getMessage());
        }


//        driver.findElement(By.xpath(prop.getProperty(xpathKey))).click();

    }

    /****************************Centralize Function to get the Locators***********************************/
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
    /**************** Verify Title of the Page ***********************/
    public void verifyTitle(String pageTitle){
        System.out.println(driver.getTitle());

        try {
            String actualTitle= driver.getTitle();
            logger.log(Status.INFO,"Actual Title is: "+actualTitle);
            logger.log(Status.INFO,"Expected Title is: "+pageTitle);
            Assert.assertEquals(actualTitle,pageTitle);
        }catch (Exception e){
            reportFail(e.getMessage());
        }

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

    public void takeScreenShotOnFailure() {
        TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
        File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);

        File destFile = new File(System.getProperty("user.dir") + "/screenshots/" + DateUtils.getTimeStamp() + ".png");
        try {
            FileUtils.copyFile(sourceFile, destFile);
            logger.addScreenCaptureFromPath(
                    System.getProperty("user.dir") + "/screenshots/" + DateUtils.getTimeStamp() + ".png");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
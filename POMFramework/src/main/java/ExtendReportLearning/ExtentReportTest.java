package ExtendReportLearning;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

public class ExtentReportTest {

    ExtentReports report = new ExtentReports();
    ExtentHtmlReporter htmlReporter;

    ExtentTest test;
    WebDriver driver;

    @BeforeTest
    public void startTest() {

        htmlReporter = new ExtentHtmlReporter("test-output/extent-reports.html");
        report.attachReporter(htmlReporter);
        report.setSystemInfo("Machine", "Jarvis");
        report.setSystemInfo("OS", "Windows11");
        report.setSystemInfo("browser", "chrome");

    }

    @AfterTest
    public void endTest() {

        report.flush();
    }
    @BeforeMethod
    public void openApplication(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.facebook.com");
    }
    @Test
    public void verifyTitleTest(){
        test= report.createTest("VerifyTest");
        String expectedTitle="Facebook – log in or sign up";
        String pageTitle= driver.getTitle();
        Assert.assertEquals(pageTitle,expectedTitle);
    }

    @Test
    public void verifyCreateAccount(){
        driver.findElement(By.xpath("//a[@id='u_0_0_7r']")).click();
        driver.findElement(By.id("u_7_b_t2")).sendKeys("King");
        driver.findElement(By.id("u_7_d_Gr")).sendKeys("Maker");
        driver.findElement(By.id("u_7_g_zW")).sendKeys("9847341232");
        driver.findElement(By.id("u_7_s_OZ")).click();
        String expectedTitle="Facebook Home";
        String pageTitle= driver.getTitle();
        Assert.assertEquals(pageTitle,expectedTitle);
    }

    @Test
    public void passTest() {
        test = report.createTest("Pass Test");
        System.out.println("Passed Test");
        Assert.assertTrue(true);
        test.log(Status.PASS, "Tested Passed");
    }

    @Test
    public void failTest() {
        test = report.createTest("Fail Test..");
        System.out.println("Failed Test");
        Assert.assertTrue(false);
        test.log(Status.FAIL, "Test Failed");
    }

    @Test
    public void skipTest(){
        test = report.createTest("Skip Test");
        System.out.println("Skip Test");
        throw new SkipException("Skipped Forcefully");
    }

    @AfterMethod
    public void setTestMethod(ITestResult result) throws IOException {
        String screenshot=CaptureScreenhot.captureScreen(driver,CaptureScreenhot.generateFilename(result));
        System.out.println("Test Name: " + result.getName());
        System.out.println("Test Status: " + result.getStatus());

        if (result.getThrowable() != null) {
            System.out.println("Throwable Details: " + result.getThrowable());
        }

        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Failed: " + result.getName());
            test.log(Status.FAIL, "Failure Details: " + result.getThrowable());
            test.fail("ScreenShot: "+test.addScreenCaptureFromPath(screenshot));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test Passed: " + result.getName());
            test.pass("ScreenShot: "+test.addScreenCaptureFromPath(screenshot));
        } else if (result.getStatus() == ITestResult.SKIP) {
            if (result.getThrowable() != null && result.getThrowable() instanceof SkipException) {
                test.log(Status.SKIP, "Test Skipped: " + result.getName());
            } else {
                test.log(Status.FAIL, "Test Skipped (due to exception): " + result.getName());
                test.log(Status.FAIL, "Failure Details: " + result.getThrowable());
            }
        }
    }


}

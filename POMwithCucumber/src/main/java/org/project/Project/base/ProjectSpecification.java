package org.project.Project.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.project.Project.utils.ReadExcel;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;



public class ProjectSpecification extends AbstractTestNGCucumberTests {
    public static ChromeDriver driver;
    public String fileName;
   public static Properties prop;
   public ExtentReports extentReports;
   public String testName,testAuthor,testDesc,testCategory;
   public static   ExtentTest test;
    private static int screenshotCount = 0;


    @BeforeMethod
    @Parameters("language")
    public void openBrowser(String language) throws IOException {
        FileInputStream readFile;
        try {
            String filePath="src/main/resources/"+language+".properties";
            readFile = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Language properties file not found"+e);
        }
        prop = new Properties();
        prop.load(readFile);
        driver = new ChromeDriver();
        System.out.println(driver);
        driver.manage().window().maximize();
        driver.get("http://leaftaps.com/opentaps/control/main");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }

    @DataProvider(name = "fetchData", indices = {1}) // to choose the rows to be executed
    public Object[][] sendData() throws IOException {
        String[][] data = ReadExcel.readData(fileName);
        return data;
    }

    @BeforeSuite
    public void startReport(){
        ExtentHtmlReporter reporter=new ExtentHtmlReporter("reports-out/report.html");
        reporter.setAppendExisting(true);

        //Create an object of ExtentReports to attach the data in report.html
         extentReports=new ExtentReports();
        extentReports.attachReporter(reporter);
    }

    @AfterSuite
    public void stopReport(){
        extentReports.flush();
    }

    public void testDetails(){
        test= extentReports.createTest(testName,testDesc);
        test.assignAuthor(testAuthor);
        test.assignCategory(testCategory);

    }
    public void reportStep(String status, String message) {
        try {
            captureScreenshot(status);
            if (status.equalsIgnoreCase("pass")) {
                test.pass(message, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshotPath()).build());
            } else if (status.equalsIgnoreCase("fail")) {
                test.fail(message, MediaEntityBuilder.createScreenCaptureFromPath(getScreenshotPath()).build());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void captureScreenshot(String status) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String timestamp = sdf.format(new Date());
            String screenshotName = "screenshot" + timestamp + "_" + (++screenshotCount) + ".png";

            File screenshotFile = driver.getScreenshotAs(OutputType.FILE);
            String screenshotPath = "screenshots/" + screenshotName;
            FileUtils.copyFile(screenshotFile, new File(screenshotPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String getScreenshotPath() {
        // Returns the path of the last captured screenshot
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = sdf.format(new Date());
        return "screenshots/" + "screenshot" + timestamp + "_" + screenshotCount + ".png";
    }
}

package org.example.Projects;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class DeletePortfolioTest {
    ChromeDriver driver;

    @BeforeMethod
    public void openBrowser() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }

    // @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void DeletePortfolioTest() {
        driver.get("https://www.rediff.com/");
        driver.findElement(By.linkText("Money")).click();

        driver.findElement(By.xpath("//*[@id='signin_info']/a[1]")).click();
        driver.findElement(By.xpath("//*[@id='useremail']")).sendKeys("anshulc55@rediff.com");
        driver.findElement(By.xpath("//*[@id='userpass']")).sendKeys("Test@1234");
        driver.findElement(By.xpath("//*[@id='userpass']")).sendKeys(Keys.ENTER);

        Select portfolio=new Select(driver.findElement(By.xpath("//select[@id='portfolioid']")));
        portfolio.selectByVisibleText("King1");
//        System.out.println("Portfolio Selected Title"+driver.getTitle());
        String currentUrl = driver.getCurrentUrl();

        String[] urlParts = currentUrl.split("\\?");

        if (urlParts.length > 1) {
            String query = urlParts[1];

            String[] parameters = query.split("&");

            for (String parameter : parameters) {
                String[] keyValue = parameter.split("=");
                if (keyValue.length == 2) {
                    String key = keyValue[0];
                    String value = keyValue[1];

                    if ("portfolioId".equals(key)) {
                        System.out.println("portfolioId: " + value);
                    }
                }
            }
        } else {
            System.out.println("No query parameters found in the URL.");
        }
        driver.findElement(By.xpath("//a[@id='deletePortfolio']")).click();
        driver.switchTo().alert().accept();
        // Take a screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File screenshot = ts.getScreenshotAs(OutputType.FILE);

        // Define the destination path for the screenshot
        String screenshotPath = "out/screenshot.png";

        try {
            // Copy the screenshot file to the destination path
            FileUtils.copyFile(screenshot, new File(screenshotPath));
            System.out.println("Screenshot saved to: " + screenshotPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Reload the page
        driver.navigate().to(currentUrl);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Select portfolio1=new Select(driver.findElement(By.xpath("//select[@id='portfolioid']")));
        List<WebElement> options=portfolio1.getOptions();
        int opsize=options.size();
        for (int i=0;i<opsize;i++){
            String option=options.get(i).getText();
            System.out.println(option);
        }
    }
}
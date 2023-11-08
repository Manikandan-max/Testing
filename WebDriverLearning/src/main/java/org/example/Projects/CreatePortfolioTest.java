package org.example.Projects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class CreatePortfolioTest {
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
    public void CreatePortfolioTest() {
        driver.get("https://www.rediff.com/");
        driver.findElement(By.linkText("Money")).click();

        driver.findElement(By.xpath("//*[@id='signin_info']/a[1]")).click();
        driver.findElement(By.xpath("//*[@id='useremail']")).sendKeys("anshulc55@rediff.com");
        driver.findElement(By.xpath("//*[@id='userpass']")).sendKeys("Test@1234");
        driver.findElement(By.xpath("//*[@id='userpass']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//a[@id='createPortfolio']")).click();
        driver.findElement(By.xpath("//input[@id='create']")).clear();
        driver.findElement(By.xpath("//input[@id='create']")).sendKeys("King1");
        driver.findElement(By.xpath("//input[@id='createPortfolioButton']")).click();




    }
}

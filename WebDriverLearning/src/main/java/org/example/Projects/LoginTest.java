package org.example.Projects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {
    ChromeDriver driver;

    @BeforeMethod
    public void openBrowser() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void loginRediff() {
        driver.get("https://www.rediff.com/");
        driver.findElement(By.linkText("Money")).click();

        driver.findElement(By.xpath("//*[@id='signin_info']/a[1]")).click();
        driver.findElement(By.xpath("//*[@id='useremail']")).sendKeys("anshulc55@rediff.com");
        driver.findElement(By.xpath("//*[@id='userpass']")).sendKeys("Test@1234");
        driver.findElement(By.xpath("//*[@id='userpass']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("(//a[normalize-space()='Anuj'])[1]")).isDisplayed();


    }
}

package org.example.Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class VerifyWebElementVisibility {
    ChromeDriver driver=new ChromeDriver();
    @BeforeMethod
    public void openBrowser(){

        driver.manage().window().maximize();

        driver.get("https://jqueryui.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

   // @Test
    public void verifyElementDisplay(){
        WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Toggle']"));
        element.click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        WebElement headingText= driver.findElement(By.xpath("//*[@id='effect']/h3"));

        Assert.assertTrue(headingText.isDisplayed());
    }

    @Test
    public void verifyElementisEnabled(){
        WebElement resizableLink = driver.findElement(By.linkText("Resizable"));
        System.out.println("Link is Enabled "+resizableLink.isEnabled());

    }
}

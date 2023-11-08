package org.example.Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HandleIFrame {
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

    @Test
    public void iFrameTest(){
        driver.findElement(By.xpath("//a[normalize-space()='Button']")).click();

        WebElement pageTitle = driver.findElement(By.xpath("//h1[normalize-space()='Button']"));

        Assert.assertEquals(pageTitle.getText(),"Button");


        // Switching to Frame
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        WebElement firstButton = driver.findElement(By.xpath("//*[@class='widget']/button"));
        Assert.assertEquals(firstButton.getText(),"A button element");


        //Switching back to Parent frame
        driver.switchTo().parentFrame();
        WebElement element = driver.findElement(By.xpath("//h2[normalize-space()='Examples']"));
        Assert.assertEquals(element.getText(),"Examples");

    }
}

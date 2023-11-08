package org.example.Advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class UploadFileClass {
    ChromeDriver driver=new ChromeDriver();
    @BeforeMethod
    public void openBrowser(){

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void uploadFile(){
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement uploadFile = driver.findElement(By.id("file-upload"));
        String filePath="C:/Users/hariv/OneDrive/Pictures/Screenshots/test14.png";
        uploadFile.sendKeys(filePath);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.id("file-submit")).click();

        String confirmText=driver.findElement(By.xpath("//*[@id='content']/div/h3")).getText();
        Assert.assertEquals(confirmText,"File Uploaded!");

    }

}

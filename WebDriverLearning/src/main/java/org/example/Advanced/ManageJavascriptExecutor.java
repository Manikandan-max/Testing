package org.example.Advanced;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ManageJavascriptExecutor {
    ChromeDriver driver;
    @BeforeMethod
    public void openBrowser(){

        driver=new ChromeDriver();
        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();

    }

    @Test
    public void handleTest(){
        JavascriptExecutor jsExecutor=driver;
        jsExecutor.executeScript("window.location='https://www.rediff.com'");
        String test= (String) jsExecutor.executeScript("return document.title");
        Assert.assertEquals(test,"Rediff.com: News | Rediffmail | Stock Quotes | Shopping");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}

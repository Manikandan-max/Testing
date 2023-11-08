package org.example.Waits;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class PageLoadTimeOutClass {

    @Test
    public void ccnPageLoadTest(){
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://edition.cnn.com/");
        driver.quit();
    }
}

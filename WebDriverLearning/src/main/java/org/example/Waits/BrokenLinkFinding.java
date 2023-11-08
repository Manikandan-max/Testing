package org.example.Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BrokenLinkFinding {

    @Test
    public void testImplicitWait(){
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://edition.cnn.com/");

        List<WebElement> links=driver.findElements(By.tagName("a"));

        System.out.println("Number of Links : "+links.size());

        for (WebElement link:links
             ) {
            String URL= link.getAttribute("href");
            GetLinkStatus.verifyDetails(URL);


        }
        System.out.println("Total Number of Broken Link: ");
        GetLinkStatus.invalidLinkCount();

        driver.quit();

    }
}

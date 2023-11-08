package org.example.Advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AjaxHandle {
    ChromeDriver driver=new ChromeDriver();
    @BeforeMethod
    public void openBrowser(){

        driver.manage().window().maximize();

        driver.get("https://google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }


    @Test
    public void handleAutoSuggest(){
        driver.findElement(By.name("q")).sendKeys("Selenium");
        List<WebElement> searchElements = driver.findElements(By.xpath("//*[@id=\"Alh6id\"]/div[1]/div/ul/li"));
        System.out.println(searchElements.get(4).getText());
        for (WebElement search:searchElements
             ) {
            System.out.println("Suggested ELements: "+search.getText());

        }
    }

}

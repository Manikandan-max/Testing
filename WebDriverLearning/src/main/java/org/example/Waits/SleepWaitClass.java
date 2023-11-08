package org.example.Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SleepWaitClass {

    @Test
    public void googleSearchTest(){

        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        WebElement searchBox=driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchBox.sendKeys("Udemy");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement searchResult =driver.findElement(By.xpath("(//li[@role='presentation'])[6]"));
        searchResult.click();

        driver.quit();

    }
}

package org.example.Waits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class ImplicitWaitClass {

    @Test
    public void sampleTest(){
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.google.com/");

        WebElement searchBox=driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchBox.sendKeys("Udemy");

        WebElement searchResult =driver.findElement(By.xpath("(//li[@role='presentation'])[6]"));
        searchResult.click();

        driver.quit();
    }
}

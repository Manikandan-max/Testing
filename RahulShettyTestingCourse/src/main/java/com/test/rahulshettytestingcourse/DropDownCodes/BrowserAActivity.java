package com.test.rahulshettytestingcourse.DropDownCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserAActivity {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        Thread.sleep(2000);
        driver.navigate().to("https://www.tutorialspoint.com/how-to-use-selenium-webdriver-to-click-google-search");
        driver.navigate().back();
        driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Udemy");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']")).submit();
        Thread.sleep(3000);
        driver.close();
    }
}

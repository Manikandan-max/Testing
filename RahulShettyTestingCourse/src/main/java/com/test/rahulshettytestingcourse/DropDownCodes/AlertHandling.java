package com.test.rahulshettytestingcourse.DropDownCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AlertHandling {
    public static void main(String[] args) throws InterruptedException {
        String text="King";
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(text);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
        System.out.println(driver.switchTo().alert().getText());;
        Thread.sleep(2000);

        driver.switchTo().alert().accept();


    }
}

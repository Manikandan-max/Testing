package com.test.rahulshettytestingcourse.DropDownCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginPage {
    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.xpath("//input[@id='inputUsername']")).sendKeys("rahul");
        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("(//input[@id='chkboxOne'])[1]")).click();
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//p[normalize-space()='You are successfully logged in.']")).getText());
        driver.close();



    }
}

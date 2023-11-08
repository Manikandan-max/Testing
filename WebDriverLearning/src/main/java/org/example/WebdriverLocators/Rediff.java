package org.example.WebdriverLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Rediff {

    @Test
    public void rediffTest() throws InterruptedException {
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://portfolio.rediff.com/portfolio-login");

        driver.findElement(By.xpath("//input[@id='useremail']")).sendKeys("king@gmail.com");

        driver.findElement(By.xpath("//input[@id='userpass']")).sendKeys("asdf1234");
        driver.findElement(By.xpath("//input[@id='rememberflag']")).click();
        Thread.sleep(4000);

        driver.findElement(By.xpath("//span[@class='block msprite moneywizlogo negative curhand']")).click();
        Thread.sleep(3000);
        System.out.println(driver.getTitle());

        driver.quit();
    }
}

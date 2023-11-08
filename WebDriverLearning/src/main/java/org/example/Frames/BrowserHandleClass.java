package org.example.Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class BrowserHandleClass {
    ChromeDriver driver = new ChromeDriver();

    @BeforeMethod
    public void openBrowser() {

        driver.manage().window().maximize();

        driver.get("https://edition.cnn.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void handleTest() throws InterruptedException {
        driver.get("https://www.naukri.com/");
        String mainPageWindow= driver.getWindowHandle();
        System.out.println("Address: "+ mainPageWindow);
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']")).sendKeys("harivmani01@gmail.com");
        driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys("Maniking0@");
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div[2]/div/div/div[2]/div/div[3]/div/span")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("(//div[@role='link'])[1]")).click();

        Thread.sleep(4000);

        driver.findElement(By.xpath("(//div[@class='tc-card'])[1]")).click();
        String childWindow= driver.getWindowHandle();
        System.out.println("Child WIndow Address: "+childWindow);
    }

}

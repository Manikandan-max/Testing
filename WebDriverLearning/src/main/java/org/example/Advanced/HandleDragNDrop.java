package org.example.Advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HandleDragNDrop {
    ChromeDriver driver=new ChromeDriver();
    @BeforeMethod
    public void openBrowser(){

        driver.manage().window().maximize();

        driver.get("https://jqueryui.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();

    }

    //@Test
    public void handleDragTest(){

        driver.findElement(By.xpath("//*[@id=\"sidebar\"]/aside[1]/ul/li[1]/a")).click();
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        WebElement dragLink=driver.findElement(By.xpath("//*[@id=\"draggable\"]"));

        Actions action=new Actions(driver);

        action.dragAndDropBy(dragLink,110,120).build().perform();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.switchTo().parentFrame();
    }

    //@Test
    public void handleDropTest(){
        driver.get("https://jqueryui.com/");
        driver.findElement(By.linkText("Droppable")).click();
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        WebElement source = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
        WebElement destination= driver.findElement(By.xpath("//*[@id=\"droppable\"]"));

        Actions action=new Actions(driver);

        action.dragAndDrop(source,destination).build().perform();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.switchTo().parentFrame();

    }

    @Test
    public void clickNholdTest(){
        driver.get("https://jqueryui.com/");
        driver.findElement(By.linkText("Droppable")).click();
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        WebElement source = driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
        WebElement destination= driver.findElement(By.xpath("//*[@id=\"droppable\"]"));

        Actions action=new Actions(driver);

        action.clickAndHold(source).moveToElement(destination).release(destination).build().perform();
    }


}

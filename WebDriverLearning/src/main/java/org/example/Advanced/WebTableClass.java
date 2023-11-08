package org.example.Advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class WebTableClass {
    ChromeDriver driver=new ChromeDriver();
    @BeforeMethod
    public void openBrowser(){

        driver.manage().window().maximize();

        driver.get("https://money.rediff.com/index.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void handleTable(){
//        driver.findElement(By.xpath("//a[normalize-space()='Money']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Indices']")).click();
        driver.findElement(By.xpath("//a[@id='showMoreLess']"));

        List<WebElement> rowCount =  driver.findElements(By.xpath("//*[@id=\"dataTable\"]/tbody/tr"));
        System.out.println("Total Number of Rows: "+rowCount.size());

        List<WebElement> colsHeading= driver.findElements(By.xpath("//*[@id=\"dataTable\"]/thead/tr[1]/th"));
        System.out.println("Total Number of Columns : "+colsHeading.size());
        List<WebElement> colsCount= driver.findElements(By.xpath("//*[@id=\"dataTable\"]/tbody/tr[1]/td"));
        System.out.println("Total Number of Columns : "+colsCount.size());

        for (WebElement col:colsHeading
             ) {

            System.out.println(String.format("%-25s",col.getText()));

        }

        for (WebElement row:rowCount
             ) {
            List<WebElement> cols = row.findElements(By.tagName("td"));
            for (WebElement col:cols
                 ) {
                System.out.println(String.format("%-25s",col.getText()));

            }

        }

    }

}

package org.example.Advanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionKeyNMouse {

    ChromeDriver driver=new ChromeDriver();
    @BeforeMethod
    public void openBrowser(){

        driver.manage().window().maximize();


        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        /**
         * If we didn't mention the timeout
         *  org.openqa.selenium.ElementNotInteractableException: element not interactable
         *   (Session info: chrome=118.0.5993.89)
         *
         **/


    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();

    }

    @Test
    public void handleMouseHover(){
        driver.get("https://www.americangolf.eu/");
        WebElement clothLink = driver.findElement(By.xpath("//a[@class='a-level-1'][normalize-space()='Golf Clothing']"));

        //Creating the Object of Action Class to Move the Mouse

        Actions actions=new Actions(driver);
        actions.moveToElement(clothLink).build().perform();

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='CLOTHFOOTW_1']/ul/li[1]/ul/li[7]/a/span"))));
        WebElement mensJacketLink = driver.findElement(By.xpath("//*[@id='CLOTHFOOTW_1']/ul/li[1]/ul/li[7]/a/span"));
        mensJacketLink.click();

        Assert.assertEquals("Golf Jackets | Men's Golf Jackets | American Golf",driver.getTitle());
    }

}

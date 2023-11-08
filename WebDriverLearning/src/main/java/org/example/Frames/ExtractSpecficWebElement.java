package org.example.Frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class ExtractSpecficWebElement {
    ChromeDriver driver=new ChromeDriver();
    @BeforeMethod
    public void openBrowser(){

        driver.manage().window().maximize();

        driver.get("https://edition.cnn.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void getElement(){
        WebElement webElement = driver.findElement(By.xpath("(//div[contains(@class,'container container_lead-plus-headlines cnn')])[2]"));
        List<WebElement> topStories=webElement.findElements(By.tagName("a"));

        System.out.println("Number of Top Stories in CNN : "+topStories.size());

        for (WebElement topStory:topStories){
            String text = topStory.getText();

            if (!text.isEmpty()){
                System.out.println(text);
            }
            else {
                System.out.println("Empty Links.....");
            }
        }

    }

}

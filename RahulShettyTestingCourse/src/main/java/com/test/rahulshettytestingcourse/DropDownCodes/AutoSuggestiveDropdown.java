package com.test.rahulshettytestingcourse.DropDownCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSuggestiveDropdown {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(3000);
       List<WebElement> elementList= driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

       for(WebElement option : elementList){
           if(option.getText().equalsIgnoreCase("India")){
               option.click();
               break;
           }

       }

    }
}

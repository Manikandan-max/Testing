package com.test.rahulshettytestingcourse.DropDownCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='MAA']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@value='DEL'])[2]")).click();
        /**
         *
         * Calender Automation
         * */
        driver.findElement(By.cssSelector(".ui-state-highlight")).click();
    }
}

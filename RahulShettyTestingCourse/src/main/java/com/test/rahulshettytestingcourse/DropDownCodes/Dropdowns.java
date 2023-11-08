package com.test.rahulshettytestingcourse.DropDownCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdowns {
    public static void main(String[] args) {
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
        WebElement staticDropdown=driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
        Select dropdown=new Select(staticDropdown);
        dropdown.selectByValue("USD");
    }
}

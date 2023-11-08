package com.test.rahulshettytestingcourse.DropDownCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class EndtoEndSpiceJet {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        driver.findElement(By.xpath("//a[@value='MAA']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//a[@value='DEL'])[2]")).click();
        driver.findElement(By.cssSelector(".ui-state-highlight")).click();
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){
            System.out.println("Its Enabled");
            Assert.assertTrue(true);

        }else {
            Assert.fail();
        }

        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        System.out.println();
        driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
        System.out.println();
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
        System.out.println(driver.findElement(By.xpath("//span[contains(text(),'The special discounted fares are applicable only t')]")).getText());

        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox'")).size());
        Thread.sleep(2000);
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);
        for(int i=1;i<5;i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        driver.findElement(By.id("btnclosepaxoption")).click();
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(),"5 Adult");
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        Thread.sleep(2000);
        WebElement staticDropdown=driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));
        Select dropdown=new Select(staticDropdown);
        dropdown.selectByValue("USD");
        driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).submit();
        Thread.sleep(2000);
        driver.quit();

    }
}

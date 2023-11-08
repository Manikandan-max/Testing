package com.test.rahulshettytestingcourse.DropDownCodes;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class UpdatedDropdown {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/dropdownsPractise/");
        System.out.println("Hello");
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

        /***
         *
         * Radio Button
         * */
//        System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
//        System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
        if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")){
            System.out.println("Its Enabled");
            Assert.assertTrue(true);

        }else {
            Assert.fail();
        }


        driver.quit();

    }
}

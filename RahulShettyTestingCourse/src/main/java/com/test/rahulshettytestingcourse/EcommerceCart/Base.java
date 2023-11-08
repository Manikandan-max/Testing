package com.test.rahulshettytestingcourse.EcommerceCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Base {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String[] itemsNeeded = {"Cucumber", "Brocolli","Beans"};
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i < products.size(); i++) {
            String[] name = products.get(i).getText().split("-");
            String newName=name[0].trim();
            List itemsList= Arrays.asList(itemsNeeded);
            if (itemsList.contains(newName)) {
                List<WebElement> addToCartButtons = driver.findElements(By.xpath("//button[text()='ADD TO CART']"));
                addToCartButtons.get(i).click();

            }
        }

    }
}

package org.project.Project.Reports;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class LearnScreenshot {
    public static void main(String[] args) {
        ChromeDriver driver = new ChromeDriver();
        System.out.println(driver);
        driver.manage().window().maximize();
        driver.get("http://leaftaps.com/opentaps/control/main");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        try {
            // Enter username
            WebElement usernameField = driver.findElement(By.id("username"));
            usernameField.sendKeys("demosalesManager");
            String enteredUsername = usernameField.getAttribute("value");

            // Enter password
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("crmsfa");
            String enteredPassword = passwordField.getAttribute("value");

            // Take screenshot for the entered username
            File usernameScreenshot = usernameField.getScreenshotAs(OutputType.FILE);
            saveScreenshot(usernameScreenshot, "username");

            // Take screenshot for the entered password
            File passwordScreenshot = passwordField.getScreenshotAs(OutputType.FILE);
            saveScreenshot(passwordScreenshot, "password");

            // Print the entered data
            System.out.println("Entered Username: " + enteredUsername);
            System.out.println("Entered Password: " + enteredPassword);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }

    private static void saveScreenshot(File file, String elementName) throws IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String timestamp = sdf.format(new Date());
        String screenshotPath = "screenshots/" + elementName + "_" + timestamp + ".png";
        FileUtils.copyFile(file, new File(screenshotPath));
    }

}

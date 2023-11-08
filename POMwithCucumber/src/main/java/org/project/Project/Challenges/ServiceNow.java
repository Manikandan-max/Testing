package org.project.Project.Challenges;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class ServiceNow {
    @Test
    public void createIncident(){
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://dev81134.service-now.com/");
        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("qyKvXFk/5Y%4");
        driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
        String showPath="document.querySelector('body > macroponent-f51912f4c700201072b211d4d8c26010')" +
                        ".shadowRoot.querySelector('div > sn-canvas-appshell-root > sn-canvas-appshell-layout > sn-canvas-ucm')" +
                        ".shadowRoot.querySelector('now-modal')" +
                        ".shadowRoot.querySelector('div > div > div > div.now-modal-footer > now-button')" +
                        ".shadowRoot.querySelector('button > slot > span').click();";
        driver.executeScript(showPath);
        //This Element is inside 3 nested shadow DOM.
        String cssSelectorForHost1 = "macroponent-f51912f4c700201072b211d4d8c26010[component-id='oleltvk']";
        String cssSelectorForHost2 = "sn-polaris-layout[component-id='oleltvk-polarisLayout']";
        String cssSelectorForHost3 = "sn-polaris-header[now-id='iadn72rn99du-14']";
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        SearchContext shadow0 = driver.findElement(By.cssSelector("macroponent-f51912f4c700201072b211d4d8c26010[component-id='oleltvk']")).getShadowRoot();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        SearchContext shadow1 = shadow0.findElement(By.cssSelector("sn-polaris-layout[component-id='oleltvk-polarisLayout']")).getShadowRoot();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        SearchContext shadow2 = shadow1.findElement(By.cssSelector("sn-polaris-header[now-id='iadn72rn99du-14']")).getShadowRoot();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        shadow2.findElement(By.cssSelector("#d6e462a5c3533010cbd77096e940dd8c")).click();
        //This Element is inside 5 nested shadow DOM.

        SearchContext shadow3 = shadow2.findElement(By.cssSelector("sn-polaris-menu[aria-label='Unpinned All menu']")).getShadowRoot();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        SearchContext shadow4 = shadow3.findElement(By.cssSelector("sn-collapsible-list[now-id='iadn72rn99du-68']")).getShadowRoot();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        shadow4.findElement(By.cssSelector(" div:nth-child(1) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(8)")).click();
    }
}

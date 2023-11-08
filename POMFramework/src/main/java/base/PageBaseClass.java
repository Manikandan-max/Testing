package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.LandingPage;

import java.time.Duration;

public class PageBaseClass {

    public WebDriver driver;

    /******************Invoke the Browser***********************/
    public void invokeBrowser(String browserName) {
        try {
            if (browserName.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();

            } else if (browserName.equalsIgnoreCase("firefox")) {
                driver = new FirefoxDriver();

            } else {
                driver = new SafariDriver();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        } catch (Exception e) {
            System.out.println(e.getMessage());
         //   reportFail(e.getMessage());
        }
        driver.manage().window().maximize();
    }

    /***************   Open the Application
     * @return*******************/
    public LandingPage openApplication(){
        driver.get("https://www.rediff.com/");
        return PageFactory.initElements(driver, LandingPage.class);
    }
    /**************  Get the Application Title    **********************/
    public void getTitle(String expectedTitle){
        String actualTitle=driver.getTitle();
        System.out.println("Actual Title: "+actualTitle);
        System.out.println("Expected Title: "+expectedTitle);
        Assert.assertEquals(actualTitle,expectedTitle);
    }
}

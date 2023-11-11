package org.project.Marathon.pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.project.Marathon.base.ProjectSetup;

public class LandingPage extends ProjectSetup {
    public LandingPage(WebDriver driver) {
        this.driver=driver;
    }




    public void doSelectCity(){
        elementClick("//*[@id='justickets']/div/div[1]/div[1]/div/a[5]/span");
        enterText("//*[@id='justickets']/div/div[2]/div/div[1]/input","Chennai");
        elementClick("//div[@class='state']//div[@class='city shadow-small'][normalize-space()='Chennai']");

    }

    public void doSearchMovies(){
        enterText("//input[@placeholder='Search for a movie...']","Japan");
        elementClick("//body/div[@id='justickets']/div/div[@class='app']/div/div[@class='movies listing section']/div/div[@class='grid']/div[1]/div[1]");
        String movieTitle = getElement("//h2[normalize-space()='Japan']").getText();
        System.out.println(movieTitle);
        String pageTitle= driver.getTitle();
        if (pageTitle.equals("Book your tickets for Japan (Tamil) in Chennai on Justickets")){
            reportPass("Title verified");
        }
    }

    public void doBooking(){
        elementClick("//div[@class='header']//div[2]");
        elementClick("//a[normalize-space()='6:45 PM']");
        elementClick("//button[normalize-space()='Okay']");
        elementClick("//div[contains(text(),'J15')]");
        elementClick("//div[contains(text(),'J14')]");
        elementClick("//div[@class='box progress enabled']");
    }
    public void doPayment(){
        elementClick("//*[@id='justickets']/div/div[2]/div/div[3]/div[1]/div[2]/div[2]/div/div/div[1]");
        enterText("//*[@id='justickets']/div/div[2]/div/div[3]/div[1]/div[2]/div[2]/form/div[1]/input","324543125432");
        enterText("//*[@id='justickets']/div/div[2]/div/div[3]/div[1]/div[2]/div[2]/form/div[2]/div[1]/input","12/2026");
        enterText("//input[@type='password']","546");
        enterText("//*[@id='justickets']/div/div[2]/div/div[3]/div[1]/div[2]/div[2]/form/div[3]/input[1]","Ajith Kumar");
        enterText("//input[@type='email']","Mathan@gmail.com");
        enterText("//*[@id='justickets']/div/div[2]/div/div[3]/div[1]/div[2]/div[2]/form/div[3]/div/input","987656453210");
        elementClick("//span[@class='disabled']");
    }
}

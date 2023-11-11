package org.project.Marathon.testcase;

import org.project.Marathon.base.ProjectSetup;
import org.project.Marathon.pages.LandingPage;
import org.testng.annotations.Test;

public class JustTicketsTest extends ProjectSetup {

    public LandingPage page;

    @Test
    public void doTicketBookingTest(){

        ProjectSetup setup=new ProjectSetup();
        setup.openBrowser("chrome");
        page= setup.openApplication();
        page.doSelectCity();
        page.doSearchMovies();
        page.doBooking();
        page.doPayment();


    }
}

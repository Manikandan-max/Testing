package org.example.TESTNG;

import org.testng.SkipException;
import org.testng.annotations.Test;

public class FaceBookProfileTest {
    @Test
    public void checkProfileLink(){
        System.out.println("Link is Working");
    }
    @Test(enabled = false,priority = 2)
    public void checkProfilePictures(){
        System.out.println("Profile Picture is visible");
    }
    @Test
    public void checkProfileLink1(){
        System.out.println("Link Skipped is Working");
        throw new SkipException("Skipping the Message ");
    }
}

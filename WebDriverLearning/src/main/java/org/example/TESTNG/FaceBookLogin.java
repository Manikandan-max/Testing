package org.example.TESTNG;

import org.testng.annotations.Test;

public class FaceBookLogin {
    @Test
    public void loginWithValidCred(){
        System.out.println("Hi, Successfully Logged In");
    }
    @Test
    public void loginWithInValidCred(){
        System.out.println("Oops! Wrong Credentials");
    }
}

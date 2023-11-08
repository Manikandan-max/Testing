package org.example.Waits;

import java.net.HttpURLConnection;
import java.net.URL;

public class GetLinkStatus {
    static int invalidLink;
    public static void verifyDetails(String url){
        try {
            URL url1=new URL(url);
            HttpURLConnection urlConnection= (HttpURLConnection) url1.openConnection();

            //Define TimeOut
            urlConnection.setConnectTimeout(50000);

            //Hit Url

            urlConnection.connect();

            if (urlConnection.getResponseCode()==200){

            }else {
                System.out.println(url + " :"+urlConnection.getResponseMessage()+" : " +urlConnection.HTTP_NOT_FOUND);
                invalidLink++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public static void invalidLinkCount(){
        System.out.println("Invalid Link COunt: "+ invalidLink);
    }
}

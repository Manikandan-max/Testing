package org.example.Files;

import org.json.simple.JSONObject;

public class WriteJson {

    public static void main(String[] args) {
        JSONObject student1=new JSONObject();
        student1.put("Name","John");
        student1.put("Grade","6th");
        student1.put("Location","Chennai");
        System.out.println(student1.toJSONString());
    }
}

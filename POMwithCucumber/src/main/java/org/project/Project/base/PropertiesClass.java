package org.project.Project.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesClass {

    public static void main(String[] args) throws IOException {
        FileInputStream readFile;
        try {
            readFile = new FileInputStream("src/main/resources/config.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Properties properties = new Properties();
        properties.load(readFile);

        System.out.println(properties.getProperty("username"));
        System.out.println(properties.getProperty("password"));



    }
}

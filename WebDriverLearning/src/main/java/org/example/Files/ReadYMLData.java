package org.example.Files;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

public class ReadYMLData {
    public static void main(String[] args) throws FileNotFoundException, YamlException {
        String filepath = System.getProperty("user.dir") + "//testData.yml";
        FileReader file = new FileReader(filepath);
        YamlReader yamlReader = new YamlReader(file);
        Map testData = (Map) yamlReader.read();

        List<Map> testCases = (List<Map>) testData.get("testdata");
        System.out.println(testCases);
        for (Map testCase : testCases
        ) {
            String testName = (String) testCase.get("testName");
            System.out.println("TestCaseName -->>" + testName);

            List<Map> testDataLists = (List<Map>) testCase.get("data");
            for (Map testDataList : testDataLists) {
                for (Object key : testDataList.keySet()) {
                    Object value=testDataList.get(key);
                    System.out.println(key+"---->"+value.toString());
                }
            }
            System.out.println();

        }
//        Map loginTestData= (Map) testCases.get(0);
//        System.out.println(loginTestData.get("testName"));
//        List loginTestDataData= (List) loginTestData.get("data");
//        System.out.println(loginTestDataData);


    }
}

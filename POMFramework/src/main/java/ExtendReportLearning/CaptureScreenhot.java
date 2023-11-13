package ExtendReportLearning;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

public class CaptureScreenhot {
    private static final DateFormat dateformat=new SimpleDateFormat("yyy_MM_dd SSS");

//    public static String captureScreen(WebDriver driver,String screenName){
//        TakesScreenshot screenshot= (TakesScreenshot) driver;
//        File src=screenshot.getScreenshotAs(OutputType.FILE);
//        String dest="POMFramework/Screenshots/"+screenName+".jpeg";
//
//        File target=new File(dest);
//        try {
//            FileUtils.copyFile(src,target);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return dest;
//    }
public static String captureScreen(WebDriver driver, String screenName) {
    TakesScreenshot screenshot = (TakesScreenshot) driver;
    File src = screenshot.getScreenshotAs(OutputType.FILE);
    String dest = System.getProperty("user.dir")+"//Screenshots//" + screenName + ".png";

    try {
        Files.copy(src.toPath(), Path.of(dest), StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    return dest;
}

    public static String generateFilename(ITestResult result){
        Date date=new Date();
        String fileName=result.getName()+"_"+dateformat.format(date);
        return fileName;
    }
}

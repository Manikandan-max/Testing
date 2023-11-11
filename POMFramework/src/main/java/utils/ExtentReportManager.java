package utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class ExtentReportManager {
    // public static ExtentHtmlReporter reporter;
    public static ExtentReports reports;

    public static ExtentReports getReportInstance(){
        if (reports==null){
            String reportName="test-report_"+DateUtils.getTimeStamp()+".html";
            ExtentHtmlReporter reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+reportName);
            reports=new ExtentReports();
            reports.attachReporter(reporter);
            reports.setSystemInfo("OS","WINDOWS 11");
            reports.setSystemInfo("Environment","UAT");
            reports.setSystemInfo("Build Number","11.0.2");
            reporter.config().setReportName("Test Case POM Framework");
            reporter.config().setTestViewChartLocation(ChartLocation.TOP);
            reporter.config().setDocumentTitle("Portfolio Login Test");
            reporter.config().setTimeStampFormat("dd MMM,yyyy HH:mm:ss");

        }
        return reports;

    }

}




package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import pages.LandingPage;
import utils.ExtentReportManager;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class BaseTestClass {

    public WebDriver driver;
    public ExtentReports report = ExtentReportManager.getReportInstance();
    public ExtentTest logger;
    public String dbname;
    public String tablename;

    /****************** Invoke Browser ***********************/
    public void invokeBrowser(String browserName) {

        try {

            if (browserName.equalsIgnoreCase("Chrome")) {
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase("Mozila")) {
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase("IE")) {
                driver = new InternetExplorerDriver();
            } else if (browserName.equalsIgnoreCase("edge")) {
                driver=new EdgeDriver();
            } else {
                driver = new SafariDriver();
            }
        } catch (Exception e) {
            // reportFail(e.getMessage());
            System.out.println(e.getMessage());
        }

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void flushReports() {
        report.flush();
        driver.close();
    }

    /***************** Select Date From Calendar *****************/
    public void selectDateIncalendar(String date) {

        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date expectedDate = dateFormat.parse(date);

            String day = new SimpleDateFormat("dd").format(expectedDate);
            String month = new SimpleDateFormat("MMMM").format(expectedDate);
            String year = new SimpleDateFormat("yyyy").format(expectedDate);

            String expectedMonthYear = month + " " + year;

            while (true) {
                String displayDate = driver.findElement(By.className("dpTitleText")).getText();

                if (expectedMonthYear.equals(displayDate)) {

                    driver.findElement(By.xpath("//td[text()= '" + day + "']")).click();

                    break;
                } else if (expectedDate.compareTo(currentDate) > 0) {
                    driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[4]/button")).click();
                } else {
                    driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[2]/button")).click();
                }

            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


    /***************** Wait Functions in Framework *****************/
    public void waitForPageLoad() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        int i = 0;
        while (i != 180) {
            String pageState = (String) js.executeScript("return document.readyState;");
            if (pageState.equals("complete")) {
                break;
            } else {
                waitLoad(1);
            }
        }

        waitLoad(2);

        i = 0;
        while (i != 180) {
            Boolean jsState = (Boolean) js.executeScript("return window.jQuery != undefined && jQuery.active == 0;");
            if (jsState) {
                break;
            } else {
                waitLoad(1);
            }
        }
    }

    public void waitLoad(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /************** DataBase Connection and Retrieval of Data **********************/
    public void setDatabaseName(String dbName) {
        this.dbname = dbName;
    }

    public void setTableName(String tableName) {
        this.tablename = tableName;
    }
    public List<Hashtable<String, String>> getTableData() {
        List<Hashtable<String, String>> data = new ArrayList<>();

        try {
            // Customize the database connection URL, username, and password as needed
            String jdbcUrl = "jdbc:mysql://localhost:3306/" + dbname;
            String username = "root";
            String password = "Admin01@";

            try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
                String sql = "SELECT * FROM " + tablename;
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    ResultSet resultSet = statement.executeQuery();

                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();

                    while (resultSet.next()) {
                        Hashtable<String, String> rowData = new Hashtable<>();
                        for (int i = 1; i <= columnCount; i++) {
                            String columnName = metaData.getColumnName(i);
                            String columnValue = resultSet.getString(i);
                            rowData.put(columnName, columnValue);
                        }
                        data.add(rowData);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return data;
    }
}

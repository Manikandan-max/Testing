//package org.example.Projects;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.Duration;
//import java.util.Date;
//import java.util.List;
//
//public class AddDeleteStockInPortfolio {
//    ChromeDriver driver;
//
//    @BeforeMethod
//    public void openBrowser() {
//        driver = new ChromeDriver();
//
//        driver.manage().window().maximize();
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//
//
//    }
//
//    //  @AfterMethod
//    public void closeBrowser() {
//        driver.quit();
//    }
//
//    @Test
//    public void addStockTest() {
//        driver.get("https://www.rediff.com/");
//        driver.findElement(By.linkText("Money")).click();
//
//        driver.findElement(By.xpath("//*[@id='signin_info']/a[1]")).click();
//        driver.findElement(By.xpath("//*[@id='useremail']")).sendKeys("anshulc55@rediff.com");
//        driver.findElement(By.xpath("//*[@id='userpass']")).sendKeys("Test@1234");
//        driver.findElement(By.xpath("//*[@id='userpass']")).sendKeys(Keys.ENTER);
//        Select portfolio = new Select(driver.findElement(By.xpath("//select[@id='portfolioid']")));
//        portfolio.selectByVisibleText("King");
//
//
//        //Add Stock
//        driver.findElement(By.id("addStock")).click();
//        driver.findElement(By.id("addstockname")).sendKeys("ITC");
//        // Locate the auto-suggestion elements
//        WebElement autoSuggestionDropdown = driver.findElement(By.id("ajax_listOfOptions"));
//
//        // Find the specific option you want to select
//        WebElement selectedOption = autoSuggestionDropdown.findElement(By.className("optionDivSelected")); // Replace with the class name or another selector
//
//        // Click the selected option
//        Actions actions = new Actions(driver);
//        actions.moveToElement(selectedOption).click().perform();
//
//        //Date Picker Method1
//        //driver.findElement(By.xpath("//input[@id='stockAddDate']")).sendKeys("20-12-2022");
//        //Method2
//        driver.findElement(By.id("stockPurchaseDate")).click();
//        selectDateIncalendar("13/06/2022");
////        selectDateIncalendar("16-01-2023");
//
//        driver.findElement(By.id("addstockqty")).sendKeys("100");
//        driver.findElement(By.id("addstockprice")).sendKeys("224");
//        driver.findElement(By.cssSelector("label[for='nse']")).click();
//        driver.findElement(By.id("addStockButton")).click();
//
////        Verify Stock
////        String stockPicked = driver.findElement(By.xpath("//table[@id='stock']/tbody/tr/td[2]/span/a")).getText();
////        Assert.assertEquals(stockPicked, "ITC Ltd.");
//        int stockRowNumber = getStockRowNumber("ITC Ltd.");
//        System.out.println("Row Number is : " + stockRowNumber);
//        if (stockRowNumber == -1) {
//            Assert.fail("Stock Not Found");
//        }
//
//    }
//
//    @Test(dependsOnMethods = "addStockTest")
//    public void deleteStock() {
//
//        int stockRowNum = getStockRowNumber("ITC Ltd.");
//        driver.findElement(By.xpath("//table[@id='stock']/tbody/tr[" + stockRowNum + "]/td[1]")).click();
//        driver.findElements(By.xpath("//input[@name='Delete']")).get(stockRowNum - 1).click();
//
//        driver.switchTo().alert().accept();
//        driver.switchTo().defaultContent();
//
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//
//        int stockRowNumAfterDelete = getStockRowNumber("ITC Ltd.");
//        Assert.assertEquals(stockRowNumAfterDelete, -1, "Row is Deleted");
//    }
//
//
//    private int getStockRowNumber(String s) {
//        List<WebElement> listOfStocks = driver.findElements(By.xpath("//table[@id='stock']/tbody/tr"));
//        int rowNum = 1;
//        for (WebElement row : listOfStocks
//        ) {
//            List<WebElement> cells = row.findElements(By.xpath("//td"));
//            rowNum++;
//            for (WebElement cell : cells
//            ) {
//                String cellData = cell.getText();
//                System.out.println(cellData);
//                if (!cellData.isEmpty() && cellData.contains(s)) {
//                    return rowNum;
//                }
//
//            }
//
//
//        }
//        return -1;
//    }
//
//    //    private void selectDateInCalender(String s) {
////
////        WebElement calendarLink = driver.findElement(By.id("stockPurchaseDate")); // Replace with the actual ID
////
////        // Click the anchor tag to open the calendar
////        calendarLink.click();
////
////        JavascriptExecutor js = (JavascriptExecutor) driver;
////        js.executeScript("document.getElementById('stockAddDate').value = arguments[0]", s);
////        js.executeScript("displayDatePicker('stockAddDate', this, arguments[0]);", s);
////
////    }
//    public void selectDateIncalendar(String date) {
//
//        Date currentDate = new Date();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        try {
//            Date expectedDate = dateFormat.parse(date);
//
//            String day = new SimpleDateFormat("dd").format(expectedDate);
//            String month = new SimpleDateFormat("MMMM").format(expectedDate);
//            String year = new SimpleDateFormat("yyyy").format(expectedDate);
//
//            String expectedMonthYear = month + " " + year;
//
//            while (true) {
//                String displayDate = driver.findElement(By.className("dpTitleText")).getText();
//
//                if (expectedMonthYear.equals(displayDate)) {
//
//                    driver.findElement(By.xpath("//td[text()= '" + day + "']")).click();
//
//                    break;
//                } else if (expectedDate.compareTo(currentDate) > 0) {
//                    driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[4]/button")).click();
//                } else {
//                    driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[2]/button")).click();
//                }
//
//            }
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//    }
//
//}

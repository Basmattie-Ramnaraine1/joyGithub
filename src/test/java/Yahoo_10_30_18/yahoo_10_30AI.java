package Yahoo_10_30_18;


import ResuableOjbects.Reusable_Method_Loggers;
import ResuableOjbects.Reusable_Methods_Loggers;
import Utilities.Abstract_Class_Parallel;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static ResuableOjbects.Reusable_Method_Loggers.getScreenshot;

public class yahoo_10_30AI extends Abstract_Class_Parallel {

    //declear all variables
    public static WebDriver driver = null;
    public static ExtentReports reports = null;
    public static ExtentTest logger1 = null;
    public static JavascriptExecutor jse = null;
    public static Boolean elementState = null;


    @BeforeSuite
    public void openBrowser() {

        //implicit wait
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        //define the report path

        reports = new ExtentReports("src\\main\\java\\Report_Folder" + UUID.randomUUID() + ".html", true);
        jse = (JavascriptExecutor) driver;

    }//end of before suite

    @Parameters("broswer")
    @BeforeMethod
    public void loggerSession(String browser, Method methodName) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
        if (browser.equalsIgnoreCase("googlechrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized", "--incognito", "disable-infobars");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {

            driver.navigate().to("https://www.firefox.com");
            Thread.sleep(900);
            driver.manage().window().maximize();

        } else if (browser.equalsIgnoreCase("yahoo")) {
        }
        driver.navigate().to("www.yahoo.com");
        Thread.sleep(800);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(14, TimeUnit.SECONDS);
        jse = (JavascriptExecutor) driver;

        logger1 = reports.startTest(methodName.getName());
        logger1.log(LogStatus.INFO, "Test begins...");
    }


    @AfterMethod
    public void endlogger1() {
        reports.endTest(logger1);
        logger1.log(LogStatus.INFO, "end of test");
    }


    @AfterSuite
    public void closeBrowser() {
        reports.endTest(logger1);
        reports.flush();
        reports.close();
        //driver.quit();

    }//end of after suite

    @Test
    public void testcase1() throws IOException, InterruptedException {

        //testing steps
        //1.start test
        logger1 = reports.startTest("navigate to yahoo.com");
        Reusable_Method_Loggers.navigate(logger1, driver, "https://www.yahoo.com/");

        //2.assert page title using if else condition
        String assertTitle = driver.getTitle();
        if (assertTitle.equalsIgnoreCase("yahoo")) {
            logger1.log(LogStatus.PASS, "yahoo title matches");

        } else {
            logger1.log(LogStatus.FAIL, "yahoo title doesn't match" + assertTitle);
            //scrolling to title page
            JavascriptExecutor jse = null;
            jse.executeScript("scroll(0,300)");
            Thread.sleep(1000);
        }// end of if else on title page

        //3.display the count on left panel
        List<WebElement> displayCount = driver.findElements(By.xpath("//*[Contains(@class'Mstart(2px)(')])"));
        logger1.log(LogStatus.INFO, "the link count is " + displayCount.size());
        //print out count in logger resuable


        //4.enter key word 'nutrition' on search field
        Reusable_Method_Loggers.sendKeysMethod(logger1, driver, "//*[@name='p']", "Nutrition", "search field");


        //5.click on search button
        Reusable_Method_Loggers.clickMethod(logger1, driver, "//*[@class='sbb']", "search icon");


        //6.jse scroll down 'bottom'to the page to 5000
        logger1.log(LogStatus.INFO, "Scroll down to the  search page");
        Thread.sleep(1600);
        JavascriptExecutor jse = null;
        jse.executeScript("scroll(0,5000)");

        //7. display the search result number
        List<WebElement> linkCount = driver.findElements(By.xpath("//*li[contains(@class,'D(ib) Mstart(21px) Mend(13px)')]"));
        logger.log(LogStatus.INFO, "The link count is " + linkCount.size());
        Reusable_Methods_Loggers.sendMethod(logger, driver, "//*[@name='p']", "Nutrition", "Search Field");
        Reusable_Methods_Loggers.clickMethod(logger, driver, "//*[@id='uh-search-button']", "Search Icon");
        logger.log(LogStatus.INFO, "Scrolling to the bottom of the page");
        jse.executeScript("scroll(0,5000)");

        // 8. click on sign in button
        Thread.sleep(1000);
        jse.executeScript("scroll(0,-5000)");
        Reusable_Method_Loggers.clickMethod(logger1, driver, "//*[@id='yucs-login_signIn']", "sign in");

        //9.verify the boolean to see if check box is true or false
        Thread.sleep(2000);
        Reusable_Method_Loggers.checkbox(logger1, driver, "//*[@id='persistent']", "Check Box");


        //10.enter a valid user  name
        Reusable_Method_Loggers.sendKeysMethod(logger1, driver, "//*[@id='login-username']", "joymatiram@yahoo.com", "username");
        //11.click on 'Next" button
        Reusable_Method_Loggers.clickMethod(logger1, driver, "//*[@id='login-signin']", "Next");
//compare error message
        Thread.sleep(2000);
        Reusable_Method_Loggers.compareMessages(logger1, driver,"//*[@id='username-error']","");
        //12.capture the error message and verify the message matches
        String errorMessage = driver.getTitle();
        if (errorMessage.equalsIgnoreCase("sorry, we don't recognize this email")) {
            logger1.log(LogStatus.PASS, " error message matches");

        } else {
            logger1.log(LogStatus.FAIL, "the error message doesn't match" + errorMessage);
            //call the screen shot command
            getScreenshot(driver, logger1, "username-error");

        }


    }


}















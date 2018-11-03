package Yahoo;

import ResuableOjbects.ReusableMethods_week9_logger;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


public class Yahoo_searchResult{
    /*
    1. navigate to yahoo
    2. verify the home page title as 'Yahoo'
    3. verify the count of text links exist on home page
    4. enter a keyword on search field
    5.click on search
    6. scroll to bottom for search result
    7. capture search result
    8. send it to extent report
     */
    //declear all the global variable before annotation methods
    WebDriver driver;
    ExtentReports report;
    ExtentTest logger;

    @BeforeSuite
    public void openBrowsers(){
        //define the driver path
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized","--ingocnito");
        driver = new ChromeDriver(options);

        //timeout using implicit wait
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

        //define the report path
        report= new ExtentReports("src\\main\\java\\Report_Folder\\ExtentReport"+UUID.randomUUID()+ ".html",true);
    }//end of before suite
    @AfterSuite
    public  void closeBrowser(){
     //end of test of the report
     report.endTest(logger);
     //flush the report
        report.flush();
        //close the report
        report.close();
        //driver.quit();
    }//end of after suite
    @Test
    public void yahoosearchResult() throws InterruptedException, IOException {
        //start the test
        logger = report.startTest("yahoo search result");

        //navigate to yahoo home page
        ReusableMethods_week9_logger.navigate(logger,driver,"https://www.yahoo.com");
        //verify the home page title
        String yahooTitle = driver.getTitle();
        if (yahooTitle.equalsIgnoreCase("Yahoo")){
            logger.log(LogStatus.PASS,"The yahoo title matches");

        }else {
            logger.log(LogStatus.FAIL,"The yahoo title doesn't match" + yahooTitle);
        }
       //verify the list count for the link
        List<WebElement> linkCount = driver.findElements(By.xpath("//*[contains(@class,'Mstart(')]"));
    logger.log(LogStatus.INFO," The link count is " + linkCount.size());
//enter a keyword on a search field
        ReusableMethods_week9_logger.sendKeysMethod(logger,driver,"//*[@name='p']","Brooklyn","Search Field");

    //click on search oicon
        ReusableMethods_week9_logger.clickMethod(logger,driver,"//*[@id='uhhhh-search-button']", "Search icon");
//define javascript executor
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        //scroll to the bottom of the page
        logger.log(LogStatus.INFO,"Scrolling to the bottom of the search result page");
   Thread.sleep(1500);
   jse.executeScript("scroll(0,2000)");

    }//end of test
}//





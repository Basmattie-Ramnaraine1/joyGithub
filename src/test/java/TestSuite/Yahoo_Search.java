package TestSuite;

import ResuableOjbects.ReusableMethods_week9_logger;
import Utilities.Abstract_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class Yahoo_Search extends Abstract_Class {

    @Test
    public void yahoosearchResult() throws IOException, InterruptedException{
        //start the test
        //logger = report.startTest("yahoo search result");

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

        //click on search icon
        ReusableMethods_week9_logger.clickMethod(logger,driver,"//*[@id='uhhhh-search-button']", "Search icon");
//define javascript executor
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        //scroll to the bottom of the page
        logger.log(LogStatus.INFO,"Scrolling to the bottom of the search result page");
        Thread.sleep(1500);
        jse.executeScript("scroll(0,2000)");

    }
}


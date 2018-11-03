package Yahoo;

import ResuableOjbects.Reusable_Methods_Loggers;
//import Reusable_Objects.Reusable_Methods_Loggers;
import Utilities.Abstract_Class;
import Utilities.Abstract_Class_Parallel;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class Yahoo_Search extends Abstract_Class_Parallel {
    @Test
    public void yahoo_Search_Res() throws InterruptedException, IOException {
        Reusable_Methods_Loggers.naviagteMethod(logger, driver, "https://www.yahoo.com");
        String yahooTitle = driver.getTitle();
        if (yahooTitle.equalsIgnoreCase("Yahoo")) {
            logger.log(LogStatus.PASS, "The yahoo title matched");
        } else {
            logger.log(LogStatus.FAIL, "The yahoo tittle didn't match with " + yahooTitle);
        }
        List<WebElement> linkCount = driver.findElements(By.xpath("//*[contains(@class,'D(ib) Mstart(21px) Mend(13px)')]"));
        logger.log(LogStatus.INFO, "The link count is " + linkCount.size());
        Reusable_Methods_Loggers.sendMethod(logger, driver, "//*[@name='p']", "Nutrition", "Search Field");
        Reusable_Methods_Loggers.clickMethod(logger, driver, "//*[@id='uh-search-button']", "Search Icon");
        logger.log(LogStatus.INFO, "Scrolling to the bottom of the page");
        jse.executeScript("scroll(0,5000)");
        Reusable_Methods_Loggers.textSelectionWithSplit(logger, driver, "//*[@class ='compPagination']", "Search Result Number");
        jse.executeScript("scroll(0,-5000)");
        Reusable_Methods_Loggers.clickMethod(logger, driver, "//*[@id='yucs-login_signIn']", "Sign in");
        Reusable_Methods_Loggers.booleanCheckbox(logger, driver, "//*[@id='persistent']", "Checkbox");
        Reusable_Methods_Loggers.sendMethod(logger, driver, "//*[@id='login-username']", "user1@yaho.com", "User Name TextBox");
        Reusable_Methods_Loggers.clickMethod(logger, driver, "//*[@class='orko-button-primary orko-button']", "Next Button");
        Reusable_Methods_Loggers.textSelectionWithIf(logger, driver, "//*[@id='username-error']", "Sorry, we don't recognize this email.", "Error Massage");
    }
}

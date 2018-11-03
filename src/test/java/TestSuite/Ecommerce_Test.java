package TestSuite;

import ResuableOjbects.Reusable_Method_Loggers;
import Utilities.Abstract_Class;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

import java.io.IOException;

public class Ecommerce_Test extends Abstract_Class {

    @Test()
    public void TShirts () throws IOException, InterruptedException {


        Reusable_Method_Loggers.navigate(logger, driver, "http://automationpractice.com/index.php");

        String title = driver.getTitle();

        if (title.equalsIgnoreCase("My-Store")) {

            logger.log(LogStatus.PASS, "The title matches");

        } else {

            logger.log(LogStatus.FAIL, "The title doesn't match " + title);

        }

        Reusable_Method_Loggers.mouseHover(logger, driver, "//*[@title='Women']", "Women Tab");

        Thread.sleep(2000);

        Reusable_Method_Loggers.clickMethod(logger, driver, "//*[@title='T-shirts']", "T Shirt Tab");
        //Scrolling to the page
        // JavascriptExecutor jse = null
        jse.executeScript("scroll(0,350)");

        Thread.sleep(1000);

        Reusable_Method_Loggers.mouseHover(logger, driver, "//*[@title='Faded Short Sleeve T-shirts']", "Picture");

        Thread.sleep(1000);

        Reusable_Method_Loggers.clickMethod(logger, driver,"//*[@title='Add to cart']", "Cart");



        Thread.sleep(1500);

        Reusable_Method_Loggers.clickMethod(logger, driver, "//*[@title='Proceed to checkout']", "Checkout");

        Reusable_Method_Loggers.clickMethod(logger, driver, "//*[@title='Add']", "Increase Quantity");

        Reusable_Method_Loggers.clickMethod(logger, driver, "//*[@title='Add']", "Increase Quantity");
        Reusable_Method_Loggers.clearMethod(logger, driver,"//*[@title='Add']","Quantity field");
        Reusable_Method_Loggers.sendKeysMethod(logger,driver,"//*[@title='Add']", "3","Increase");


        Thread.sleep(2000);
        //jse.executeScript("scroll(0,350)");

        Reusable_Method_Loggers.clickMethod(logger, driver, "//*[text()='Proceed to checkout']", "Checkout2");


    }




}

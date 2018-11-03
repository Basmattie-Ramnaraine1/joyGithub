package AI_Aut_prac;

import ResuableOjbects.Reusable_Method_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.bcel.generic.Select;
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
import java.util.concurrent.TimeUnit;

public class Autoclass {

    private static WebDriver driver;
ExtentReports reports;
ExtentTest logger1;
ExtentTest logger2;
    private ExtentReports report;
    JavascriptExecutor  jse;


    @BeforeSuite
    public void openBrowser(){
    System.setProperty("webdriver.chrime.driver","src\\main\\resources\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized","incignito", "disable-infobars");

            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);


            //define the report path


            report = new ExtentReports("src\\main\\java\\Report_Folder\\ExtentReport.html", true);
//define the java script
        JavascriptExecutor jse;
            jse = (JavascriptExecutor) driver;
        }

    @AfterSuite
    public void closeBrowser() {

        report.endTest(logger1);
        report.endTest(logger2);

        report.flush();

        report.close();

        //driver.quit();

    }

    @Test
    public void TShirts () throws IOException, InterruptedException {

        logger1 = report.startTest("Proceed to Check out for Tshirts");

        JavascriptExecutor jse = (JavascriptExecutor)driver;

        Reusable_Method_Loggers.navigate(logger1, driver, "http://automationpractice.com/index.php");

        String title = driver.getTitle();

        if (title.equalsIgnoreCase("My-Store")) {

            logger1.log(LogStatus.PASS, "The title matches");

        } else {

            logger1.log(LogStatus.FAIL, "The title doesn't match " + title);

        }

        Reusable_Method_Loggers.mouseHover(logger1, driver, "//*[@title='Women']", "Women Tab");

        Thread.sleep(2000);

        Reusable_Method_Loggers.clickMethod(logger1, driver, "//*[@title='T-shirts']", "T Shirt Tab");
        //Scrolling to the page
       // JavascriptExecutor jse = null
        jse.executeScript("scroll(0,350)");

        Thread.sleep(1000);

        Reusable_Method_Loggers.mouseHover(logger1, driver, "//*[@title='Faded Short Sleeve T-shirts']", "Picture");

        Thread.sleep(1000);

        Reusable_Method_Loggers.clickMethod(logger1, driver,"//*[@title='Add to cart']", "Cart");

        /*String title2 = driver.findElement(By.class("icon-ok")).getText;

        if (title2.equalsIgnoreCase("Product successfully added to your shopping cart")) {

            logger1.log(LogStatus.PASS, "The title matches");

        } else {

            logger1.log(LogStatus.FAIL, "The title doesn't match " + title);

        }*/
        Thread.sleep(1500);

        Reusable_Method_Loggers.clickMethod(logger1, driver, "//*[@title='Proceed to checkout']", "Checkout");

        Reusable_Method_Loggers.clickMethod(logger1, driver, "//*[@title='Add']", "Increase Quantity");

        Reusable_Method_Loggers.clickMethod(logger1, driver, "//*[@title='Add']", "Increase Quantity");
        Reusable_Method_Loggers.clearMethod(logger1, driver,"//*[@title='Add']","Quantity field");
        Reusable_Method_Loggers.sendKeysMethod(logger1,driver,"//*[@title='Add']", "3","Increase");


        Thread.sleep(2000);
        //jse.executeScript("scroll(0,350)");

        Reusable_Method_Loggers.clickMethod(logger1, driver, "//*[text()='Proceed to checkout']", "Checkout2");


    }

    @Test(dependsOnMethods = "TShirts")
    public void SummerDresses () throws IOException, InterruptedException {

        logger2 = report.startTest("Proceed to Check out for Summer Dresses");

        //JavascriptExecutor jse = (JavascriptExecutor)driver;

       // Reusable_Method_Loggers.navigate(logger2, driver, "http://automationpractice.com/index.php");

        Reusable_Method_Loggers.mouseHover(logger2, driver, "//*[@title='Dresses']", "Dresses");

        Thread.sleep(2000);

        Reusable_Method_Loggers.clickMethod(logger2, driver, "//*[@title='Summer Dresses']", "Summer Dresses");

        JavascriptExecutor jse = null;
        jse.executeScript("scroll(0,300)");

        Thread.sleep(1000);

        Reusable_Method_Loggers.mouseHover(logger2, driver, "//*[@title='Printed Summer Dress']", "Printed Summer Dress");

        Reusable_Method_Loggers.clickMethod(logger2, driver, "//*[@title='View']", "More Btn");

        Reusable_Method_Loggers.clickMethod(logger2, driver, "//*[@class='icon-plus']", "Add quantity");
        //clearing the quantity
        Reusable_Method_Loggers.clearMethod(logger2, driver, "//*[@class='icon-plus']", "Add quantity");

        Reusable_Method_Loggers.clickMethod(logger2, driver, "//*[@class='icon-plus']", "Add quantity");

        Reusable_Method_Loggers.clickMethod(logger2, driver, "//*[@class='icon-plus']", "Add quantity");

        WebElement size = driver.findElement(By.xpath("//*[@name='group_1']"));

        //Select sizeDropdown = new Select(size);

       // sizeDropdown.selectByVisibleText("M");

        Reusable_Method_Loggers.clickMethod(logger2, driver, "//*[@name='Submit']", "Add to cart");

        /* String title3 = driver.findElement(By.class("icon-ok")).getText;

        if (title3.equalsIgnoreCase("Product successfully added to your shopping cart")) {

            logger1.log(LogStatus.PASS, "The title matches");

        } else {

            logger1.log(LogStatus.FAIL, "The title doesn't match " + title);

        } */

        Reusable_Method_Loggers.clickMethod(logger1, driver, "//*[@title='Proceed to checkout']", "Checkout");

        Reusable_Method_Loggers.clickMethod(logger1, driver, "//*[@title='Delete']", "Trash Icon");



    }//end of test case 2

}//end of class






























package Utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class Abstract_Class {

public static WebDriver driver = null;
public static ExtentReports report= null;
public static ExtentTest logger= null;
public static JavascriptExecutor jse = null;
@BeforeSuite
    public void openBrowser(){

    System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");

    ChromeOptions options = new ChromeOptions();
    options.addArguments("--start-maximized","--ingocnito","disable-infobars");
    driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);

    report= new ExtentReports("src\\main\\java\\Report_Folder\\");
    jse = (JavascriptExecutor) driver;
}

@BeforeMethod
public void loggerSession(Method methodName) {
    logger = report.startTest(methodName.getName());
    logger.log(LogStatus.INFO, "Automation Test started....");

}
    @AfterMethod
    public void endLogger () {
        report.endTest(logger);
        logger.log(LogStatus.INFO, "Automation Test Scenario ended...");


}
@AfterSuite()
        public void closeBrowser(){
          report.endTest(logger);
          report.flush();
          report.close();
          driver.quit();
          logger.log(LogStatus.INFO,"Automation Test Suite Ended...");


        }





}

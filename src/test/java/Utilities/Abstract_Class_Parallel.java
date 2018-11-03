package Utilities;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class Abstract_Class_Parallel {
    public static WebDriver driver;
    public static ExtentReports report;
    public static JavascriptExecutor jse;
    public static ExtentTest logger;

       @BeforeSuite
    public void openBrowser() {
        report = new ExtentReports("src\\main\\java\\Report_Folder\\ExtentReport.html", true);
    }

    @Parameters("browser")
    @BeforeMethod
    public void loggerSession(String browser, Method methodName) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
        //System.setProperty("webdriver.ie.driver", "src\\main\\resources\\ie.exe");
        //System.setProperty("webdriver.safari.driver", "src\\main\\resources\\safari.exe");
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized", "incognito", "disable-infobars");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            driver.navigate().to("https://www.google.com");
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();
            driver.navigate().to("https://www.internetexplorer.com");
            driver.manage().window().fullscreen();
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
            driver.navigate().to("https://www.safari.com");
            driver.manage().window().fullscreen();
        }else{
            //logger.log(LogStatus.FAIL,"Your web driver didn't work properly");
        }
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        jse = (JavascriptExecutor)driver;
        logger = report.startTest(methodName.getName());
        logger.log(LogStatus.INFO, "Automation Test Suit Started");
    }
    @AfterMethod
    public void endTest() {
        report.endTest(logger);
        logger.log(LogStatus.INFO, "Automation Test Ended");
    }

    @AfterSuite
    public void closeBrowser() {
        report.endTest(logger);
        report.flush();
        report.close();
        driver.quit();
        logger.log(LogStatus.INFO, "Automation Test Suit Ended");
    }
}

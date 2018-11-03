package Google;

import ResuableOjbects.ReusableMethods_week9;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Test01_Google_Search_Result {

    //Before calling annotations
    WebDriver driver;
@BeforeSuite
    public void OpenBrowser() {


    System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

    ChromeOptions options = new ChromeOptions();
    options.addArguments("start-maximized", "incognito");
     driver = new ChromeDriver(options);
     //timeout using implicit wait
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);


}

@AfterSuite
    public void closeBrowser(){
    //driver.quit();


}
@Test()
    public void Testcase1() {
    driver.navigate().to("https://www.google.com");
    //enter a keyword in google search
    ReusableMethods_week9.sendKeysMethod(driver, "//*[@name='q']", "Brooklyn", " Search Field");
//submit on google search
   // ReusableMethods_week9.clickMethod(driver, "//*[@value='Google Search']", "google search");
}
@Test(dependsOnMethods = "Testcase1")
    public void TestCase2(){
    try{
        String searchResult = driver.findElement(By.xpath("//*[@id=resultStats']")).getText();
    String [] searchNumber = searchResult.split(" ");
        System.out.println("My search number is" + searchNumber[1]);


    } catch (Exception err){
        System.out.println("Unable to capture text for Search result");
    }




}



}//end of parent class

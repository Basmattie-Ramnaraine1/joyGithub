package ResuableOjbects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReusableMethods_week9 {
    //method for clicking on an element
    public static void clickMethod(WebDriver driver, String
            locator, String elementname, String url) {


        try {
            System.out.println("Clicking on element" + elementname);
            //store the locator into WebElement variable
            WebElement Clickbtn = driver.findElement(By.xpath(locator));
            Clickbtn.click();

        } catch (Exception err) {
            System.out.println("Unable to Submit on element" + elementname);

        }//end of try catch method
    }//end of submit method
    //method for entering on an element

    public static void sendKeysMethod(WebDriver driver, String locator, String userInput, String elementname){


    try {
        System.out.println("Entering" + userInput + "in element" + elementname);
        //store the locator into Webelement variable
        WebElement input = driver.findElement(By.xpath(locator));
        input.sendKeys(userInput);
    }catch (Exception err){
        System.out.println("Unable to send info on element" + elementname);
    }//end of tyr catch
}//end of send keys method

}














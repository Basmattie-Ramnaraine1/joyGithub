package ResuableOjbects;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import sun.rmi.runtime.Log;

import java.io.File;
import java.io.IOException;

public class Reusable_Method_Loggers {


    private static String elementName;
    private static int indexNumber;

    //method for comparing two data
    public static void compareMessages(ExtentTest logger, WebDriver driver, String locator, String expectedMessage) throws IOException {
        try {
            String actualMessage = driver.findElements(By.xpath(locator)).get(indexNumber).getText();
            if (expectedMessage.equalsIgnoreCase(actualMessage)) {
                logger.log(LogStatus.PASS, "Expected matches with Actual for element " + elementName);
            } else {
                logger.log(LogStatus.FAIL, "Expected - " + expectedMessage + " doesn't match with actual - " + actualMessage);
                getScreenshot(driver, logger, elementName);
            }

        } catch (Exception err) {
            logger.log(LogStatus.FAIL, "Unable to locate element " + elementName);
            getScreenshot(driver, logger, elementName);
        }
    }//end of method for comparing data

    //method for mouse hovering
    public static void mouseHover(ExtentTest logger, WebDriver driver, String locator, String elementName) throws IOException {
        Actions mouseMovement = new Actions(driver);
        try {
            logger.log(LogStatus.INFO, "Hovering over element " + elementName);
            //store the locator into WebElement variable
            WebElement element = driver.findElement(By.xpath(locator));
            mouseMovement.moveToElement(element).perform();
            logger.log(LogStatus.PASS, "Successfully hover over element " + elementName);
        } catch (Exception err) {
            logger.log(LogStatus.INFO, "Unable to hover over element " + elementName);
            getScreenshot(driver, logger, elementName);
        }//end of try catch
    }//end of mouse hover method

    //method for mouse hovering
    public static void mouseHoverByIndex(ExtentTest logger, WebDriver driver, String locator, int indexNumber, String elementName) throws IOException {
        Actions mouseMovement = new Actions(driver);
        try {
            logger.log(LogStatus.INFO, "Hovering over element " + elementName);
            //store the locator into WebElement variable
            WebElement element = driver.findElements(By.xpath(locator)).get(indexNumber);
            mouseMovement.moveToElement(element).perform();
            logger.log(LogStatus.PASS, "Successfully hover over element " + elementName);
        } catch (Exception err) {
            logger.log(LogStatus.INFO, "Unable to hover over element " + elementName);
            getScreenshot(driver, logger, elementName);
        }//end of try catch
    }//end of mouse hover method by index

    //method for mouse hover click
    public static void mouseHoverClick(ExtentTest logger, WebDriver driver, String locator, String elementName) throws IOException {
        Actions mouseMovement = new Actions(driver);
        try {
            logger.log(LogStatus.INFO, "Hovering over and clicking on element " + elementName);
            //store the locator into WebElement variable
            WebElement element = driver.findElement(By.xpath(locator));
            mouseMovement.moveToElement(element).click().perform();
        } catch (Exception err) {
            logger.log(LogStatus.INFO, "Unable to hover over and click on element " + elementName);
            getScreenshot(driver, logger, elementName);
        }//end of try catch
    }//end of mouse hover click method

    //method ro navigating to a page
    public static void navigate(ExtentTest logger, WebDriver driver, String url) throws IOException {
        try {
            //System.out.print("Navigating to " + url);
            logger.log(LogStatus.INFO, "Navigating to " + url);
            driver.navigate().to(url);
        } catch (Exception err) {
            //System.out.println("Unable to navigate to the url... " + err);
            logger.log(LogStatus.FAIL, "Unable to navigate to the url... " + err);
            getScreenshot(driver, logger, "URL Error");
        }
    }//end of navigate method

    //method for clicking on an element
    public static void clickMethod(ExtentTest logger, WebDriver driver, String locator, String elementName) throws IOException {

        try {
            System.out.println("Clicking on element " + elementName);
            logger.log(LogStatus.INFO, "Clicking on element " + elementName);
            //store the locator into WebElement variable
            WebElement clickbtn = driver.findElement(By.xpath(locator));
            clickbtn.click();
            //logger.log(LogStatus.PASS,"Succesfully clicked on the element " + elementName);
        } catch (Exception err) {
            //System.out.println("Unable to click on element " + elementName);
            logger.log(LogStatus.FAIL, "Unable to click on element " + elementName);
            getScreenshot(driver, logger, elementName);
        }//end of try catch
    }//end of click method

    //method for clearing on an element
    public static void clearMethod(ExtentTest logger, WebDriver driver, String locator, String elementName) throws IOException {
        try {
            System.out.println("Clearing on element " + elementName);
            logger.log(LogStatus.INFO, "Clearing on element " + elementName);
            //store the locator into WebElement variable
            WebElement clrBtn = driver.findElement(By.xpath(locator));
            clrBtn.clear();
        } catch (Exception err) {
            logger.log(LogStatus.FAIL, "Unable to clear on element " + elementName + " " + err);
            System.out.println("Unable to clear on element " + elementName + " " + err);
            getScreenshot(driver, logger, elementName);
        }//end of try catch
    }//end of clear method

    //method for clicking on an element by index
    public static void clickMethodByIndex(ExtentTest logger, WebDriver driver, String locator, int indexNumber, String elementName) throws IOException {

        try {
            System.out.println("Clicking on element " + elementName);
            logger.log(LogStatus.INFO, "Clicking on element " + elementName);
            //store the locator into WebElement variable
            WebElement clickbtn = driver.findElements(By.xpath(locator)).get(indexNumber);
            clickbtn.click();
            //logger.log(LogStatus.PASS,"Succesfully clicked on the element " + elementName);
        } catch (Exception err) {
            //System.out.println("Unable to click on element " + elementName);
            logger.log(LogStatus.FAIL, "Unable to click on element " + elementName);
            getScreenshot(driver, logger, elementName);
        }//end of try catch
    }//end of click method//end of click by index method

    //method for submitting on an element
    public static void submitMethod(WebDriver driver, String locator, String elementName) {
        try {
            System.out.println("Submitting  on element " + elementName);
            //store the locator into WebElement variable
            WebElement submitBtn = driver.findElement(By.xpath(locator));
            submitBtn.submit();
        } catch (Exception err) {
            System.out.println("Unable to Submit on element " + elementName + " " + err);
        }//end of try catch
    }//end of submit method

    //method for entering on an element
    public static void sendKeysMethod(ExtentTest logger, WebDriver driver, String locator, String userInput, String elementName) throws IOException {
        try {
            //System.out.println("Entering " + userInput + " in element " + elementName);
            logger.log(LogStatus.INFO, "Entering " + userInput + " in element " + elementName);
            //store the locator into WebElement variable
            WebElement input = driver.findElement(By.xpath(locator));
            input.sendKeys(userInput);
        } catch (Exception err) {
            //System.out.println("Unable to send info on element " + elementName);
            logger.log(LogStatus.FAIL, "Unable to send info on element " + elementName);
            getScreenshot(driver, logger, elementName);


        }//end of try catch
    }//end of Send Keys method

    //dropdown method by visible text
    public static void selectByText(ExtentTest logger, WebDriver driver, String locator, String value, String elementName) throws IOException {
        try {
            System.out.println("Selecting " + value + " from dropdown " + elementName);
            logger.log(LogStatus.INFO, "Selecting " + value + " from dropdown " + elementName);
            //define the Web Element
            WebElement element = driver.findElement(By.xpath(locator));
            //define the select command
            Select select = new Select(element);
            // select by visible text
            select.selectByVisibleText(value);
        } catch (Exception err) {
            System.out.println("Unable to select a value from dropdown " + elementName + " " + err);
            logger.log(LogStatus.FAIL, "Unable to select a value from dropdown " + elementName + " " + err);
            getScreenshot(driver, logger, elementName);
        }//end of try catch
    }//end of select by text method

    //method for getText
    public static String captureText(WebDriver driver, String locator, int indexNumber, String elementName) {
        String textValue = null;
        try {
            System.out.println("Capturing text " + elementName);
            textValue = driver.findElements(By.xpath(locator)).get(indexNumber).getText();
        } catch (Exception err) {
            System.out.println("Unable to capture text " + elementName + " " + err);
        }//end of try catch
        return textValue;
    }//end of capture text method


    public static void getScreenshot(WebDriver driver, ExtentTest logger, String screenshotName) throws IOException {
        // String path = "C:\\Users\\sumon.kashem\\Desktop\\Screenshots\\";
        String path = "src\\main\\java\\Report_Folder\\ScreenShots\\";
        String fileName = screenshotName + ".png";
        File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //Now you can do whatever you need to do with, for example copy somewhere
        FileUtils.copyFile(sourceFile, new File(path + fileName));
        //String imgPath = directory + fileName;
        String image = logger.addScreenCapture("ScreenShots\\" + fileName);
        logger.log(LogStatus.FAIL, "", image);
    }

    public static void checkbox(ExtentTest logger1, WebDriver driver, String locator, String elementName) throws IOException {
        //String elementState = driver.getTitle();
        if (driver.findElement(By.xpath(locator)).isSelected()) {
            logger1.log(LogStatus.PASS, "Element is checked by default");

        } else {
            logger1.log(LogStatus.FAIL, "Element is not checked by default");
            //call the screen shot command
            getScreenshot(driver, logger1, "Check Mark");
        }
    }


}//end of parent class

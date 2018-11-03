package ResuableOjbects;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.istack.internal.NotNull;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Reusable_Methods_Loggers {

    public static void naviagteMethod(ExtentTest logger, WebDriver driver, String url) throws IOException {
        Actions mouseMovement = new Actions(driver);
        try {
            logger.log(LogStatus.INFO, "Navigating to " + url);
            driver.navigate().to(url);
            //WebElement clickBtn = driver.findElement(By.xpath(locator));
            //mouseMovement.moveToElement(clickBtn).click().perform();
        } catch (Exception err) {
            logger.log(LogStatus.FAIL, "Unable to navigate to page by given url " + err);
            getScreenshot(logger, driver, "URL Error");
        }
    }

    public static void clickMethod(ExtentTest logger, WebDriver driver, String locator, String elementName) throws IOException {
        Actions mouseMovement = new Actions(driver);
        try {
            logger.log(LogStatus.INFO, "Clicking on element " + elementName);
            WebElement clickBtn = driver.findElement(By.xpath(locator));
            mouseMovement.moveToElement(clickBtn).click().build().perform();
        } catch (Exception err) {
            logger.log(LogStatus.FAIL, "Unable to click on element " + elementName);
            getScreenshot(logger, driver, "Clicking Error");
        }
    }

    public static void clickMethodByIndex(ExtentTest logger, WebDriver driver, String locator, int indexNumber, String elementName) throws IOException {
        Actions mouseMovement = new Actions(driver);
        try {
            logger.log(LogStatus.INFO, "Clicking on element " + elementName);
            WebElement clickBtn = driver.findElements(By.xpath(locator)).get(indexNumber);
            mouseMovement.moveToElement(clickBtn).click().perform();
        } catch (Exception err) {
            logger.log(LogStatus.FAIL, "Unable to click on element " + elementName);
            getScreenshot(logger, driver, "Clicking Error");
        }
    }

    public static void mouseHover(ExtentTest logger, WebDriver driver, String locator, String elementName) throws IOException {
        Actions mouseMovement = new Actions(driver);
        try {
            logger.log(LogStatus.INFO, "Hovering on element " + elementName);
            WebElement hover = driver.findElement(By.xpath(locator));
            mouseMovement.moveToElement(hover)
                    .build()
                    .perform();
        } catch (Exception err) {
            logger.log(LogStatus.FAIL, "Unable to click on element " + elementName);
            getScreenshot(logger, driver, "Clicking Error");
        }
    }

    public static void mouseHoverByIndex(ExtentTest logger, WebDriver driver, String locator, int indexNumber, String elementName) throws IOException {
        Actions mouseMovement = new Actions(driver);
        try {
            logger.log(LogStatus.INFO, "Hovering on element " + elementName);
            WebElement hover = driver.findElements(By.xpath(locator)).get(indexNumber);
            mouseMovement.moveToElement(hover)
                    .build()
                    .perform();
        } catch (Exception err) {
            logger.log(LogStatus.FAIL, "Unable to click on element " + elementName);
            getScreenshot(logger, driver, "Clicking Error");
        }
    }


    public static void sendMethod(ExtentTest logger, WebDriver driver, String locator, String userInput, String elementName) throws IOException {
        Actions mouseMovement = new Actions(driver);
        try {
            logger.log(LogStatus.INFO, "Sending to " + userInput + " an element " + elementName);
            WebElement sendKey = driver.findElement(By.xpath(locator));
            mouseMovement.moveToElement(sendKey).click().sendKeys(userInput).perform();
        } catch (Exception err) {
            logger.log(LogStatus.FAIL, "Unable to send to element " + elementName);
            getScreenshot(logger, driver, elementName);
        }
    }

    public static void sendMethodByIndex(ExtentTest logger, WebDriver driver, String locator, String userInput, int indexNumber, String elementName) throws IOException {
        Actions mouseMovement = new Actions(driver);
        try {
            logger.log(LogStatus.INFO, "Sending to " + userInput + " an element " + elementName);
            WebElement sendKey = driver.findElements(By.xpath(locator)).get(indexNumber);
            mouseMovement.moveToElement(sendKey).click().sendKeys(userInput).perform();
        } catch (Exception err) {
            logger.log(LogStatus.FAIL, "Unable to send to element " + elementName);
            getScreenshot(logger, driver, elementName);
        }
    }

    public static void clearText(ExtentTest logger, WebDriver driver, String locator, String elementName) throws IOException {
        Actions mouseMovement = new Actions(driver);
        try {
            logger.log(LogStatus.INFO, "Clearing text field of " + elementName);
            WebElement clearTxt = driver
                    .findElement(By.xpath(locator));
            mouseMovement.moveToElement(clearTxt)
                    .doubleClick()
                    .sendKeys(Keys.BACK_SPACE)
                    .perform();
        } catch (Exception err) {
            logger.log(LogStatus.FAIL, "Unable to process request for element " + elementName);
            getScreenshot(logger, driver, elementName);
        }
    }

    public static void clearTextByIndex(ExtentTest logger, WebDriver driver, String locator, int indexNumber, String elementName) throws IOException {
        Actions mouseMovement = new Actions(driver);
        try {
            logger.log(LogStatus.INFO, "Clearing text field of " + elementName);
            WebElement clearTxt = driver
                    .findElements(By.xpath(locator))
                    .get(indexNumber);
            mouseMovement.moveToElement(clearTxt)
                    .doubleClick()
                    .sendKeys(Keys.BACK_SPACE)
                    .perform();
        } catch (Exception err) {
            logger.log(LogStatus.FAIL, "Unable to process request for element " + elementName);
            getScreenshot(logger, driver, elementName);
        }
    }

    public static void matchTitle(ExtentTest logger, WebDriver driver, String expectedTitle, String elementName) throws IOException {
        Actions mouseMovement = new Actions(driver);
        try {
            String title = driver.getTitle();
            if (title.equals(expectedTitle)) {
                logger.log(LogStatus.PASS, "Title matcheed");
            } else {
                logger.log(LogStatus.FAIL, "Title didn't match with " + title);
            }
        } catch (Exception err) {
            logger.log(LogStatus.FAIL, "Unable to process request for element " + elementName);
            getScreenshot(logger, driver, elementName);
        }
    }

    public static void SelectMethod(ExtentTest logger, WebDriver driver, String locator, String userInput, String elementName) throws IOException {
        Actions mouseMovement = new Actions(driver);
        try {
            logger.log(LogStatus.INFO, "Selecting item from the drop down of " + elementName);
            WebElement listItem = driver.findElement(By.xpath(locator));
            Select itemDropdown = new Select(listItem);
            itemDropdown.selectByVisibleText(userInput);
        } catch (Exception err) {
            logger.log(LogStatus.FAIL, "Unable to select from the " + elementName);
            getScreenshot(logger, driver, elementName);
        }
    }

    public static String textSelection(ExtentTest logger, WebDriver driver, String locator, String elementName) {
        Actions mouseMovement = new Actions(driver);
        String text = null;
        try {
            logger.log(LogStatus.INFO, "Captered text is: " + elementName);
            WebElement txtElement = driver.findElement(By.xpath(locator));
            text = txtElement.getText();
            //mouseMovement.moveToElement(txtElement).doubleClick().sendKeys(Keys.CONTROL, "c").perform();
        } catch (Exception err) {
            logger.log(LogStatus.FAIL, "Unable to find the specific text of: " + elementName);
        }
        return text;
    }

    public static String textSelectionWithSplit(ExtentTest logger, WebDriver driver, String locator, String elementName) {
        Actions mouseMovement = new Actions(driver);
        //String text = null;
        String[] arraySearch = null;
        try {
            logger.log(LogStatus.INFO, "Captered text is: " + elementName);
            WebElement txtElement = driver.findElement(By.xpath(locator));
            String text = txtElement.getText();
            arraySearch = text.split("Next");
            logger.log(LogStatus.PASS, "Captered text is: " + arraySearch[1]);
            //mouseMovement.moveToElement(txtElement).doubleClick().sendKeys(Keys.CONTROL, "c").perform();
        } catch (Exception err) {
            logger.log(LogStatus.FAIL, "Unable to find the specific text of: " + elementName);
        }
        return arraySearch[1];
    }

    public static String textSelectionWithIf(ExtentTest logger, WebDriver driver, String locator, String matchingText, String elementName) {
        Actions mouseMovement = new Actions(driver);
        String text = null;
        try {
            logger.log(LogStatus.INFO, "Capturing text is: " + elementName);
            WebElement txtElement = driver.findElement(By.xpath(locator));
            text = txtElement.getText();
            if (text.equalsIgnoreCase(matchingText)) {
                logger.log(LogStatus.PASS, "Captured text Matched with: " + matchingText);
            } else {
                logger.log(LogStatus.FAIL, "Captured text didn't match with: " + matchingText);
            }
        } catch (Exception err) {
            logger.log(LogStatus.FAIL, "Unable to find the specific text of: " + elementName);
        }
        return text;
    }

    public static String textSelectionIndx(ExtentTest logger, WebDriver driver, String locator, int indexNum, String elementName) {
        Actions mouseMovement = new Actions(driver);
        String text = null;
        try {
            logger.log(LogStatus.INFO, "Captered text is: " + elementName);
            WebElement txtElement = driver.findElements(By.xpath(locator)).get(indexNum);
            text = txtElement.getText();
            //mouseMovement.moveToElement(txtElement).doubleClick().sendKeys(Keys.CONTROL, "c").perform();
        } catch (Exception err) {
            logger.log(LogStatus.FAIL, "Unable to find the specific text of: " + elementName);
        }
        return text;
    }

    public static void getScreenshot(ExtentTest logger, WebDriver driver, String screenshotName) throws IOException {
        Actions mouseMovement = new Actions(driver);
        try {
            String path = "src\\main\\java\\Report_Folder\\ScreenShots\\";
            String fileName = screenshotName + ".png";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(path + fileName));
            String image = logger.addScreenCapture("ScreenShots\\" + fileName);
            logger.log(LogStatus.INFO, "Screenshot of the failed stage ", image);
        } catch (Exception err) {
            logger.log(LogStatus.FAIL, "Unable to proceed " + err);
        }
    }

    public static void booleanCheckbox(ExtentTest logger, WebDriver driver, String locator, String elementName) throws IOException {
        if(driver.findElement(By.xpath(locator)).isSelected()) {
            logger.log(LogStatus.PASS,"Element is checked by default " + elementName);
        }else{
            logger.log(LogStatus.FAIL,"Element is not checked by default " + elementName);
            getScreenshot(logger, driver,"Check Mark");
        }
    }
}

package com.bluecrestwellness.utilities;

import com.bluecrestwellness.browserfactory.ManageBrowser;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Utility extends ManageBrowser {
    /**
     * This method will get text from element
     */
    public String getTextFromElement(WebElement element) {
        return element.getText();
    }

    public String getTextFromElementWithGetAttribute(WebElement element) {
        return element.getAttribute("innerHTML");
    }

    /**
     * This method will send text on element
     */
    public void sendTextToElement(WebElement element, String text) {
        element.sendKeys(text);
    }

    /**
     * This method will click on element
     */
    public void clickOnElement(WebElement element) {
        element.click();
    }

    //get screenshot
    public static byte[] getScreenShot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    /**
     * This method will use to wait until  VisibilityOfElementLocated
     */

    public List<WebElement> waitUntilVisibilityOfElementLocated(List<WebElement> elements, int time){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public WebElement waitUntilVisibilityOfElementLocated(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
      public WebElement waitUntilElementIsClickable(WebElement element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }



}

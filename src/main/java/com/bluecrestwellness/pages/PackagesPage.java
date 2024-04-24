package com.bluecrestwellness.pages;

import com.bluecrestwellness.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PackagesPage extends Utility {

    @CacheLookup
    @FindBy(id = "onetrust-accept-btn-handler")
    WebElement consentOKButton;
    @CacheLookup
    @FindBy(xpath = "//button[@title='Close']")
    WebElement closePopUp;

    @CacheLookup
    @FindBy(xpath = "(//div[@class='packages-block_packagesList__cl01q '])[1]")
    WebElement healthMOT;


    @CacheLookup
    @FindBy(xpath = "//div[@class='packages-block_packageWrapper__65GKj']//h3")
    List<WebElement> packageHeadings;

    @CacheLookup
    @FindBy(xpath = "//button/span[text()='Book now']")
    List<WebElement> bookNowButtons;

    @CacheLookup
    @FindBy(xpath = "(//button/span[text()='Book now'])[1]")
    WebElement bookNowButtonForActive;


    public void acceptConsent() {
        clickOnElement(consentOKButton);
    }
    public void closePopUp() {
        clickOnElement(closePopUp);
    }

    public void clickOnBookNow(String packageName) {

        int count = 0;
        for (WebElement heading : packageHeadings) {
            count++;
            String headingText = getTextFromElementWithGetAttribute(heading);
            if (headingText.equalsIgnoreCase(packageName)) {
                clickOnElement(bookNowButtons.get(count));
                break;
            }
        }
    }

}

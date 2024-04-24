package com.bluecrestwellness.pages;

import com.bluecrestwellness.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class OrderSummaryPage extends Utility {
    @CacheLookup
    @FindBy (id="checkoutContinueButton")
    WebElement continueButton;

    @CacheLookup
    @FindBy(xpath = "//h1")
    WebElement pageHeading;


    public void clickContinue(){
        clickOnElement(continueButton);
    }

    public String getPageHeading(){
        return pageHeading.getText();
    }

}

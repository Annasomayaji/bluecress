package com.bluecrestwellness.pages;

import com.bluecrestwellness.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VenuePage extends Utility {
    @CacheLookup
    @FindBy(id = "address-search")
    WebElement searchTextBox;

    @CacheLookup
    @FindBy(id = "address-search-btn")
    WebElement searchButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='venue-location-div d-block']")
    WebElement venueList;

    @CacheLookup
    @FindBy(xpath = "//h2[@role='label']")
    List<WebElement> clinics;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@class,'venue-available-days-list collapse show')]//button")
    List<WebElement> dates;

//    @CacheLookup
//    @FindBy(xpath = "//div[@id='venue-1384-appointments']//div[@class='available custom-button-color']")
//    List<WebElement> times;

    @CacheLookup
    @FindBy(xpath = "//div[@class='available custom-button-color']")
    List<WebElement> times;
    @CacheLookup
    @FindBy(xpath = "//div[contains(@class,'venue-button-holder') and contains(@class,'show') ]//button")
    WebElement confirmButton;


    public void searchLocation(String location) {
        sendTextToElement(searchTextBox, location);

    }

    public void clickOnSearchButton() {

        clickOnElement(searchButton);
        waitUntilVisibilityOfElementLocated(venueList, 20);
    }

    public void selectLocation(String location) {

        for (WebElement c : clinics) {
            String locationText = getTextFromElementWithGetAttribute(c);
            if (locationText.equalsIgnoreCase(location)) {
                clickOnElement(c);
                break;
            }

        }
    }

    public void selectDate(String date) {
        for (WebElement d : dates) {
            System.out.println("date: " + d.getAttribute("data-link_label"));
            if (d.getAttribute("data-link_label").equals(date)) {
                d.click();
                break;
            }
        }
    }

    public void selectTime(String time) {
        waitUntilVisibilityOfElementLocated(times, 10);
                  for (WebElement t : times) {
                System.out.println("Time: " + t.getAttribute("innerHTML"));

                if (t.getAttribute("innerHTML").contains(time)) {
                    waitUntilElementIsClickable(t, 20);
                    t.click();
                    break;
                }
            }
    }

    public void confirm() {
        clickOnElement(confirmButton);
    }
}

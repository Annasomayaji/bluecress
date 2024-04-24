package com.bluecrestwellness.pages;

import com.bluecrestwellness.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class PersonalDetailsPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//h1")
    WebElement pageHeading;


    public String getPageHeading() {

        try {
            return pageHeading.getText();
        } catch (Exception e) {
            driver.findElement(By.xpath("//h1"));
            return pageHeading.getText();
        }
    }
}

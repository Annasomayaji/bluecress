package com.bluecrestwellness.steps;

import com.bluecrestwellness.browserfactory.ManageBrowser;
import com.bluecrestwellness.pages.OrderSummaryPage;
import com.bluecrestwellness.pages.PackagesPage;
import com.bluecrestwellness.pages.PersonalDetailsPage;
import com.bluecrestwellness.pages.VenuePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.util.List;

public class BookPackageSteps {

    private static final Logger log = LogManager.getLogger(ManageBrowser.class);
    PackagesPage packagesPage = new PackagesPage();
    VenuePage venuePage = new VenuePage();
    OrderSummaryPage orderSummaryPage = new OrderSummaryPage();

    PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();

    @Given("I navigated to the packages page")
    public void iNavigatedToThePackagesPage() {

    }

    @When("I select the {string} package")
    public void iSelectThePackage(String packageName) {

        packagesPage.acceptConsent();
        packagesPage.closePopUp();
        log.info("Accepting Consent....");

        //This will loop through all the packages and select 'Active' package
        packagesPage.clickOnBookNow(packageName);
        log.info("Clicking on 'Book now'....");

        //This will click on Active package only
        // packagesPage.clickOnActivePackage();

    }

    @And("I enter {string}, {string}, {string}, {string}")
    public void iEnter(String location, String clinic, String date, String time) {
        venuePage.searchLocation(location);
        log.info("Entering search term....");
        venuePage.clickOnSearchButton();
        log.info("Clicking search button....");
        venuePage.selectLocation(clinic);
        log.info("Selecting a clinic....");
        venuePage.selectDate(date);
        log.info("Selecting a date....");
        venuePage.selectTime(time);
        log.info("Selecting a time....");
    }

    @And("I confirm Order Summary")
    public void iConfirmOrderSummary() {
        venuePage.confirm();
        log.info("Confirming selections....");
    }


    @Then("I should be navigated to {string} page")
    public void iShouldBeNavigatedToPage(String pageHeading) {
        Assert.assertEquals(orderSummaryPage.getPageHeading(), pageHeading, "The user is not navigated to the correct page.");
        orderSummaryPage.clickContinue();
        log.info("Continuing....");

    }


    @And("navigate to {string} section")
    public void navigateToSection(String pageHeading) {
        Assert.assertEquals(personalDetailsPage.getPageHeading(), pageHeading, "The user is not navigated to the correct page");
    }


    @And("I enter the following details")
    public void iEnterTheFollowingDetails(DataTable dataTable) {
        List<List<String>> packageDetails = dataTable.asLists(String.class);
        for (List<String> details : packageDetails) {
            String location = details.get(0);
            String clinic = details.get(1);
            String date = details.get(2);
            String time = details.get(3);
            venuePage.searchLocation(location);
            log.info("Entering search term....");
            venuePage.clickOnSearchButton();
            log.info("Clicking search button....");
            venuePage.selectLocation(clinic);
            log.info("Selecting a clinic....");
            venuePage.selectDate(date);
            log.info("Selecting a date....");
            venuePage.selectTime(time);
            log.info("Selecting a time....");
        }
    }
}

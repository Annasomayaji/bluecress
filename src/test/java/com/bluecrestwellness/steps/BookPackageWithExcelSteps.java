package com.bluecrestwellness.steps;

import com.bluecrestwellness.browserfactory.ManageBrowser;
import com.bluecrestwellness.excelutility.ExcelReader;
import com.bluecrestwellness.pages.PackagesPage;
import com.bluecrestwellness.pages.VenuePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BookPackageWithExcelSteps {
    private static final Logger log = LogManager.getLogger(ManageBrowser.class);
    PackagesPage packagesPage = new PackagesPage();
    VenuePage venuePage = new VenuePage();

    @When("I select the package from given sheet name {string} and row number {string} with data in excel at {string}")
    public void iSelectThePackageFromGivenSheetNameAndRowNumberWithDataInExcelAt(String sheetName, String rowNumber, String filePath) throws IOException {
        packagesPage.acceptConsent();
        packagesPage.closePopUp();
        log.info("Accepting Consent....");
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testdata = reader.getData(filePath, sheetName);
        String packageName = testdata.get(Integer.parseInt(rowNumber)).get("package");
        packagesPage.clickOnBookNow(packageName);
        log.info("Clicking on 'Book now'....");
    }

    @And("I enter appointment details from sheet name {string} and row number {string} with data in excel at {string}")
    public void iEnterAppointmentDetailsFromSheetNameAndRowNumberWithDataInExcelAt(String sheetName, String rowNumber, String filePath) throws IOException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testdata = reader.getData(filePath, sheetName);
        String location = testdata.get(Integer.parseInt(rowNumber)).get("location");
        String clinic = testdata.get(Integer.parseInt(rowNumber)).get("clinic");
        String date = testdata.get(Integer.parseInt(rowNumber)).get("date");
        String time = testdata.get(Integer.parseInt(rowNumber)).get("time");
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

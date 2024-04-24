package com.bluecrestwellness.steps;

import com.bluecrestwellness.propertyreader.PropertyReader;
import com.bluecrestwellness.runners.RunCukeTest;
import com.bluecrestwellness.utilities.Utility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends Utility {

    String browser = PropertyReader.getInstance().getProperty("browser");

    /**
    This is run before each test scenario
         */
    @Before
    public void setUp() {
        browser = RunCukeTest.BROWSER.get();
        selectBrowser(browser);
    }

    /**
     * This is run after each test scenario
     * @param scenario
     */
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = getScreenShot();
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        closeBrowser();
    }
}

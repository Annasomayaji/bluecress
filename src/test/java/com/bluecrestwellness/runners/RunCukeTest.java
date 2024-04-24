package com.bluecrestwellness.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/bluecrestwellness/steps",
        tags = "@regression",
        monochrome = true,
        plugin = {
                "html:target/cucumber-reports/cucumber.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:target/cucumber-reports/cucumber.json"}

)

public class RunCukeTest extends AbstractTestNGCucumberTests {
    public final static ThreadLocal<String> BROWSER =new ThreadLocal<>();

    @BeforeMethod
    @Parameters({"browser"})
    public void defineBrowser(@Optional ("chrome") String browser){
        RunCukeTest.BROWSER.set(browser);
    }

}



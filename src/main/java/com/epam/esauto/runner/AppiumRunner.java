package com.epam.esauto.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "json:out/cucumber.json", "html:out/cucumber.html"},
        features = "src/test/resources/mobile_features/", glue = "com/epam/esauto/steps/mobile/",
        tags = "@lol",
        plugin = {"com.epam.reportportal.cucumber.StepReporter", "com.github.kirlionik.cucumberallure.AllureReporter"})
public class AppiumRunner {
}

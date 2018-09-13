package com.epam.esauto.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "json:out/cucumber.json", "html:out/cucumber.html"},
        features = "src/test/resources/features/mobile_features/", glue = "com/epam/esauto/steps/mobile/",
        plugin = {"com.epam.reportportal.cucumber.StepReporter", "com.epam.reportportal.cucumber.ScenarioReporter"})
public class AppiumRunner {
}

package com.epam.esauto.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "json:out/cucumber.json", "html:out/cucumber.html"},
        features = "src/test/resources/web_features/", glue = "com/epam/esauto/steps/",
        plugin = {"com.epam.reportportal.cucumber.StepReporter", "com.github.kirlionik.cucumberallure.AllureReporter"})
public class CucumberRunner {
}

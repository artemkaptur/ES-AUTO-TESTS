package com.epam.esauto.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "json:out/cucumber.json","html:out/cucumber.html"},
        features = "src/test/resources/features/", glue = "com/epam/esauto/steps/")
public class CucumberRunner {

}

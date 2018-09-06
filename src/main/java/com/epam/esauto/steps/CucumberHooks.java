package com.epam.esauto.steps;

import com.codeborne.selenide.Screenshots;
import com.epam.reportportal.message.ReportPortalMessage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class CucumberHooks {

    private static Logger logger = LogManager.getLogger();

    @After
    public void afterScenario(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            ReportPortalMessage screenshot = new ReportPortalMessage(Screenshots.getLastScreenshot(), "Screenshot");
            ReportPortalMessage pageSource = new ReportPortalMessage(new File(Screenshots.getLastScreenshot().getAbsolutePath().replace(".png", ".html")), "Page source");
            logger.log(Level.ERROR, screenshot);
            logger.log(Level.ERROR, pageSource);
        }
    }
}

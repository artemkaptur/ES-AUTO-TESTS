package com.epam.esauto.runner;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class WebDriverRunnerConfig {

    private static WebDriver driver;

    @Value("${grid.browserName}")
    private String browserName;

    @Value("${grid.browserVersion}")
    private String browserVersion;

    @Value("${grid.hubUrl}")
    private String hubUrl;

    @Value("${grid.remoteDriverEnabled}")
    private Boolean remoteDriverEnabled;

    @PostConstruct
    public void setUp() throws MalformedURLException {
        if (remoteDriverEnabled) {
            DesiredCapabilities capabilities = new DesiredCapabilities(browserName, browserVersion, Platform.ANY);
            capabilities.setBrowserName(browserName);

            driver = new RemoteWebDriver(new URL(hubUrl), capabilities);
            driver.manage().window().maximize();
            WebDriverRunner.setWebDriver(driver);
        }
    }
}

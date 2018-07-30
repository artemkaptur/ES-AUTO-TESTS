package com.epam.esauto.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.github.bonigarcia.wdm.WebDriverManager;

@Component
public class DriverFactory implements IDriverFactory {

    @Value("${browser}")
    private String browserName;

    public WebDriver createDriver() {
        switch (browserName.toUpperCase()) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized");
                return new ChromeDriver(options);
            case "FIREFOX":
                return new FirefoxDriver();
            case "IE":
                return new InternetExplorerDriver();
            default:
                throw new IllegalStateException("Invalid browser name: " + browserName);
        }
    }
}

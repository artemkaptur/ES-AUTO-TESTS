package com.epam.esauto.steps.mobile;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.epam.esauto.spring.AppConfig;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static io.appium.java_client.remote.MobileCapabilityType.*;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

@ContextConfiguration(classes = AppConfig.class)
public class MobileMainSteps {

    @Value("${appium.hubUrl}")
    private String hubUrl;

    @Value("${london.downloadUrl}")
    private String appUrl;

    @Value("${android.platform.name}")
    private String androidPlatformName;

    @Value("${device.name}")
    private String deviceName;

    @Value("${appium.app.package}")
    private String appPackage;

    @Value("${appium.app.activity}")
    private String appActivity;

    @Value("${london.closeSlideshowButton.id}")
    private String closeSlideshowButtonId;

    @Value("${london.mainLogo.xpath}")
    private String londonMainLogoXpath;

    @Value("${london.horizontalScrollView.id}")
    private String londonSubsectionsScrollViewId;

    @When("^I launch Standard app$")
    public void iLaunchStandardApp() throws MalformedURLException {
        var capabilities = new DesiredCapabilities();
        capabilities.setCapability(PLATFORM_NAME, androidPlatformName);
        capabilities.setCapability(DEVICE_NAME, deviceName);
        capabilities.setCapability(APP, appUrl);
        capabilities.setCapability(APP_PACKAGE, appPackage);
        capabilities.setCapability(APP_ACTIVITY, appActivity);

        var driver = new AndroidDriver(new URL(hubUrl), capabilities);
        WebDriverRunner.setWebDriver(driver);
    }

    @When("^I close intro slideshow$")
    public void iCloseIntroSlideshow() {
        $(By.id(closeSlideshowButtonId)).click();
    }

    @Then("^I see all news subsections on app screen$")
    public void iSeeAllNewsSubsectionsOnAppScreen() {
        $(By.id(londonSubsectionsScrollViewId)).shouldBe(Condition.visible);
    }
}

package com.epam.esauto.steps.mobile;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.epam.esauto.spring.AppConfig;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_ACTIVITY;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.APP_PACKAGE;
import static java.lang.String.format;
import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;

@ContextConfiguration(classes = AppConfig.class)
public class MobileMainSteps {

    private static final long INSTALL_WAIT = 60000;
    private static final long MOBILE_LOAD_ACTIVITY_WAIT = 20000;
    private static final String PLATFORM_VERSION = "platformVersion";
    private static final String ES_APP_NAME = "Evening Standard";

    @Value("${epam.project.name}")
    private String epamProjectName;

    @Value("${epam.appium.hub}")
    private String epamAppiumHub;

    @Value("${epam.appium.api.key}")
    private String epamAppiumApiKey;

    @Value("${android.platform.name}")
    private String androidPlatformName;

    @Value("${android.platform.version}")
    private String androidVersion;

    @Value("${android.playMarket.appPackage}")
    private String playMarketPackage;

    @Value("${android.playMarket.appActivity}")
    private String playMarketActivity;

    @Value("${android.playMarket.searchIdleInput.id}")
    private String playMarketSearchIdleInputId;

    @Value("${android.playmarket.searchInput.id}")
    private String playMarketSearchInputId;

    @Value("${android.playmarket.searchResEveningStandardApp.xpath}")
    private String playMarketESAppXpath;

    @Value("${android.playmarket.installButton.xpath}")
    private String playMarketInstallButtonXpath;

    @Value("${android.playmarket.openButton.xpath}")
    private String playMarketOpenButtonXpath;

    @Value("${android.playmarket.navigationButton.xpath}")
    private String playMarketNavigationButtonXpath;

    @Value("${android.playmarket.myapps.xpath}")
    private String playMarketMyappsXpath;

    @Value("${android.playmarket.installedApps.xpath}")
    private String playMarketInstalledAppsXpath;

    @Value("${london.closeSlideshowButton.id}")
    private String closeSlideshowButtonId;

    @Value("${london.mainLogo.xpath}")
    private String londonMainLogoXpath;

    @Value("${london.horizontalScrollView.id}")
    private String londonSubsectionsScrollViewId;

    @When("^I install Standard app on mobile device$")
    public void iInstallStandardAppOnDevice() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(PLATFORM_NAME, androidPlatformName);
        capabilities.setCapability(PLATFORM_VERSION, androidVersion);
        capabilities.setCapability(APP_PACKAGE, playMarketPackage);
        capabilities.setCapability(APP_ACTIVITY, playMarketActivity);

        AndroidDriver driver = new AndroidDriver(
                new URL(format("http://%s:%s@%s/wd/hub", epamProjectName, epamAppiumApiKey, epamAppiumHub)), capabilities);
        WebDriverRunner.setWebDriver(driver);

        $(By.id(playMarketSearchIdleInputId)).waitUntil(Condition.visible, MOBILE_LOAD_ACTIVITY_WAIT).click();
        $(By.id(playMarketSearchInputId)).setValue(ES_APP_NAME);
        ((AndroidDriver) WebDriverRunner.getWebDriver()).pressKey(new KeyEvent(AndroidKey.ENTER));
        $(By.xpath(playMarketESAppXpath)).click();
        $(By.xpath(playMarketInstallButtonXpath)).waitUntil(Condition.visible, MOBILE_LOAD_ACTIVITY_WAIT).click();
        $(By.xpath(playMarketOpenButtonXpath)).waitUntil(Condition.visible, INSTALL_WAIT).click();
        $(By.id(closeSlideshowButtonId)).waitUntil(Condition.visible, MOBILE_LOAD_ACTIVITY_WAIT).click();
        $(By.id(londonSubsectionsScrollViewId)).shouldBe(Condition.visible);
        driver.closeApp();
    }

    @And("^I launch Standard app$")
    public void iLaunchStandardApp() {
        Activity activity = new Activity(playMarketPackage, playMarketActivity);
        ((AndroidDriver) WebDriverRunner.getWebDriver()).startActivity(activity);
        $(By.xpath(playMarketNavigationButtonXpath)).waitUntil(Condition.visible, MOBILE_LOAD_ACTIVITY_WAIT).click();
        $(By.xpath(playMarketMyappsXpath)).waitUntil(Condition.visible, MOBILE_LOAD_ACTIVITY_WAIT).click();
        $(By.xpath(playMarketInstalledAppsXpath)).waitUntil(Condition.visible, MOBILE_LOAD_ACTIVITY_WAIT).click();
        $(By.xpath(playMarketESAppXpath)).waitUntil(Condition.visible, MOBILE_LOAD_ACTIVITY_WAIT).click();
        $(By.xpath(playMarketOpenButtonXpath)).shouldBe(Condition.visible).click();
    }

    @Then("^I see all news subsections on app screen$")
    public void iSeeAllNewsSubsectionsOnAppScreen() {
        $(By.id(londonSubsectionsScrollViewId)).shouldBe(Condition.visible);
    }
}

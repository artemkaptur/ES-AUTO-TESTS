package com.epam.esauto.steps;

import com.codeborne.selenide.Condition;
import com.epam.esauto.spring.AppConfig;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@ContextConfiguration(classes = AppConfig.class)
public class MainPageSteps {

    @Value("${mainPage.url}")
    private String mainPageUrl;

    @Value("${mainPage.logo.xpath}")
    private String mainPageLogoXpath;

    @Given("^I open the main page$")
    public void iOpenTheMainPage() {
        open(mainPageUrl);
    }

    @Then("^main logo is displayed$")
    public void mainLogoIsDisplayed() {
        $(By.xpath(mainPageLogoXpath)).shouldBe(Condition.visible);
    }
}
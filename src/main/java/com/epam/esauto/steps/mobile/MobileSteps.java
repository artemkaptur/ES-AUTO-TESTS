package com.epam.esauto.steps.mobile;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Value;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MobileSteps {

    private final int CUSTOM_WAIT = 20000;

    @Value("${download.read.button.xpath}")
    private String downloadReadButtonClassName;

    @Value("${live.button.xpath}")
    private String liveButtonXpath;

    @Given("^open Editions section$")
    public void openSection() {
        $(byText("EDITIONS")).click();
    }

    @And("^download edition$")
    public void downloadEdition() {
        $(By.className(downloadReadButtonClassName)).click();
        $(byText("DOWNLOADING")).waitWhile(Condition.disappear, CUSTOM_WAIT);
        SelenideElement element = $(byText("PROCESSING"));
        if (element.is(Condition.visible)) {
            element.waitWhile(Condition.disappear, CUSTOM_WAIT);
        }

    }

    @When("^I click Live button$")
    public void iClickButton() {
        $(By.xpath(liveButtonXpath)).click();
    }

    @Then("^I go to Latest News section$")
    public void iGoToSection() {
        $(byText("NEWS")).shouldBe(Condition.visible);
        $(byText("SHOWBIZ")).shouldBe(Condition.visible);
        $(byText("FOOTBALL")).shouldBe(Condition.visible);
    }
}

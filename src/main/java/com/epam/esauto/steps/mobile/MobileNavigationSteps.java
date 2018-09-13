package com.epam.esauto.steps.mobile;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Value;

public class MobileNavigationSteps {

    private static final int TRIPLE_DEFAULT_TIMEOUT = 12000;

    @Value("${mainMenu.sections.xpath.withoutText}")
    private String mainMenuSections;

    @Value("${latestNews.section.downloadingText.xpath}")
    private String latestNewsSectionDownloadingText;

    @When("^I open section \"([^\"]*)\"$")
    public void iOpenSection(String section) {
        $(By.xpath(String.format(mainMenuSections, section, ""))).waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT).click();
    }

    @Then("^I am in this section \"([^\"]*)\"$")
    public void iAmInThisSection(String section) {
        if (section.equals("LATEST NEWS")) {
            $(By.xpath(latestNewsSectionDownloadingText)).shouldBe(visible);
        } else {

            $(By.xpath(String.format(mainMenuSections, section, "/.."))).shouldBe(selected);
        }
    }
}

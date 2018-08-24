package com.epam.esauto.steps.header_footer;

import com.codeborne.selenide.Condition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Value;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.epam.esauto.steps.header_footer.StepUtils.*;

public class FooterSteps {

    @Value("${mainPage.url}")
    private String mainPageUrl;

    @Value("${mainPage.logo.xpath}")
    private String mainPageLogoXpath;

    @Value("${hp.footer.logo.xpath}")
    private String hpFooterLogoXpath;

    @Value("${mainPage.logo.footer.xpath}")
    private String mainPageFooterLogoXpath;

    @Value("${mainPage.footer.link.xpath}")
    private String footerLinkXpath;

    @Value("${mainPage.footer.socialButton.xpath}")
    private String socialBtnXpath;

    @When("^I click main footer logo$")
    public void iClickMainFooterLogo() {
        $(By.xpath(mainPageFooterLogoXpath)).click();
    }

    @Then("^page with url \"([^\"]*)\" should be open$")
    public void pageWithShouldBeOpen(String url) {
        var errorMessage = String.format("Page with url %s has not opened", url);
        Assert.assertEquals(errorMessage, getFullUrl(mainPageUrl, url), url());
    }

    @Then("^main page should be open$")
    public void mainPageShouldBeOpen() throws Throwable {
        pageWithShouldBeOpen(mainPageUrl);
    }

    @Then("^footer should have social button \"([^\"]*)\"$")
    public void footerShouldHaveSocialButton(String socialButtonName) {
        $$(By.xpath(socialBtnXpath))
                .find(Condition.attribute(ATTRIBUTE_CLASS, "icon-" + socialButtonName))
                .shouldBe(visible);
    }

    @Then("^footer link with text \"([^\"]*)\" should have valid href \"([^\"]*)\"$")
    public void footerLinkWithTextShouldHaveValidHref(String text, String href) {
        $$(By.xpath(footerLinkXpath)).find(text(text))
                .shouldHave(attribute(ATTRIBUTE_HREF, getFullUrl(mainPageUrl, href)));
    }

    @When("^I click footer link with text \"([^\"]*)\"$")
    public void iClickFooterLinkWithText(String text) {
        $$(By.xpath(footerLinkXpath)).find(text(text)).click();
    }

    @And("^social button \"([^\"]*)\" should have valid href \"([^\"]*)\"$")
    public void socialButtonShouldHaveValidHref(String socialButtonName, String href) {
        $$(By.xpath(socialBtnXpath))
                .find(Condition.attribute(ATTRIBUTE_CLASS, "icon-" + socialButtonName))
                .shouldHave(attribute(ATTRIBUTE_HREF, href));
    }

    @When("^I click H&P footer logo$")
    public void iClickHPFooterLogo() {
        $(By.xpath(hpFooterLogoXpath)).click();
    }
}

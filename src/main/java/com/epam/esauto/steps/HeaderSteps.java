package com.epam.esauto.steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.tuple.Pair;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.epam.esauto.steps.StepUtils.*;
import static org.junit.Assert.assertEquals;

public class HeaderSteps {

    @Value("${mainPage.url}")
    private String mainPageUrl;

    @Value("${mainPage.logo.xpath}")
    private String mainLogoXpath;

    @Value("${mainLogo.hp.xpath}")
    private String mainLogoHPXpath;

    @Value("${mainLogo.goLondon.xpath}")
    private String mainLogoGoLondonXpath;

    @Value("${hp.logo.xpath}")
    private String hpLogoXpath;

    @Value("${mainPage.search.btn.xpath}")
    private String searchButtonXpath;

    @Value("${mainPage.search.field.xpath}")
    private String searchFieldXpath;

    @Value("${mainPage.search.xpath}")
    private String searchXpath;

    @Value("${searchResults.xpath}")
    private String searchResultXpath;

    @Value("${mainPage.toggleMenu.btn.xpath}")
    private String toggleMenuButtonXpath;

    @Value("${mainPage.fullMenu.xpath}")
    private String fullMenuXpath;

    @Value("${mainPage.profile.btn.xpath}")
    private String profileButtonXpath;

    @Value("${mainPage.esMagazineSection.xpath}")
    private String esMagazineSectionXpath;

    @Value("${mainPage.profileMenu.xpath}")
    private String profileToggleMenuXpath;

    @Value("${searchResults.Google.logo.xpath}")
    private String searchResultsGoogleLogoXpath;

    @Value("${searchResults.Google.logo.href}")
    private String googleLogoHref;

    @Value("${searchResults.container.xpath}")
    private String searchResultsContainerXpath;

    @Value("${mainPage.menuItem.xpath}")
    private String menuItemXpath;

    @When("^I click main logo$")
    public void clickMainLogo() throws Throwable {
        $(By.xpath(mainLogoXpath)).click();
    }

    @When("^I click homes&property logo$")
    public void iClickHomesPropertyLogo() throws Throwable {
        $(By.xpath(hpLogoXpath)).click();
    }

    @When("^I search \"([^\"]*)\"$")
    public void iSearch(String word) throws Throwable {
        $(By.xpath(searchButtonXpath)).click();
        $(By.xpath(searchFieldXpath)).sendKeys(word);
        $(By.xpath(searchXpath)).click();
    }

    @When("^I click on Toggle Menu Button$")
    public void iClickOnToggleMenuButton() throws Throwable {
        $(By.xpath(toggleMenuButtonXpath)).click();
    }

    @Then("^profile toggle menu should be visible$")
    public void profileToggleMenuShouldBeVisible() throws Throwable {
        $(By.xpath(profileToggleMenuXpath)).shouldBe(visible);
    }

    @And("^under search results should be visible Google logo$")
    public void underSearchResultsShouldBeVisibleGoogleLogo() throws Throwable {
        $(By.xpath(searchResultsGoogleLogoXpath)).shouldBe(visible);
    }

    @Then("^I see search results related to word \"([^\"]*)\"$")
    public void iSeeResultsRelatedTo(String word) throws Throwable {
        $$(By.xpath(searchResultsContainerXpath)).shouldBe(CollectionCondition.sizeGreaterThan(0))
                .findBy(Condition.attribute("b", word));
    }

    @And("^Google logo in search results should have valid href$")
    public void googleLogoInSearchResultsShouldHaveValidHref() throws Throwable {
        $(By.xpath(searchResultsGoogleLogoXpath))
                .shouldHave(attribute(ATTRIBUTE_HREF, googleLogoHref));
    }

    @Then("^full menu should be visible$")
    public void fullMenuShouldBeVisible() throws Throwable {
        $(By.xpath(fullMenuXpath)).shouldBe(visible);
    }

    @When("^I click on Toggle Search Button$")
    public void iClickOnToggleSearchButton() throws Throwable {
        $(By.xpath(searchButtonXpath)).click();
    }

    @Then("^search field should be visible$")
    public void searchFieldShouldBeVisible() throws Throwable {
        $(By.xpath(searchFieldXpath)).shouldBe(visible);
    }

    @When("^I click on Profile Button$")
    public void iClickOnProfileButton() throws Throwable {
        $(By.xpath(profileButtonXpath)).click();
    }

    @Given("^I open url \"([^\"]*)\"$")
    public void iOpenUrl(String url) throws Throwable {
        open(getFullUrl(mainPageUrl, url));
    }

    @When("^I click main logo at GOLondon section$")
    public void iClickMainLogoAtGOLondonSection() throws Throwable {
        $(By.xpath(mainLogoGoLondonXpath)).click();
    }

    @When("^I click main logo at H&P section$")
    public void iClickMainLogoAtHPSection() throws Throwable {
        $(By.xpath(mainLogoHPXpath)).click();
    }

    @Then("^main menu item number \"([^\"]*)\" \"([^\"]*)\" contains list of sub-menus and they have valid href$")
    public void mainMenuItemNumberContainsListOfSubMenusAndTheyHaveValidHref(String menuNumber, String menuItem, Map<String, String> subMenus) throws Throwable {
        Map<String, String> subMenuInfo = $(By.xpath(String.format(
                "//nav[@class='main-menu']//a[@title='%s']", menuItem)))
                .hover()
                .$$(By.xpath(String.format("//nav[@class='main-menu']/ul/li[%s]/ul/li/div/a", menuNumber)))
                .stream()
                .map(el -> Pair.of(el.getAttribute(ATTRIBUTE_TITLE), el.getAttribute(ATTRIBUTE_HREF).replace(mainPageUrl, "")))
                .collect(Collectors.toMap(Pair::getKey, Pair::getValue));
        assertEquals(subMenus, subMenuInfo);
    }

    @Then("^ESMagazine section should have valid href \"([^\"]*)\"$")
    public void esmagazineSectionShouldHaveValidHref(String href) throws Throwable {
        $(By.xpath(esMagazineSectionXpath))
                .shouldHave(attribute(ATTRIBUTE_HREF, mainPageUrl + href));
    }
}

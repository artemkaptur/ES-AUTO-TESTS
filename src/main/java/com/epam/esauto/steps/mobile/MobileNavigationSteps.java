package com.epam.esauto.steps.mobile;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Value;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MobileNavigationSteps {

	private static final long MOBILE_LOAD_ACTIVITY_WAIT = 60000;

	@Value("${sectionLinks.xpath}")
	private String sectionLinks;

	@Value("${documentActionButton.id}")
	private String documentActionButton;

	@Value("${buttonHome.xpath}")
	private String buttonHome;

	@Value("${menuOfMagazine.xpath}")
	private String menuOfMagazine;

	@Value("${buttonRead.xpath}")
	private String buttonRead;

	@Value("${magazineNavigationButton.xpath}")
	private String magazineNavigationXpath;

	@When("^I open section \"([^\"]*)\"$")
	public void iOpenSection(String section) {
		$$(By.xpath(sectionLinks)).find(Condition.text(section)).click();
	}

	@Then("^button \"([^\"]*)\" should be visible$")
	public void buttonShouldBeVisible(String nameOfButton) {
		$(By.id(documentActionButton)).shouldBe(Condition.visible).shouldHave(Condition.text(nameOfButton));
	}

	@When("^click button \"([^\"]*)\"$")
	public void clickButtonDownload(String nameOfButton) {
		$(By.id(documentActionButton)).shouldHave(Condition.text(nameOfButton)).click();
	}

	@Then("^I see label \"([^\"]*)\"$")
	public void iSeeLabelDownloading(String nameOfButton) {
		$(By.id(documentActionButton)).shouldHave(Condition.text(nameOfButton));
	}

	@And("^I click button \"([^\"]*)\"$")
	public void iClickButtonCancel(String nameOfButton) {
		$$(By.id(documentActionButton)).find(Condition.text(nameOfButton)).click();
	}

	@Then("^I not see label \"([^\"]*)\"$")
	public void iNotSeeLabelDownloading(String nameOfButton) {
		$(By.id(documentActionButton)).shouldNotHave(Condition.text(nameOfButton));
	}

	@Then("^I can open list of all pages after opening magazine$")
	public void iCanSeeListOfAllPages() {
		$(By.xpath(magazineNavigationXpath)).waitUntil(Condition.visible, MOBILE_LOAD_ACTIVITY_WAIT).click();
		$(By.xpath(menuOfMagazine))
				.waitUntil(Condition.appear, MOBILE_LOAD_ACTIVITY_WAIT);
	}

	@Then("^I click button 'home'$")
	public void iClickButtonHome() {
		$(By.xpath(buttonHome)).click();
	}

	@Then("^I see read button$")
	public void iSeeButton() {
		$(By.xpath(buttonRead)).shouldBe(Condition.visible);
	}

}

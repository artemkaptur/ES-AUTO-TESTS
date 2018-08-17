package com.epam.esauto.steps.content;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Value;

import com.codeborne.selenide.Condition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomesAndPropertyPageSteps {

	private static final String ATTRIBUTE_ARIA_SELECTED = "aria-selected";
	private static final String COMMA = ",";

	@Value("${mainPage.sectionHome&Property.xpath}")
	private String sectionHomeAndProperty;

	@Value("${home&PropertyPage.propertyOfTabForSale.xpath}")
	private String propertyOfTabForSale;

	@Value("${home&PropertyPage.propertyOfTabToRent.xpath}")
	private String propertyOfTabToRent;

	@Value("${home&PropertyPage.tabForSale.xpath}")
	private String tabForSale;

	@Value("${home&PropertyPage.tabToRent.xpath}")
	private String tabToRent;

	@Value("${home&PropertyPage.dropdownType.xpath}")
	private String dropdownType;

	@Value("${home&PropertyPage.dropdownTypeAllItems.xpath}")
	private String dropdownTypeAllItems;

	@Value("${home&PropertyPage.dropdownBeds.xpath}")
	private String dropdownBeds;

	@Value("${home&PropertyPage.dropdownBedsAllItems.xpath}")
	private String dropdownBedsAllItems;

	@Value("${home&PropertyPage.inputLocation.xpath}")
	private String inputLocation;

	@Value("${home&PropertyPage.inputLocationDropDown.xpath}")
	private String inputLocationDropDown;

	@Value("${home&PropertyPage.buttonSearchproperty.xpath}")
	private String buttonSearchproperty;

	@Value("${home&PropertyPage.searchInformation.xpath}")
	private String searchInformation;

	@Value("${home&PropertyPage.minPriceForSale.xpath}")
	private String minPriceForSale;

	@Value("${home&PropertyPage.maxPriceForSale.xpath}")
	private String maxPriceForSale;

	@Value("${home&PropertyPage.minPriceToRent.xpath}")
	private String minPriceToRent;

	@Value("${home&PropertyPage.maxPriceToRent.xpath}")
	private String maxPriceToRent;

	@Value("${home&PropertyPage.slideBar.xpath}")
	private String slideBar;

	@Given("^I open the Homes&PropertyPage$")
	public void openHomeAndPropertyPage() {
		$(By.xpath(sectionHomeAndProperty)).click();
	}

	@Then("^tab 'For Sale' is active$")
	public void tabForSaleIsActive() {
		$(By.xpath(propertyOfTabForSale)).shouldHave(Condition.attribute(ATTRIBUTE_ARIA_SELECTED, "true"));
	}

	@When("^I click on tab 'To Rent'$")
	public void iClickOnTabToRent() {
		$(By.xpath(tabToRent)).click();
	}

	@Then("^tab 'To Rent' is active$")
	public void tabToRentIsActive() {
		$(By.xpath(propertyOfTabToRent)).shouldHave(Condition.attribute(ATTRIBUTE_ARIA_SELECTED, "true"));
	}

	@When("^I click on tab 'For Sale'$")
	public void iClickOnTabForSale() {
		$(By.xpath(tabForSale)).click();
	}

	@When("^I click on dropdown 'Type' in 'Homes&Property' section$")
	public void iClickOnDropdownType() {
		$(By.xpath(dropdownType)).click();
	}

	@Then("^The items in dropdown 'Type' are \"([^\"]*)\"$")
	public void theItemsInDropDownTypeAreAre(String items) {
		$(By.xpath(dropdownType)).shouldHave(Condition.exactText(items.replace(COMMA, "")));
	}

	@When("^I click on dropdown 'Beds' in 'Homes&Property' section$")
	public void iClickOnDropdownBeds() {
		$(By.xpath(dropdownBeds)).click();
	}

	@Then("^The items in dropdown 'Beds' are \"([^\"]*)\"$")
	public void theItemsInDropDownDedsAreAre(String items) {
		$(By.xpath(dropdownBeds)).shouldHave(Condition.exactText(items.replace(COMMA, "")));
	}

	// have some problems with input correct location
	@When("^I enter \"([^\"]*)\" and choose \"([^\"]*)\", \"([^\"]*)\" in 'Homes&Property' section$")
	public void iEnterLocationAndChooseParameters(String location, String type, String number_of_beds) {
		$(By.xpath(inputLocation)).setValue(location);
		WebElement firstElementLikeLocation = $(By.xpath(inputLocationDropDown)).shouldHave(Condition.text(location));
		actions().moveToElement(firstElementLikeLocation).click();
		$$(By.xpath(dropdownTypeAllItems)).find(Condition.exactText(type)).click();
		$$(By.xpath(dropdownBedsAllItems)).find(Condition.exactText(number_of_beds)).click();
	}

	@And("^I click 'search properties' button in 'Homes&Property' section$")
	public void iClickSearchPropertiesButton() {
		$(By.xpath(buttonSearchproperty)).click();
		switchTo().window(1);
	}

	@Then("^the information about property search found corresponds to the selected \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\"$")
	public void theInformationFoundCorrespondsToTheSelected(String location, String type, String numberOfBeds) {
		$(By.xpath(searchInformation)).shouldHave(Condition.text(type));
		$(By.xpath(searchInformation)).shouldHave(Condition.text(location));
		$(By.xpath(searchInformation)).shouldHave(Condition.text(numberOfBeds));
		getWebDriver().close();
		switchTo().window(0);
	}

	@Then("^I see min price \"([^\\\"]*)\" and max price \"([^\\\"]*)\" in 'For Sale'")
	public void iSeeMinPriceAndMaxPriceInTabForSale(String minPrice, String maxPrice) {
		$(By.xpath(minPriceForSale)).shouldHave(Condition.text(minPrice));
		$(By.xpath(maxPriceForSale)).shouldHave(Condition.text(maxPrice));
	}

	@Then("^I see min price \"([^\\\"]*)\" and max price \"([^\\\"]*)\" in tab 'To Rent'")
	public void iSeeMinPriceAndMaxPriceInTabToRent(String minPrice, String maxPrice) {
		$(By.xpath(minPriceToRent)).shouldHave(Condition.text(minPrice));
		$(By.xpath(maxPriceToRent)).shouldHave(Condition.text(maxPrice));
	}

	@When("^I click on slide bar of price$")
	public void iClickOnSlideBarOfPrice() {
		$(By.xpath(slideBar)).click();
	}
	
	@Then("^I see another minimum price than \"([^\"]*)\", and the slide bar moves to the center of the price scale$")
	public void iSeeAnotherMinPriceThan(String minPrice) {
		$(By.xpath(minPriceForSale)).shouldNotBe(Condition.text(minPrice));
	}

}

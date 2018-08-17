package com.epam.esauto.steps.content;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Value;

import com.codeborne.selenide.Condition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MainPageSteps {

	private static final String ATTRIBUTE_CONTENT = "content";

	@Value("${sectionLinks.xpath}")
	private String sectionLinks;

	@Value("${pageTitle.xpath}")
	private String pageTitle;

	@Value("${pageUrl.xpath}")
	private String pageUrl;

	@Value("${newsWithPlayButton.xpath}")
	private String newsWithPlayButton;

	@Value("${newsWithVideo.xpath}")
	private String newsWithVideo;

	@Value("${allNews.xpath}")
	private String allNews;

	@Value("${newsWithContent.xpath}")
	private String newsWithContent;

	private String urlOfChoosenNews;

	@When("^I click on \"([^\"]*)\" on Main Page$")
	public void iClickOnSectionLink(String link) throws Throwable {
		$$(By.xpath(sectionLinks)).find(Condition.exactText(link)).click();
	}

	@Then("I navigate to \"([^\"]*)\" section$")
	public void iNavigateToSection(String nameOfTitle) throws Throwable {
		$(By.xpath(pageTitle)).shouldHave(Condition.attribute(ATTRIBUTE_CONTENT, nameOfTitle));
	}

	@When("^I click on news_with_playbutton on Main Page$")
	public void iClickOnNewsWithPlayButton() {
		$(By.xpath(newsWithPlayButton)).click();
	}

	@Then("^news should be with video$")
	public void newsWithVideo() {
		$(By.xpath(newsWithVideo)).should(Condition.exist);
	}

	@When("^I click on news on Main Page$")
	public void iClickOnNews() {
		urlOfChoosenNews = $(By.xpath(allNews)).getAttribute("href");
		$(By.xpath(allNews)).click();
	}

	@Then("^news should be show on new Page$")
	public void openNews() {
		$(By.xpath(pageUrl)).shouldHave(Condition.attribute(ATTRIBUTE_CONTENT, urlOfChoosenNews));
	}

	@Then("^news should have a news content$")
	public void newsHaveANewsContent() {
		$(By.xpath(newsWithContent)).shouldBe(Condition.exist);
	}
}

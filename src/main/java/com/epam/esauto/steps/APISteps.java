package com.epam.esauto.steps;

import com.epam.esauto.util.ApiSaxParser;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

public class APISteps {

	private ApiSaxParser handler = new ApiSaxParser();

	@Given("^I install base url \"([^\"]*)\"$")
	public void installBaseURL(String url) {
		RestAssured.baseURI = url;
	}

	@When("^I send a GET request to base url and see status code \"([^\"]*)\"$")
	public void iSendAGetRequestToBaseURLAndSeeStatusCode(int valueStatusCode) {
		RestAssured.when().get().then().statusCode(valueStatusCode);
	}

	@When("^I send a GET request to \"([^\"]*)\" and see \"([^\"]*)\" is \"([^\"]*)\"$")
	public void iSendAGETRequestAndSeeContentType(String url, String contentType, String valueOfContentType) {
		RestAssured.when().get(url).then().header(contentType, valueOfContentType);
	}

	@When("^I send a GET request to \"([^\"]*)\" and parse a links to news$")
	public void iSendAGETRequestToAndParseALinksToNews(String url) throws ParserConfigurationException, SAXException {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			parser.parse(RestAssured.baseURI.concat(url), handler);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("^I send a GET requests to news and i see status code \"([^\"]*)\" and Content-Type is \"([^\"]*)\"$")
	public void iSendAGETRequestToNewsAndISeeStatusCodeAndIsValueContentTypeCorrect(int valueStatusCode,
			String valueContentType) {
		handler.getUrls().forEach(u -> {
			Response response = RestAssured.get(u);
			response.then().statusCode(valueStatusCode);
			response.then().contentType(valueContentType);
		});
	}
}

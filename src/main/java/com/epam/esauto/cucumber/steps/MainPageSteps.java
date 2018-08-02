package com.epam.esauto.cucumber.steps;

import com.epam.esauto.actions.INavigateActions;
import com.epam.esauto.pages.home.MainPage;
import com.epam.esauto.spring.AppConfig;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = AppConfig.class)
public class MainPageSteps {

    @Autowired
    private MainPage mainPage;

    @Autowired
    INavigateActions navigateActions;

    @Given("^I navigate to the page with URL '(http.+)'$")
    public void navigateTo(String url) {
        navigateActions.navigateTo(url);
    }

    @Then("^an element by xpath \"([^\"]*)\" exists$")
    public void anElementByXpathExists(String xpath) {
        Assert.assertTrue(mainPage.doesElementExists(xpath));
    }
}
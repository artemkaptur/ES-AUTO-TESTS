package com.epam.esauto.steps;

import com.codeborne.selenide.SelenideElement;
import com.epam.esauto.spring.AppConfig;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import cucumber.api.java.en.Given;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

@ContextConfiguration(classes = AppConfig.class)
public class MainPageSteps {

    @Value("${mainPage.url}")
    private String mainPageUrl;

    @Value("${mainPage.logo.xpath}")
    private String mainPageLogoXpath;

    @Value("${mainPage.user.btn.xpath}")
    private String userBtnXpath;

    @Value("${mainPage.login.btn.xpath}")
    private String loginBtnXpath;

    @Value("${mainPage.logout.btn.xpath}")
    private String logoutBtnXpath;

    @Value("${mainPage.registration.btn.xpath}")
    private String registrationBtnXpath;

    @Given("^I open the main page$")
    public void iOpenTheMainPage() {
        open(mainPageUrl);
    }

    @Then("^main logo is displayed$")
    public void mainLogoIsDisplayed() {
        $(By.xpath(mainPageLogoXpath)).shouldBe(visible);
    }

    @And("^click logout button$")
    public void clickLogoutButton() {
        refresh();
        clickOnUserBtnAndGetBtnByXpath(logoutBtnXpath).click();
    }

    @Then("^logout button doesn't exist$")
    public void logoutButtonDoesntExist() {
        clickOnUserBtnAndGetBtnByXpath(logoutBtnXpath).shouldNotBe(visible);
        $(By.xpath(userBtnXpath)).click();
    }

    @Then("^login button is displayed$")
    public void loginButtonIsDisplayed() {
        clickOnUserBtnAndGetBtnByXpath(loginBtnXpath).shouldBe(visible);
    }

    @Then("^I open login form$")
    public void iOpenLoginForm() {
        clickOnUserBtnAndGetBtnByXpath(loginBtnXpath).click();
        switchTo().window("Log in");
    }

    @Given("^I click register button$")
    public void iClickRegisterButton() {
        $(By.xpath(userBtnXpath)).click();
        $(By.xpath(registrationBtnXpath)).click();
    }

    public SelenideElement clickOnUserBtnAndGetBtnByXpath(String xpath) {
        $(By.xpath(userBtnXpath)).click();
        return $(By.xpath(xpath));
    }

    public void clickLoginButton() {
        $(By.xpath(loginBtnXpath)).click();
        switchTo().window("Log in");
    }
}
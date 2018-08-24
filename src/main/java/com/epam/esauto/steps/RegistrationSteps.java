package com.epam.esauto.steps;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.epam.esauto.entity.UserProvider.getUser;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class RegistrationSteps {

    private static final int TRIPLE_DEFAULT_TIMEOUT = 12000;

    @Value("${registrationPage.email.input.id}")
    private String emailInputId;

    @Value("${registrationPage.email.firstname.id}")
    private String firstnameInputId;

    @Value("${registrationPage.email.lastname.id}")
    private String lastnameInputId;

    @Value("${registrationPage.invalidEmailMessage.xpath}")
    private String invalidEmailWarningMessageXpath;

    @Value("${registrationPage.invalidFirstnameMessage.xpath}")
    private String invalidFirstnameWarningMessageXpath;

    @Value("${registrationPage.invalidLastnameMessage.xpath}")
    private String invalidLastnameWarningMessageXpath;

    @Value("${registrationPage.continue.btn.xpath}")
    private String continueRegistrationBtnXpath;

    @Value("${registrationPage.password.id}")
    private String registrationFormPasswordId;

    @Value("${registrationPage.password.confirmation.id}")
    private String registrationFormPasswordConfirmationId;

    @Value("${registrationPage.passwordsDontMatchMessage.xpath}")
    private String passwordDontMatchMessageXpath;

    @Value("${registrationPage.selectCountry.id}")
    private String selectCountryId;

    @Value("${registrationPage.selectYearOfBirth.id}")
    private String selectYearOfBirthId;

    @Value("${registrationPage.selectGender.id}")
    private String selectGenderId;

    @Value("${registrationPage.zipCode.id}")
    private String zipCodeId;

    @Value("${registrationPage.additionalOffers.checkbox.id}")
    private String additionalOffersCheckboxId;

    @Value("${registrationPage.passwordsDontStrongMessage.xpath}")
    private String passwordDontStrongMessageXpath;

    @Value("${registrationPage.yearsOfBirth.xpath}")
    private String yearOfBirthVariantsXpath;

    @Value("${registrationPage.genders.xpath}")
    private String genderVariantsXpath;

    @Value("${registrationPage.countries.xpath}")
    private String countryVariantsXpath;

    @Value("${registrationPage.newPassword.xpath}")
    private String newPasswordXpath;

    @Value("${registrationPage.retypeNewPassword.xpath}")
    private String retypeNewPasswordXpath;

    @Value("${registrationPage.successfulChangePassword.message.id}")
    private String successfulChangePasswordMessageId;

    @Value("${registrationPage.submitPasswordChange.btn.id}")
    private String submitPasswordChangeBtnId;

    @Value("${registrationPage.nickname.input.id}")
    private String nicknameInputId;

    @Value("${registrationPage.submitRegistration.btn.xpath}")
    private String submitRegistrationBtnXpath;

    @Value("${registrationPage.facebookRegistration.link.xpath}")
    private String facebookRegistrationLinkXpath;

    @Value("${registrationPage.twitterRegistration.link.xpath}")
    private String twitterRegistrationLinkXpath;

    @Value("${registrationPage.facebook.content.id}")
    private String facebookContentId;

    @Value("${registrationPage.twitter.greetingMessage.xpath}")
    private String twitterGreetingMessageXpath;

    @Value("${registrationPage.successfulRegistration.message.xpath}")
    private String successfulRegistrationMessageXpath;

    @Value("${registrationPage.additionalOffers.message.className}")
    private String additionalOffersClassName;

    @Value("${registrationPage.registrationTitle.className}")
    private String registrationTitleClassName;

    @Value("${mainPage.url}")
    private String mainPageUrl;

    @When("^I fill email field with ([^\"]*)$")
    public void iFillEmailFieldWithEmail(String email) {
        clearElementAndSetValue(emailInputId, email);
        $(By.className(registrationTitleClassName)).click();
    }

    @When("^I fill firstname invalid ([^\"]*)$")
    public void iFillInvalidFirstname(String firstname) {
        clearElementAndSetValue(firstnameInputId, firstname);
        $(By.className(registrationTitleClassName)).click();
    }

    @When("^I fill lastname invalid ([^\"]*)$")
    public void iFillInvalidLastname(String lastname) {
        clearElementAndSetValue(lastnameInputId, lastname);
        $(By.className(registrationTitleClassName)).click();
    }

    private void clearElementAndSetValue(String elementId, String value) {
        $(By.id(elementId)).clear();
        $(By.id(elementId)).setValue(value);
    }

    @When("^I fill registration form with random email, \"([^\"]*)\", \"([^\"]*)\"$")
    public void iFillRegistrationFormWithRandomEmail(String firstname, String lastname) {
        $(By.id(emailInputId)).setValue(randomAlphabetic(8) + "@"
                + randomAlphabetic(4) + "."
                + randomAlphabetic(3));
        fillFirstAndLastNameAndContinueRegistration(firstname, lastname);
    }

    private void fillFirstAndLastNameAndContinueRegistration(String firstname, String lastname) {
        $(By.id(firstnameInputId)).setValue(firstname);
        $(By.id(lastnameInputId)).setValue(lastname);
        $(By.xpath(continueRegistrationBtnXpath)).click();
    }

    @When("^I click facebook icon$")
    public void iClickFacebookIcon() {
        $(By.xpath(facebookRegistrationLinkXpath)).waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT).click();
    }

    @When("^I click twitter icon$")
    public void iClickTwitterIcon() {
        $(By.xpath(twitterRegistrationLinkXpath)).waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT).click();
    }

    @When("^fill registration form password fields with \"([^\"]*)\", \"([^\"]*)\"$")
    public void fillRegistrationFormPasswordFieldsWith(String password, String passwordConfirm) {
        $(By.id(registrationFormPasswordId)).waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT).setValue(password);
        $(By.id(registrationFormPasswordConfirmationId)).setValue(passwordConfirm);
    }

    @When("^select \"([^\"]*)\" country$")
    public void selectCountry(String zimbabwe) {
        $(By.id(selectCountryId)).selectOption(zimbabwe);
    }

    @When("^fill registration form password field with \"([^\"]*)\"$")
    public void fillRegistrationFormPasswordFieldsWith(String password) {
        $(By.id(registrationFormPasswordId)).setValue(password);
    }

    @When("^click on select year of birth field$")
    public void clickOnSelectYearOfBirthField() {
        $(By.id(selectYearOfBirthId)).waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT).click();
    }

    @When("^click on select gender field$")
    public void clickOnSelectGenderField() {
        $(By.id(selectGenderId)).click();
    }

    @When("^click on select country field$")
    public void clickOnSelectCountryField() {
        $(By.id(selectCountryId)).waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT).click();
    }

    @And("^enter new password \"([^\"]*)\"$")
    public void enterNewPassword(String password) {
        $(By.xpath(newPasswordXpath)).setValue(password);
        $(By.xpath(retypeNewPasswordXpath)).setValue(password);
        $(By.id(submitPasswordChangeBtnId)).click();
    }

    @And("^fill registration form mandatory fields with:$")
    public void fillRegistrationFormMandatoryFieldsWith(DataTable data) {
        Map<String, String> mandatoryFieldsData = data.asMap(String.class, String.class);
        $(By.id(selectCountryId)).selectOption(mandatoryFieldsData.get("country"));
        $(By.id(selectYearOfBirthId)).selectOption(mandatoryFieldsData.get("birthyear"));
        $(By.id(selectGenderId)).selectOption(mandatoryFieldsData.get("gender"));
        $(By.id(nicknameInputId)).setValue(randomAlphabetic(14));
        $(By.id(registrationFormPasswordId)).setValue(mandatoryFieldsData.get("password"));
        $(By.id(registrationFormPasswordConfirmationId)).setValue(mandatoryFieldsData.get("password"));
    }

    @Then("^\"([^\"]*)\", \"([^\"]*)\" or \"([^\"]*)\" warning message should be shown$")
    public void warningMessageShouldBeShown(String warningMessage, String warningMessageSecond, String warningMessageThird) {
        $(By.xpath(invalidEmailWarningMessageXpath))
                .shouldHave(or("warningMessage", text(warningMessage), text(warningMessageSecond), text(warningMessageThird)));
    }

    @Then("^under firstname field \"([^\"]*)\" warning message should be shown$")
    public void underFirstnameFieldWarningMessageShouldBeShown(String warningMessage) {
        $(By.xpath(invalidFirstnameWarningMessageXpath)).shouldHave(text(warningMessage));
    }

    @Then("^under lastname field \"([^\"]*)\" warning message should be shown$")
    public void underLastnameFieldWarningMessageShouldBeShown(String warningMessage) {
        $(By.xpath(invalidLastnameWarningMessageXpath)).shouldHave(text(warningMessage));
    }

    @Then("^\"([^\"]*)\" warning message should be shown under confirm password field$")
    public void warningMessageShouldBeShown(String warningMessage) {
        $(By.className(additionalOffersClassName)).click();
        $(By.xpath(passwordDontMatchMessageXpath)).shouldHave(text(warningMessage));
    }

    @Then("^zip code field isn't displayed$")
    public void zipCodeFieldIsnTDisplayed() {
        $(By.id(zipCodeId)).shouldNotBe(visible);
    }

    @Then("^'I would like to receive additional offers' checkbox is clickable$")
    public void additionalOffersCheckboxIsClickable() {
        $(By.id(additionalOffersCheckboxId)).shouldBe(enabled);
    }

    @Then("^\"([^\"]*)\" warning message should be shown under password field$")
    public void warningMessageShouldBeShownUnderPasswordField(String warningMessage) {
        $(By.className(additionalOffersClassName)).click();
        $(By.xpath(passwordDontStrongMessageXpath)).shouldHave(text(warningMessage));
    }

    @Then("^drop-down contains only years between (\\d+) and (\\d+)$")
    public void dropDownContainsOnlyYearsBetween(int minYear, int maxYear) {
        List<String> yearOfBirthVariants = $$(By.xpath(yearOfBirthVariantsXpath)).texts();
        yearOfBirthVariants.remove(0);
        Assert.assertTrue(yearOfBirthVariants.stream()
                .mapToInt(Integer::valueOf)
                .allMatch(v -> v >= minYear && v <= maxYear));
    }

    @Then("^drop-down contains only \"([^\"]*)\" and \"([^\"]*)\" genders$")
    public void dropDownContainsOnlyAndGenders(String male, String female) {
        List<String> genderVariants = $$(By.xpath(genderVariantsXpath)).texts();
        genderVariants.remove(0);
        Assert.assertEquals(Arrays.asList(male, female), genderVariants);
    }

    @Then("^\"([^\"]*)\" successful password change message should be shown$")
    public void checkPasswordResetMessage(String message) {
        $(By.id(successfulChangePasswordMessageId)).shouldHave(text(message));
        open(mainPageUrl);
    }

    @Then("^drop-down contains only countries$")
    public void dropDownContainsOnlyCountries() {
        List<String> countryVariants = $$(By.xpath(countryVariantsXpath)).texts();
        Assert.assertTrue(countryVariants.stream().allMatch(v -> v.matches("^[a-zA-Z.()\\-’, ]+$")));

    }

    @Then("^I verify that complete registration page is opened$")
    public void iVerifyThatCompleteRegistrationPageIsOpened() {
        $(By.xpath(submitRegistrationBtnXpath)).click();
        Assert.assertTrue(title().contains("Register"));
    }

    @Then("^new window with facebook login page should be opened$")
    public void newWindowWithFacebookLoginPageShouldBeOpened() {
        switchTo().window("Facebook");
        $(By.id(facebookContentId)).shouldHave(text("Log in to use your Facebook account with "));
        closeWindowAndSwitchToDefault();
    }

    @Then("^new window with twitter login page should be opened$")
    public void newWindowWithTwitterLoginPageShouldBeOpened() {
        switchTo().window("Twitter / Authorize an application");
        $(By.xpath(twitterGreetingMessageXpath)).shouldHave(text("Authorize Evening Standard Ltd to use your account?"));
        closeWindowAndSwitchToDefault();
    }

    private void closeWindowAndSwitchToDefault() {
        getWebDriver().close();
        switchTo().window(0);
    }

    @Then("^successful registration message should be shown$")
    public void successfulRegistrationMessageShouldBeShown() {
        $(By.xpath(submitRegistrationBtnXpath)).click();
        $(By.xpath(successfulRegistrationMessageXpath)).shouldHave(text("for completing your registration"));
    }

    @Then("^I fill registration form with \"([^\"]*)\" email, \"([^\"]*)\", \"([^\"]*)\"$")
    public void iFillRegistrationFormWithEmail(String username, String firstname, String lastname) {
        $(By.id(emailInputId)).setValue(getUser(username).getMailLogin());
        fillFirstAndLastNameAndContinueRegistration(firstname, lastname);
    }
}

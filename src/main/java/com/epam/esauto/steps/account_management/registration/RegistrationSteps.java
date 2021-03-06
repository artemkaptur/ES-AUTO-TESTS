package com.epam.esauto.steps.account_management.registration;

import com.epam.esauto.entity.User;
import com.epam.esauto.util.DataHolder;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.epam.esauto.entity.UserProvider.getUser;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;

public class RegistrationSteps {

    private static final int TRIPLE_DEFAULT_TIMEOUT = 12000;
    private static final String USER_TEST_NAME_FIRST = "registrationPositiveTestUserFirst";
    private static final String USER_TEST_NAME_SECOND = "registrationPositiveTestUserSecond";

    @Autowired
    private DataHolder dataHolder;

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

    @Value("${registrationPage.googleRegistration.link.xpath}")
    private String googleRegistrationLinkXpath;

    @Value("${registrationPage.google.continueMessage.id}")
    private String googleContinueMessageId;

    @Value("${registrationPage.privacyPolice.btn.xpath}")
    private String privacyPoliceBtnXpath;

    @Value("${registrationPage.completeRegistration.title.className}")
    private String completeRegistrationTitleClassName;

    @Value("${registrationPage.invalidZipCodeMessage.xpath}")
    private String invalidZipCodeMessageXpath;

    @Value("${registrationPage.alreadyUsedEmailMessage.xpath}")
    private String alreadyUsedEmailMessageXpath;

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
        User user = new User();
        user.setEsLogin(randomAlphabetic(8) + "@"
                + randomAlphabetic(4) + "."
                + randomAlphabetic(3));
        $(By.id(emailInputId)).setValue(user.getEsLogin());
        fillFirstAndLastNameAndContinueRegistration(firstname, lastname);
        dataHolder.put(USER_TEST_NAME_FIRST,user);
    }

    private void fillFirstAndLastNameAndContinueRegistration(String firstname, String lastname) {
        $(By.id(firstnameInputId)).setValue(firstname);
        $(By.id(lastnameInputId)).setValue(lastname);
        $(By.xpath(continueRegistrationBtnXpath)).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

    @When("^I click google icon$")
    public void iClickGoogleIcon() {
        $(By.xpath(googleRegistrationLinkXpath)).waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT).click();
    }

    @When("^I click on privacy police button$")
    public void iClickOnPrivacyPoliceButton() {
        $(By.xpath(privacyPoliceBtnXpath)).waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT).click();
    }

    @And("^enter new password \"([^\"]*)\"$")
    public void enterNewPassword(String password) {
        $(By.xpath(newPasswordXpath)).setValue(password);
        $(By.xpath(retypeNewPasswordXpath)).setValue(password);
        $(By.id(submitPasswordChangeBtnId)).click();
    }

    @And("^fill registration form mandatory fields with:$")
    public void fillRegistrationFormMandatoryFieldsWith(DataTable data) {
        User user = (User) dataHolder.getByKey(USER_TEST_NAME_FIRST);
        Map<String, String> mandatoryFieldsData = data.asMap(String.class, String.class);
        $(By.id(selectCountryId)).waitUntil(enabled, TRIPLE_DEFAULT_TIMEOUT)
                .selectOption(mandatoryFieldsData.get("country"));
        $(By.id(selectYearOfBirthId)).waitUntil(enabled, TRIPLE_DEFAULT_TIMEOUT)
                .selectOption(mandatoryFieldsData.get("birthyear"));
        $(By.id(selectGenderId)).waitUntil(enabled, TRIPLE_DEFAULT_TIMEOUT)
                .selectOption(mandatoryFieldsData.get("gender"));
        $(By.id(nicknameInputId)).waitUntil(enabled, TRIPLE_DEFAULT_TIMEOUT)
                .setValue(randomAlphabetic(14));
        user.setEsPassword(mandatoryFieldsData.get("password"));
        $(By.id(registrationFormPasswordId)).waitUntil(enabled, TRIPLE_DEFAULT_TIMEOUT)
                .setValue(mandatoryFieldsData.get("password"));
        $(By.id(registrationFormPasswordConfirmationId)).waitUntil(enabled, TRIPLE_DEFAULT_TIMEOUT)
                .setValue(mandatoryFieldsData.get("password"));
        dataHolder.put(USER_TEST_NAME_SECOND,user);
    }

    @And("^fill zip code field with ([^\"]*)$")
    public void fillZipCodeFieldWithZipCode(String zipCode) {
        $(By.id(zipCodeId)).setValue(zipCode);
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

    @Then("^new window with google login page should be opened$")
    public void newWindowWithGoogleLoginPageShouldBeOpened() {
        switchTo().window("Вход – Google Аккаунты");
        $(By.id(googleContinueMessageId)).shouldHave(text("Переход в приложение \"London Evening Standard\""));
        closeWindowAndSwitchToDefault();
    }

    @Then("^privacy police page is opened$")
    public void privacyPolicePageIsOpened() {
        switchTo().window("Privacy Notice | London Evening Standard");
        Assert.assertEquals("Privacy Notice | London Evening Standard", title());
    }

    @Then("^\"([^\"]*)\" message should be shown under zip code field$")
    public void messageShouldBeShownUnderZipCodeField(String warningMessage) {
        $(By.className(completeRegistrationTitleClassName)).click();
        $(By.xpath(invalidZipCodeMessageXpath)).shouldHave(text(warningMessage));
    }

    @Then("^\"([^\"]*)\" message should be shown under email field at registration form$")
    public void messageShouldBeShownUnderEmailFieldAtRegistrationForm(String warningMessage) {
        $(By.xpath(alreadyUsedEmailMessageXpath)).shouldHave(text(warningMessage));
    }
}

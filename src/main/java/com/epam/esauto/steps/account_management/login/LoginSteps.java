package com.epam.esauto.steps.account_management.login;

import com.epam.esauto.entity.User;
import com.epam.esauto.util.DataHolder;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.epam.esauto.entity.UserProvider.getUser;

public class LoginSteps {
    private static final int TRIPLE_DEFAULT_TIMEOUT = 12000;
    private static final String USER_TEST_NAME_SECOND = "registrationPositiveTestUserSecond";

    @Autowired
    private DataHolder dataHolder;

    @Value("${loginPage.email.input.xpath}")
    private String emailInputXpath;

    @Value("${loginPage.passw.input.name}")
    private String passwInputName;

    @Value("${loginPage.loginSubmit.btn.class}")
    private String loginSubmitBtnClass;

    @Value("${loginPage.welcomingMessage.xpath}")
    private String loginWelcomingMsgXpath;

    @Value("${loginPage.invalidEmailMessage.xpath}")
    private String invalidEmailWarningMessageXpath;

    @Value("${loginPage.invalidLoginOrPasswordMessage.id}")
    private String invalidLoginOrPasswordWarningMessageId;

    @Value("${loginPage.forgottenPassword.btn.xpath}")
    private String forgottenPasswordBtnXpath;

    @Value("${loginPage.forgottenPassword.email.input.xpath}")
    private String forgottenPasswordEmailInputXpath;

    @When("^I login as a user \"([^\"]*)\"$")
    public void iLoginAsAUser(String userName) {
        iSubmitLoginFormAsAUser(userName);
        closeLoginForm();
    }

    private void closeLoginForm() {
        $(By.xpath(loginWelcomingMsgXpath)).waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT)
                .shouldHave(text("You are currently logged in, click here to log out"));
        getWebDriver().close();
        switchTo().window(0);
    }

    @When("^I submit login form as a user \"([^\"]*)\"$")
    public void iSubmitLoginFormAsAUser(String userName) {
        $(By.xpath(emailInputXpath)).setValue(getUser(userName).getEsLogin());
        $(By.name(passwInputName)).setValue(getUser(userName).getEsPassword());
        $(By.className(loginSubmitBtnClass)).click();
    }

    @When("^I fill login form with email ([^\"]*)$")
    public void iFillLoginFormWithEmailEmail(String email) {
        $(By.xpath(emailInputXpath)).setValue(email);
    }

    @When("^I click forgotten password$")
    public void iClickForgottenPassword() {
        $(By.xpath(forgottenPasswordBtnXpath)).click();
    }

    @And("^I login as a user registrationPositiveTestUser$")
    public void iLoginAsAUserRegistrationPositiveTestUser() {
        User user = (User) dataHolder.getByKey(USER_TEST_NAME_SECOND);
        $(By.xpath(emailInputXpath)).setValue(user.getEsLogin());
        $(By.name(passwInputName)).setValue(user.getEsPassword());
        $(By.className(loginSubmitBtnClass)).click();
        closeLoginForm();
    }

    @And("^enter email of user \"([^\"]*)\"$")
    public void enterEmailOfUser(String userName) {
        $(By.xpath(forgottenPasswordEmailInputXpath)).setValue(getUser(userName).getMailLogin()).pressEnter();
    }

    @Then("^\"([^\"]*)\" message should be shown$")
    public void messageShouldBeShown(String warningMessage) {
        $(By.xpath(invalidEmailWarningMessageXpath)).shouldHave(text(warningMessage));
    }

    @Then("^\"([^\"]*)\" warning message should be shown$")
    public void warningMessageShouldBeShown(String warningMessage) {
        $(By.id(invalidLoginOrPasswordWarningMessageId)).waitUntil(visible, TRIPLE_DEFAULT_TIMEOUT).shouldHave(text(warningMessage));
    }
}

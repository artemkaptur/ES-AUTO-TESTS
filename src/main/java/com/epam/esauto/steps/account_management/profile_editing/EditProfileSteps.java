package com.epam.esauto.steps.account_management.profile_editing;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.epam.esauto.entity.User;
import com.epam.esauto.steps.MainPageSteps;
import com.epam.esauto.steps.account_management.login.LoginSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.epam.esauto.entity.UserProvider.getUser;

public class EditProfileSteps {

    private static final String BTN_GREEN_COLOR = "rgba(30, 130, 76, 1)";
    private static final String NEW_FIRST_NAME = "Robert";
    private static final String COMMENT = "Good article";
    private static final String SUCCESSFUL_SAVING_MESSAGE = "Changes have been saved.";

    @Autowired
    private LoginSteps loginSteps;

    @Autowired
    private MainPageSteps mainPageSteps;

    @Value("${mainPage.url}")
    private String mainPageUrl;

    @Value("${mainPage.user.btn.xpath}")
    private String userBtnXpath;

    @Value("${mainPage.account.btn.xpath}")
    private String userAccountBtnXpath;

    @Value("${accountPage.newsletters.xpath}")
    private String newslettersSectionXpath;

    @Value("${accountPage.newslettersform.xpath}")
    private String newslettersFormXpath;

    @Value("${accountPage.edit.xpath}")
    private String editSectionXpath;

    @Value("${accountPage.editform.xpath}")
    private String editFormXpath;

    @Value("${accountPage.password.xpath}")
    private String passwordSectionXpath;

    @Value("${accountPage.passwordform.xpath}")
    private String passwordFormXpath;

    @Value("${accountPage.comments.xpath}")
    private String commentsSectionXpath;

    @Value("${accountPage.commentsform.xpath}")
    private String commentsFormXpath;

    @Value("${accountPage.newsletters.sublabel.class}")
    private String subLabelClassName;

    @Value("${accountPage.newsletters.subBtn.class}")
    private String subBtnClassName;

    @Value("${accountPage.edit.firstnameAsterisk.xpath}")
    private String firstNameAsteriskXpath;

    @Value("${accountPage.edit.firstnameInput.id}")
    private String firstNameInputId;

    @Value("${accountPage.edit.lastnameInput.id}")
    private String lastNameInputId;

    @Value("${accountPage.savingBtn.Xpath}")
    private String saveBtnXpath;

    @Value("${accountPage.savingSuccessfulMsg.xpath}")
    private String savingSuccessfulMessageXpath;

    @Value("${accountPage.edit.genderSelect.id}")
    private String genderSelectId;

    @Value("${accountPage.edit.getnderwarningMsg.xpath}")
    private String genderWarningMsgXpath;

    @Value("${accountPage.edit.countrySelect.id}")
    private String countrySelectId;

    @Value("${accountPage.edit.firstnameWarningMsg.xpath}")
    private String firstNameWarningMsgXpath;

    @Value("${accountPage.edit.lastnameWarningMsg.xpath}")
    private String lastNameWarningMsgXpath;

    @Value("${accountPage.edit.password.name}")
    private String passwordinputName;

    @Value("${accountPage.edit.newpassword.name}")
    private String newPasswordinputName;

    @Value("${accountPage.edit.repeatpassword.name}")
    private String repeatPasswordInputName;

    @Value("${accountPage.edit.passwordSubmitBtn.xpath}")
    private String passwordSubmitBtnXpath;

    @Value("${accountPage.edit.passwordWarningMessage.xpath}")
    private String passwordWarningMessageXpath;

    @Value("${accountPage.edit.passwordSuccessfulMessage.xpath}")
    private String passwordSuccessfulMsgXpath;

    @Value("${accountPage.edit.emailInput.id}")
    private String editEmailInputId;

    @Value("${mainPage.logout.btn.xpath}")
    private String logoutBtnXpath;

    @Value("${mainPage.firstBigArticle.xpath}")
    private String firstBigArticleXpath;

    @Value("${articlePage.postCommenttextarea.name}")
    private String commentTextAreaName;

    @Value("${articlePage.postButton.className}")
    private String postCommentButtonClassName;

    @Value("${articlePage.commentSection.xpath}")
    private String articleCommentsSectionXpath;

    @Value("${accountPage.comments.commentLeftByUser.xpath}")
    private String leftCommentXpath;

    @And("^I open profile page$")
    public void iOpenProfilePage() {
        if (!$(By.xpath(userAccountBtnXpath)).isDisplayed()) {
            $(By.xpath(userBtnXpath)).click();
        }
        $(By.xpath(userAccountBtnXpath)).shouldBe(Condition.visible).click();
        String expectedUrl = mainPageUrl + "account";
        Assert.assertEquals("You didn't open account page!", expectedUrl, getWebDriver().getCurrentUrl());
    }

    @When("^Newsletters subsection button is visible on profile page$")
    public void newslettersSubsectionButtonIsVisible() {
        $(By.xpath(newslettersSectionXpath)).shouldBe(Condition.visible);
    }

    @And("^I click on the Newsletters subsection button on profile page$")
    public void iClickOnTheNewslettersSubsectionButton() {
        $(By.xpath(newslettersSectionXpath)).click();
    }

    @And("^I click on all subscription buttons on Newsletters form$")
    public void iClickOnAllSubscriptionButtons() {
        Stream<SelenideElement> stream = $$(By.className(subLabelClassName)).stream();
        stream.forEach(SelenideElement::click);
    }

    @Then("^I see that all subscription buttons on Newsletters form have changed color to green$")
    public void iSeeThatAllSubscriptionButtonsHaveChangedColorToGreen() {
        Stream<SelenideElement> stream = $$(By.className(subBtnClassName)).stream();
        stream.forEach(btn -> btn.shouldHave(Condition.cssValue("background-color", BTN_GREEN_COLOR)));
    }

    @And("^I click newsletters submit button$")
    public void iClickNewslettersSubmitButton() {
        $(By.xpath(newslettersFormXpath + saveBtnXpath)).click();
    }

    @When("^Edit profile subsection button is visible on profile page$")
    public void editProfileSubsectionButtonIsVisible() {
        $(By.xpath(editSectionXpath)).shouldBe(Condition.visible);
    }

    @And("^I click on Edit profile subsection button on profile page$")
    public void iClickOnEditProfileSubsectionButton() {
        $(By.xpath(editSectionXpath)).click();
    }

    @Then("^editing form is visible on profile page$")
    public void editingFormIsVisible() {
        $(By.xpath(editFormXpath)).shouldBe(Condition.visible);
    }

    @When("^Comments subsection button is visible on profile page$")
    public void commentsSubsectionButtonIsVisible() {
        $(By.xpath(commentsSectionXpath)).shouldBe(Condition.visible);
    }

    @And("^I click on the Comments subsection button on profile page$")
    public void iClickOnTheCommentsSubsectionButton() {
        $(By.xpath(commentsSectionXpath)).click();
    }

    @Then("^comments form is visible on profile page$")
    public void commentsFormIsVisible() {
        $(By.xpath(commentsFormXpath)).shouldBe(Condition.visible);
    }

    @When("^Change password subsection button is visible on profile page$")
    public void changePasswordSubsectionButtonIsVisible() {
        $(By.xpath(passwordSectionXpath)).shouldBe(Condition.visible);
    }

    @And("^I click on the Change password subsection button on profile page$")
    public void iClickOnTheChangePasswordSubsectionButton() {
        $(By.xpath(passwordSectionXpath)).click();
    }

    @Then("^password changing form is visible on profile page$")
    public void passwordChangingFormIsVisible() {
        $(By.xpath(passwordFormXpath)).shouldBe(Condition.visible);
    }

    @Then("^I locate an asterisk mark near first name field input on edit form$")
    public void iLocateAnAsteriskMarkNearFirstNameField() {
        $(By.xpath(firstNameAsteriskXpath)).shouldBe(Condition.visible);
    }

    @And("^I clear first name field input on edit form$")
    public void iClearFirstNameField() {
        $(By.id(firstNameInputId)).clear();
    }

    @And("^I click on Submit button on edit form$")
    public void iClickOnSubmitButton() {
        $(By.xpath(editFormXpath + saveBtnXpath)).click();
    }

    @And("^warning message about not valid first name is visible on edit form$")
    public void warningMessageAboutNotValidFirstNameIsVisible() {
        $(By.xpath(firstNameWarningMsgXpath)).shouldBe(Condition.visible);
    }

    @And("^I clear last name field input on edit form$")
    public void iClearLastNameField() {
        $(By.id(lastNameInputId)).clear();
    }

    @And("^warning message about not valid last name is visible on edit form$")
    public void warningMessageAboutNotValidLastNameIsVisible() {
        $(By.xpath(lastNameWarningMsgXpath)).shouldBe(Condition.visible);
    }

    @And("^I select empty option on gender dropdown on edit form$")
    public void iSelectEmptyOptionOnGenderDropdown() {
        $(By.id(genderSelectId)).selectOptionContainingText("select");
    }

    @Then("^warning message about empty gender option is visible on edit form$")
    public void warningMessageAboutGenderIsVisible() {
        var errorMessage = "This information helps us to understand our readers," +
                " and tailor advertising and content to you.";
        $(By.xpath(genderWarningMsgXpath))
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text(errorMessage));
    }

    @And("^I enter a valid name into first name field input on edit form$")
    public void iEnterAValidNameIntoFirstNameField() {
        $(By.id(firstNameInputId)).setValue(NEW_FIRST_NAME);
    }

    @Then("^message about successful saving after profile editing is visible on edit form$")
    public void messageAboutSuccessfulSavingAfterProfileEditingIsVisible() {
        $(By.xpath(editFormXpath + savingSuccessfulMessageXpath)).shouldBe(Condition.visible);
    }

    @And("^I select new country from country Select dropdown on edit form$")
    public void iSelectChinaAsCountry() {
        var newCountry = "China";
        $(By.id(countrySelectId)).selectOptionContainingText(newCountry);
    }

    @Then("^I see that i have changed country successfully$")
    public void iSeeThatIHaveChangedCountrySuccessfully() {
        refresh();
        Assert.assertEquals("Required option is not selected", "China",
                $(By.id(countrySelectId)).getSelectedOption().getText());
    }

    @And("^I enter a not valid first name into first name field input on edit form$")
    public void iEnterANotValidNameIntoFirstNameField() {
        var notValidFirstName = "1123345678";
        $(By.id(firstNameInputId)).setValue(notValidFirstName);
    }

    @And("^I enter a not valid name into last name field input on edit form$")
    public void iEnterANotValidNameIntoLastNameField() {
        var notValidLastName = "df@@@@@@@###$$$";
        $(By.id(lastNameInputId)).setValue(notValidLastName);
    }

    @Then("^message about successful password changing is visible on password changing form$")
    public void messageAboutSuccessfulPasswordChangingIsVisible() {
        $(By.xpath(passwordFormXpath + passwordSuccessfulMsgXpath))
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text(SUCCESSFUL_SAVING_MESSAGE));
    }

    @Then("^warning message about not valid password repeating is visible$")
    public void warningMessageAboutNotValidPasswordRepeatingIsVisible() {
        var passwordWarningMessage = "Password does not match";
        $(By.xpath(passwordWarningMessageXpath))
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text(passwordWarningMessage));
    }

    @Then("^I see that i have changed first name successfully$")
    public void iSeeThatIHaveChangedFirstNameSuccessfully() {
        refresh();
        $(By.xpath(editSectionXpath)).click();
        $(By.id(firstNameInputId)).shouldHave(Condition.value(NEW_FIRST_NAME));
    }

    @And("^message about successful saving after newsletters configuring is visible$")
    public void messageAboutSuccessfulSavingAfterNewslettersConfiguringIsVisible() {
        $(By.xpath(newslettersFormXpath + savingSuccessfulMessageXpath))
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text(SUCCESSFUL_SAVING_MESSAGE));
        refresh();
    }

    @And("^I change \"([^\"]*)\" password to \"([^\"]*)\" password$")
    public void iChangePasswordToPassword(String userWithOldPass, String userWithNewPass) {
        User oldUser = getUser(userWithOldPass);
        $(By.name(passwordinputName)).setValue(oldUser.getEsPassword());
        User newUser = getUser(userWithNewPass);
        $(By.name(newPasswordinputName)).setValue(newUser.getEsPassword());
        $(By.name(repeatPasswordInputName)).setValue(newUser.getEsPassword());
        $(By.xpath(passwordFormXpath + passwordSubmitBtnXpath))
                .waitUntil(Condition.text("Save changes"), 6000).click();
    }

    @And("^I change \"([^\"]*)\" password to \"([^\"]*)\" password with mistakes$")
    public void iChangePasswordToPasswordWithMistakes(String userWithOldPass, String userWithNewPass) {
        User oldUser = getUser(userWithOldPass);
        $(By.name(passwordinputName)).setValue(oldUser.getEsPassword());
        User newUser = getUser(userWithNewPass);
        $(By.name(newPasswordinputName)).setValue(newUser.getEsPassword());
        $(By.name(repeatPasswordInputName)).setValue(newUser.getEsPassword() + "blabla");
        $(By.xpath(passwordFormXpath + passwordSubmitBtnXpath))
                .waitUntil(Condition.text("Save changes"), 6000).click();
    }

    @And("^I submit edit form with \"([^\"]*)\" email$")
    public void iSubmitEditFormWithEmail(String userName) {
        $(By.id(editEmailInputId)).clear();
        $(By.id(editEmailInputId)).setValue(getUser(userName).getMailLogin());
        $(By.xpath(editFormXpath + saveBtnXpath)).click();
    }

    @And("^I check if i logged in as user \"([^\"]*)\"$")
    public void iCheckIfILoggedInAsUser(String userName) {
        switchTo().window(0);
        refresh();
        $(By.xpath(userBtnXpath)).click();
        if (!$(By.xpath(logoutBtnXpath)).isDisplayed()) {
            mainPageSteps.clickLoginButton();
            loginSteps.iLoginAsAUser(userName);
            $(By.xpath(userBtnXpath)).click();
        }
    }

    @When("^I leave a comment in custom news comments form$")
    public void iLeaveACommentInCustomNewsCommentsForm() {
        mainPageSteps.iOpenTheMainPage();
        $(By.xpath(firstBigArticleXpath)).click();
        $(By.xpath(articleCommentsSectionXpath)).scrollIntoView(true);
        $(By.name(commentTextAreaName)).setValue(COMMENT);
        $(By.className(postCommentButtonClassName)).click();
    }

    @Then("^I verify my comment exists in the Comments subsection button on profile page$")
    public void iVerifyMyCommentExistsInTheCommentsSubsectionButtonOnProfilePage() {
        $(By.xpath(leftCommentXpath))
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text(COMMENT));
    }
}

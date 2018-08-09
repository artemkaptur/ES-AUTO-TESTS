package com.epam.esauto.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Value;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationSteps {

    @Value("${registrationPage.newPassword.xpath}")
    private String newPasswordXpath;

    @Value("${registrationPage.retypeNewPassword.xpath}")
    private String retypeNewPasswordXpath;

    @Value("${registrationPage.successfulChangePassword.message.id}")
    private String successfulChangePasswordMessageId;

    @Value("${registrationPage.submitPasswordChange.btn.id}")
    private String submitPasswordChangeBtnId;

    @And("^enter new password \"([^\"]*)\"$")
    public void enterNewPassword(String password) {
        $(By.xpath(newPasswordXpath)).setValue(password);
        $(By.xpath(retypeNewPasswordXpath)).setValue(password);
        $(By.id(submitPasswordChangeBtnId)).click();
    }

    @Then("^\"([^\"]*)\" successful password change message should be shown$")
    public void checkPasswordResetMessage(String message) {
        $(By.id(successfulChangePasswordMessageId)).shouldHave(text(message));
    }
}

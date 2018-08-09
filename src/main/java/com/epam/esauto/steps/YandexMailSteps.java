package com.epam.esauto.steps;

import static com.codeborne.selenide.Selenide.*;
import static com.epam.esauto.entity.UserProvider.getUser;

import com.epam.esauto.entity.User;
import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Value;

public class YandexMailSteps {

    @Value("${yandexLoginPage.login.input.name}")
    private String yandexloginName;

    @Value("${yandexLoginPage.password.input.name}")
    private String yandexPasswordName;

    @Value("${yandexLoginPage.submit.btn.xpath}")
    private String yandexSubmitLoginXpath;

    @Value("${yandexAccountPage.options.btn.xpath}")
    private String yandexAccountOptionsXpath;

    @Value("${yandexAccountPage.goToMail.btn.xpath}")
    private String yandexGoToMailBtnXpath;

    @Value("${yandexMessages.resetPassword.link.xpath}")
    private String resetPasswordLinkXpath;

    @And("^go to the mail box \"([^\"]*)\" and open reset password link$")
    public void goToTheMailBoxAndOpenResetPasswordLink(String userName) {
        User user = getUser(userName);
        open("https://passport.yandex.by/");
        $(By.name(yandexloginName)).setValue(user.getMailLogin());
        $(By.name(yandexPasswordName)).setValue(user.getMailPassword());
        $(By.xpath(yandexSubmitLoginXpath)).click();
        $(By.xpath(yandexAccountOptionsXpath)).click();
        $(By.xpath(yandexGoToMailBtnXpath)).click();
        refresh();
        $(By.xpath(resetPasswordLinkXpath)).click();
        switchTo().window(2);
    }
}

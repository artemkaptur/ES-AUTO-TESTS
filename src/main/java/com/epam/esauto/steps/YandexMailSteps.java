package com.epam.esauto.steps;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.epam.esauto.entity.UserProvider.getUser;
import static com.codeborne.selenide.Condition.*;

import cucumber.api.java.en.And;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.TimeUnit;

public class YandexMailSteps {

    @Value("${yandexLoginPage.url}")
    private String yandexLoginPageUrl;

    @Value("${yandexLoginPage.account.url}")
    private String yandexLoginPageAccountUrl;

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

    @Value("${yandexMessages.resetPassword.letter.xpath}")
    private String resetPasswordLetterXpath;

    @Value("${yandexMessages.resetPassword.link.xpath}")
    private String resetPasswordLinkXpath;

    @And("^go to the mail box \"([^\"]*)\" and open reset password link$")
    public void goToTheMailBoxAndOpenResetPasswordLink(String userName) {
        open(yandexLoginPageUrl);
        Wait<WebDriver> wait = new FluentWait<WebDriver>(getWebDriver())
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class);
        if (!url().equals(yandexLoginPageAccountUrl)) {
            $(By.name(yandexloginName)).setValue(getUser(userName).getMailLogin());
            $(By.name(yandexPasswordName)).setValue(getUser(userName).getMailPassword());
            $(By.xpath(yandexSubmitLoginXpath)).click();
            goToYandexMailBox();
            wait.until(driver -> {
                refresh();
                $(By.xpath(resetPasswordLetterXpath)).waitUntil(visible, 3000);
                return driver.findElement(By.xpath(resetPasswordLetterXpath));
            }).click();
            $(By.xpath(resetPasswordLinkXpath)).click();
        } else {
            goToYandexMailBox();
            Boolean resetPasswordLinksFound = wait.until(driver -> {
                refresh();
                $(By.xpath(resetPasswordLetterXpath)).waitUntil(visible, 3000);
                return driver.findElements(By.xpath(resetPasswordLetterXpath)).size() == 2;
            });
            Assert.assertTrue(resetPasswordLinksFound);
            getWebDriver().findElements(By.xpath(resetPasswordLetterXpath)).get(0).click();
            $(By.xpath(resetPasswordLinkXpath)).click();
        }
        switchTo().window("Reset Password");
    }

    private void goToYandexMailBox() {
        $(By.xpath(yandexAccountOptionsXpath)).click();
        $(By.xpath(yandexGoToMailBtnXpath)).click();
        getWebDriver().manage().window().maximize();
    }
}

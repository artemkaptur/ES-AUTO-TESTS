package com.epam.esauto.steps.account_management.login;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.epam.esauto.entity.UserProvider.getUser;

import cucumber.api.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.springframework.beans.factory.annotation.Value;

import java.time.Duration;

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

    @Value("${yandexMessages.icon.id}")
    private String yandexIconId;

    @And("^go to the mail box \"([^\"]*)\" and open reset password link$")
    public void goToTheMailBoxAndOpenResetPasswordLink(String userName) {
        open(yandexLoginPageUrl);
        Wait<WebDriver> waitOuter = new FluentWait<>(getWebDriver())
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(6))
                .ignoring(NoSuchElementException.class)
                .ignoring(org.openqa.selenium.TimeoutException.class);
        Wait<WebDriver> waitInner = new FluentWait<>(getWebDriver())
                .withTimeout(Duration.ofSeconds(3))
                .pollingEvery(Duration.ofMillis(600))
                .ignoring(NoSuchElementException.class);
        if (!url().equals(yandexLoginPageAccountUrl)) {
            $(By.name(yandexloginName)).setValue(getUser(userName).getMailLogin());
            $(By.name(yandexPasswordName)).setValue(getUser(userName).getMailPassword());
            $(By.xpath(yandexSubmitLoginXpath)).click();
        }
        goToYandexMailBox();
        openResetPasswordLink(waitOuter, waitInner);
        switchTo().window("Reset Password");
    }

    private void goToYandexMailBox() {
        $(By.xpath(yandexAccountOptionsXpath)).click();
        $(By.xpath(yandexGoToMailBtnXpath)).click();
        getWebDriver().manage().window().maximize();
    }

    private void openResetPasswordLink(Wait<WebDriver> waitOuter, Wait<WebDriver> waitInner) {
        WebElement linkElement = waitOuter.until(driver -> {
            refresh();
            return waitInner.until(driver1 -> driver1.findElement(By.xpath(resetPasswordLetterXpath)));
        });
        linkElement.click();
        $(By.xpath(resetPasswordLinkXpath)).click();
    }
}

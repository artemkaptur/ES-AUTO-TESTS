package com.epam.esauto.pages.home;

import com.epam.esauto.pages.AbstractPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MainPage extends AbstractPage {

    @FindBy(xpath = "//a[@class='logo']")
    private WebElement mainPageLogo;

    @Value("${mainPage.url}")
    private String mainPageUrl;

    @Override
    protected String getUrl() {
        return mainPageUrl;
    }

}

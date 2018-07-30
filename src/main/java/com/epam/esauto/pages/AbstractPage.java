package com.epam.esauto.pages;

import com.epam.esauto.actions.INavigateActions;
import com.epam.esauto.actions.ISearchActions;
import com.epam.esauto.driver.IDriverProvider;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public abstract class AbstractPage {

    @Autowired
    protected IDriverProvider driverProvider;
    
    @Autowired
    protected INavigateActions navigateActions;

    @Autowired
    protected ISearchActions searchActions;

    protected abstract String getUrl();

    @PostConstruct
    public void init() {
        PageFactory.initElements(driverProvider.get(), this);
    }

    public void openPage() {
        navigateActions.navigateTo(getUrl());
    }

    public boolean doesElementExists(String xpath) {
        return searchActions.findElement(xpath).isDisplayed();
    }
}

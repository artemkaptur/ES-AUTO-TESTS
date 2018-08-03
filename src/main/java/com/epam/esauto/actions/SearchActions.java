package com.epam.esauto.actions;

import com.epam.esauto.driver.IDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SearchActions implements ISearchActions {

    @Autowired
    private IDriverProvider driverProvider;

    @Override
    public WebElement findElement(String xpath) {
        return driverProvider.get().findElement(By.xpath(xpath));
    }
}

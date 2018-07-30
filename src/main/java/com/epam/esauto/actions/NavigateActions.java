package com.epam.esauto.actions;

import com.epam.esauto.driver.IDriverProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NavigateActions implements INavigateActions
{
    @Autowired
    private IDriverProvider driverProvider;

    @Override
    public void navigateTo(String url)
    {
        driverProvider.get().navigate().to(url);
    }
}

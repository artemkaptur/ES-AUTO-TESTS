package com.epam.esauto.cucumber.hooks;

import com.epam.esauto.driver.DriverProvider;
import cucumber.api.java.After;
import org.springframework.beans.factory.annotation.Autowired;

public class WebDriverHooks {

    @Autowired
    private DriverProvider driver;

    @After
    public void afterScenario() {
        driver.removeDriver();
    }
}

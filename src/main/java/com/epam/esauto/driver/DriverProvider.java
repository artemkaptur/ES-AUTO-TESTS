package com.epam.esauto.driver;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DriverProvider implements IDriverProvider {

    @Autowired
    private IDriverFactory driverFactory;

    private final ThreadLocal<Optional<WebDriver>> driverCache = ThreadLocal.withInitial(Optional::empty);

    @Override
    public WebDriver get() {
        return driverCache.get().orElseGet(() -> {
            WebDriver driver = driverFactory.createDriver();
            driverCache.set(Optional.of(driver));
            return driver;
        });
    }
}

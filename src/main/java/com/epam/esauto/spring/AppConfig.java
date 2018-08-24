package com.epam.esauto.spring;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = "com.epam.esauto")
@PropertySource({"classpath:mainpage.properties", "classpath:editprofile.properties", "classpath:content.properties",
        "classpath:homeprop.properties", "classpath:login.properties", "classpath:registration.properties",
        "classpath:headerFooter.properties", "classpath:yandex.properties"})
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

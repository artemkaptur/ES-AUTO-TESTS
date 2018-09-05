package com.epam.esauto.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = "com.epam.esauto")
@PropertySource({"classpath:editprofile.properties", "classpath:content.properties",
        "classpath:homeprop.properties", "classpath:login.properties", "classpath:registration.properties",
        "classpath:headerFooter.properties", "classpath:yandex.properties", "classpath:mobile.properties", "classpath:grid.properties"})
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

package com.epam.esauto.spring;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages =  "com.epam.esauto")
@PropertySources({
        @PropertySource("classpath:mainpage.properties"),
        @PropertySource("classpath:editprofile.properties"),
        @PropertySource("classpath:content.properties"),
        @PropertySource("classpath:homeprop.properties"),
        @PropertySource("classpath:login.properties"),
        @PropertySource("classpath:registration.properties"),
        @PropertySource("classpath:yandex.properties")})
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

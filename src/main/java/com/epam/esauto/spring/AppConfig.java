package com.epam.esauto.spring;

import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = "com.epam.esauto")
@PropertySource(value = { "classpath:editprofile.properties", "classpath:content.properties",
		"classpath:homeprop.properties", "classpath:login.properties", "classpath:registration.properties",
		"classpath:headerFooter.properties", "classpath:yandex.properties", "classpath:grid.properties",
		"classpath:mobile.properties", "classpath:searchProperties.properties", "classpath:goLondon.properties",
		"classpath:bookATicket.properties", "classpath:articleGoLondon.properties",
		"classpath:mobilenavigation.properties" }, encoding = "UTF-8")
public class AppConfig {
	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}

package org.bedoing.blog;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@SpringBootApplication
public class AppBoot extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AppBoot.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppBoot.class, args);
    }

    @Bean
    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new org.bedoing.blog.commons.PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocations(new Resource[] {
                new ClassPathResource("application.properties")}
        );

        return propertyPlaceholderConfigurer;
    }
}

/*@SpringBootApplication
public class AppBoot {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppBoot.class, args);
    }

    @Bean
    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new org.bedoing.blog.commons.PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocations(new Resource[] {
                new ClassPathResource("application.properties")}
        );

        return propertyPlaceholderConfigurer;
    }
}*/

package org.bedoing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
/*
@SpringBootApplication
public class FacadeBoot extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(FacadeBoot.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(FacadeBoot.class, args);
    }

    *//*@Bean
    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new org.bedoing.blog.commons.PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocations(new Resource[] {
                new ClassPathResource("application.properties")}
        );

        return propertyPlaceholderConfigurer;
    }*//*
}*/

@SpringBootApplication
public class FacadeBoot {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(FacadeBoot.class, args);
    }

    /*@Bean
    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new org.bedoing.blog.commons.PropertyPlaceholderConfigurer();
        propertyPlaceholderConfigurer.setLocations(new Resource[] {
                new ClassPathResource("application.properties")}
        );

        return propertyPlaceholderConfigurer;
    }*/
}

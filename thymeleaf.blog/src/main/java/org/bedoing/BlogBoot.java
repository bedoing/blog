package org.bedoing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class BlogBoot extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BlogBoot.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BlogBoot.class, args);
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

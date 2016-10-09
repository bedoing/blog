package org.bedoing.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*@SpringBootApplication
public class AppBoot extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AppBoot.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppBoot.class, args);
    }
}*/
@SpringBootApplication
public class AppBoot {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppBoot.class, args);
    }
}

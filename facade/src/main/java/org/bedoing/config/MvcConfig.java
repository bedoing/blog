package org.bedoing.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by ken on 10/10/2016.
 */
//@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
//    @Autowired
//    private LoginInterceptor loginInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor());
    }
}

package org.bedoing.blog.config;

import org.bedoing.blog.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by ken on 10/10/2016.
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
//    @Autowired
//    private LoginInterceptor loginInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInterceptor());
    }
}

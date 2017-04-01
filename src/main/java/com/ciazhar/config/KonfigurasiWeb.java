package com.ciazhar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by ciazhar on 3/30/17.
 */

@Configuration
public class KonfigurasiWeb extends WebMvcConfigurerAdapter{
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/aplikasi/list").setViewName("aplikasi/list");
        registry.addViewController("/aplikasi/form").setViewName("aplikasi/form");
    }
}

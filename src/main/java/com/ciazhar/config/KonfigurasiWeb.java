package com.ciazhar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;

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
        registry.addViewController("/versi/list").setViewName("versi/list");
        registry.addViewController("/versi/form").setViewName("versi/form");
        registry.addViewController("/bug/list").setViewName("bug/list");
    }

    @Bean
    public JasperReportsViewResolver getJasperReportsViewResolver(){
        JasperReportsViewResolver resolver = new JasperReportsViewResolver();
        resolver.setPrefix("classpath:/reports/");
        resolver.setSuffix(".jrxml");
        resolver.setViewNames("report_*");
        resolver.setViewClass(JasperReportsMultiFormatView.class);
        resolver.setOrder(0);
        return resolver;
    }
}

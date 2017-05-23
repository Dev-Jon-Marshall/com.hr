package com.astontech.hr.configuration;

import org.h2.server.web.WebServlet;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

/**
 * Created by Jonathan.Marshall on 3/8/2017.
 */
@Configuration
public class WebConfiguration
{
    @Bean
    ServletRegistrationBean h2servletRegistration()
    {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
        registrationBean.addUrlMappings("/console/*");

        return registrationBean;
    }

//    @Bean
//    ServletRegistrationBean swaggerServletRegistration()
//    {
//        ServletRegistrationBean registrationBean = new ServletRegistrationBean( new WebServlet());
//        registrationBean.addUrlMappings("/swagger-ui.html");
//
//        return registrationBean;
//    }
}
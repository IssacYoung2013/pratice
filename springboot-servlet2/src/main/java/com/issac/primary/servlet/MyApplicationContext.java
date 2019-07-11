package com.issac.primary.servlet;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 *
 * @author: ywy
 * @date: 2019-07-07
 * @desc:
 */
@Configuration
public class MyApplicationContext {

    @Bean
    public ServletRegistrationBean<SomeServlet> getServletBean() {
        return new ServletRegistrationBean<>(new SomeServlet(),"/some");
    }
}

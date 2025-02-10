package com.demo.operational.config;

import com.demo.operational.interceptor.SessionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private SessionInterceptor sessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Register the interceptor for all URLs except for login and registration
        registry.addInterceptor(sessionInterceptor)
                .excludePathPatterns("/login", "/logout", "/assets/**", "/public/**"); // Exclude login & static files
    }
}
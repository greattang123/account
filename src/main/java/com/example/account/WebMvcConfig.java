package com.example.account;

import com.example.account.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor li;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(li)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/login");

    }
}

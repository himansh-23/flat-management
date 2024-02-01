package com.flat.management.configuration;

import com.flat.management.configuration.filter.JwtAuthFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.inject.Inject;


@Configuration
public class AppConfiguration {


    @Inject
    private SecurityTokenManager securityTokenManager;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public FilterRegistrationBean<JwtAuthFilter> registerJwtAuthFilter(){
        FilterRegistrationBean<JwtAuthFilter> registrationBean  = new FilterRegistrationBean<>();
        registrationBean.setFilter(new JwtAuthFilter(securityTokenManager));
        registrationBean.addUrlPatterns("/*");
        return registrationBean;

    }
}

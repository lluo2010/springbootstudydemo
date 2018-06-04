package com.example.study.config;

import com.example.study.filter.CustomJacksonMessageConverter;
import com.example.study.filter.LoggingFilter;
import com.example.study.filter.WrapperRequestFilter;
import com.example.study.interceptor.ExecuteTimeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * Created by louis on 2018/5/30.
 */
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(applicationContext.getBean(SignInterceptor.class)).addPathPatterns("/**");
        registry.addInterceptor(applicationContext.getBean(ExecuteTimeInterceptor.class)).addPathPatterns("/**");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new CustomJacksonMessageConverter());
    }

    @Bean
    public FilterRegistrationBean requestFilterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        WrapperRequestFilter filter =new WrapperRequestFilter();
        registration.setFilter(filter);
        registration.addUrlPatterns("/*");
        registration.setName("requestFilter");
        registration.setOrder(1);
        return registration;
    }

    @Bean
    public FilterRegistrationBean encodeFilterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        CharacterEncodingFilter characterEncodingFilter =new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        registration.setFilter(characterEncodingFilter);
        registration.addUrlPatterns("/*");
        registration.setName("encodeFilter");
        registration.setOrder(2);
        return registration;
    }

    @Bean
    public FilterRegistrationBean loggingFilterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        LoggingFilter loggingFilter =new LoggingFilter();
        registration.setFilter(loggingFilter);
        registration.addUrlPatterns("/*");
        registration.setName("loggingFilter");
        registration.setOrder(3);
        return registration;
    }

}

package com.example.study.config;

import com.example.study.filter.MyFilter;
import com.example.study.model.UserInfo;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by louis on 2018/5/30.
 */
@Configuration
public class AppConfig {

    /*@Bean
    public FilterRegistrationBean myFilterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        MyFilter filter = new MyFilter();
        registration.setFilter(filter);
        registration.addUrlPatterns("*//*");
        registration.setName("myFilter");
        registration.setOrder(1);
        return registration;
    }
*/

    @Bean
    public UserInfo userInfo(){
        return new UserInfo();
    }

}

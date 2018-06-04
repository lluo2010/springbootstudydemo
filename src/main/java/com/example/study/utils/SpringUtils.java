package com.example.study.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by john on 17-1-10.
 */
@Configuration
public class SpringUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext arg0) throws BeansException {
        if (SpringUtils.applicationContext == null) {
            SpringUtils.applicationContext = arg0;
        }
    }

    // 获取applicationContext
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    // 通过name获取 Bean.
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    // 通过class获取Bean.
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    // 通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

    public static boolean isProdProfilesActive(){
        return getSpringProfilesActive().contains("prod");
    }

    public static boolean isProdProfilesActive(String profile){
        return profile.contains("prod");
    }

    private static List<String> getSpringProfilesActive(){
        return Arrays.stream(getApplicationContext().getEnvironment().getActiveProfiles()).collect(Collectors.toList());
    }
}

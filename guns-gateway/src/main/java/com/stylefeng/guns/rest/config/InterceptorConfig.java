package com.stylefeng.guns.rest.config;

import com.stylefeng.guns.rest.intercepter.MyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Autowired
    MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor).addPathPatterns("/user/getUserInfo","/user/updateUserInfo","/order/buyTickets","/order/");
        super.addInterceptors(registry);
    }
}

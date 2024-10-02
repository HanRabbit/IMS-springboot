package com.itzhy.config;

import com.itzhy.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration//配置类
public class WebConfig implements WebMvcConfigurer {
@Autowired
    private LoginCheckInterceptor loginCheckFilter;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(loginCheckFilter).addPathPatterns("/nonexistentpath");//.addPathPatterns("/**").addPathPatterns("/login").addPathPatterns("/register");.addPathPatterns("/nonexistentpath");
    }
}

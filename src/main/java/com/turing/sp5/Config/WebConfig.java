package com.turing.sp5.Config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@MapperScan("com.turing.sp5.mapper")
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("user/**")
                                                       .excludePathPatterns("/login","/css/**","/user/login1","/js/**","/user/login");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/user").setViewName("login1");
        registry.addViewController("/user/index").setViewName("index");
        registry.addViewController("/login2").setViewName("login2");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/index2").setViewName("index2");
        registry.addViewController("/nav").setViewName("nav");
        registry.addViewController("/index3").setViewName("index3");
        registry.addViewController("/depts").setViewName("depts");
    }
}

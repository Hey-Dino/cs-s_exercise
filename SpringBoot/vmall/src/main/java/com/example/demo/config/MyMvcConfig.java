package com.example.demo.config;

import com.example.demo.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

//    @Bean
    public WebMvcConfigurer webMvcConfigurerAdapter(){
        WebMvcConfigurer adapter = new WebMvcConfigurer() {
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("login");
//                registry.addViewController("/index").setViewName("index");
//            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //静态资源：*.css ，*.js
                //SpringBoot已经做好了静态资源映射
                registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/","/login");
            }

        };
        return adapter;
    }

}

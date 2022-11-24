package com.zr.ssm.config;

import com.zr.ssm.interceptor.HeaderInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan({"com.zr.ssm.controller", "com.zr.ssm.controlleradvisor","com.zr.ssm.interceptor"})
// 开启自动转换json数据的支持
@EnableWebMvc
public class SpringMVCConfig implements WebMvcConfigurer {

    @Autowired
    HeaderInterceptor headerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 向 springmvc 登记拦截什么请求， 除了 /api 的请求， 其他请求 全部拦截
        // registry.addInterceptor(helloInterceptor).addPathPatterns("/**").excludePathPatterns("/api/**");
        // 拦截样式 /my/** :  就是 /my下面 任意层级  /my/aaa/bbb
        //  /my/*    /my/userinfo
        registry.addInterceptor(headerInterceptor).addPathPatterns("/my/**");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/**").addResourceLocations("uploads/");
        // registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        // registry.addResourceHandler("/js/**").addResourceLocations("/js/");
    }

    @Bean
    // 配置 上传文件解析器
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver cmr = new CommonsMultipartResolver();
        // 设置 上传文件的 最大size
        cmr.setMaxUploadSize(5*1024*1024);
        return cmr;
    }

}

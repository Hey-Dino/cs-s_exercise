package com.zr.ssm.config;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.Filter;

public class ServletContentInitConfig extends AbstractDispatcherServletInitializer {
    @Override
    //创建springmvc容器
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext mvcAC = new AnnotationConfigWebApplicationContext();
        //web项目可以将控制器加载到容器里
        //springmvc容器的初始化
        mvcAC.register(SpringMVCConfig.class);
        return mvcAC;
    }

    @Override
    //servlet的url过滤器，就是什么样的url交给springmvc处理
    protected String[] getServletMappings() {
        //代表所有的请求交给mvc处理
        return new String[]{"/"};
    }

    @Override
    //创建一个spring容器
    protected WebApplicationContext createRootApplicationContext() {
        //创建一个spring容器
        AnnotationConfigWebApplicationContext springAC = new AnnotationConfigWebApplicationContext();
        springAC.register(SpringConfig.class);
        return springAC;
    }

    //编码过滤器
    @Override
    protected Filter[] getServletFilters() {

        // 使用 spring mvc 提供一个 编码的过滤器， 所有的 请求的 参数都不会乱码
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("utf-8");
        return new Filter[] {filter};
    }
}

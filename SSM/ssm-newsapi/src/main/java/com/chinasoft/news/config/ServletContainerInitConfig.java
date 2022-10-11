package com.chinasoft.news.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class ServletContainerInitConfig  extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    // 加载 spring 容器
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    @Override
    // 加载 spring MVC 容器
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    @Override
    // servlet的请求过滤器，此处代表所有URL请求都交给 springMVC 处理
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected Filter[] getServletFilters() {
        // 使用 spring mvc 提供一个 编码的过滤器， 所有的 post请求的 参数都不会乱码
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("utf-8");

        return new Filter[] {filter};
    }
}

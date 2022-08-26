package com.dino.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo02 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // System.out.println("02-FilterDemo...Before");
        // 放行
        filterChain.doFilter(servletRequest, servletResponse);
        // System.out.println("02-FilterDemo...After");
    }

    @Override
    public void destroy() {

    }
}

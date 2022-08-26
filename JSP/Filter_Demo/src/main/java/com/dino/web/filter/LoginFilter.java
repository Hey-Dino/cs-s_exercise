package com.dino.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        // 1.在数组中存储与登录、注册相关的资源
        String[] urls = {"/imgs", "/css","/login.jsp", "/loginServlet", "register.jsp","/registerServlet", "/checkCodeServlet"};
        // 2.获取请求路径
        String url = req.getRequestURL().toString();
        // 3.遍历数组，判断请求路径是否在放行列表
        for (String u : urls) {
            if (url.contains(u)) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }

        // 1.判断 Session 中是否有User
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        // 2.判断 User 是否为null
        if (user == null) {
            // req.setAttribute("login_msg", "您尚未登录！");
            resp.sendRedirect("/login.jsp");
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}

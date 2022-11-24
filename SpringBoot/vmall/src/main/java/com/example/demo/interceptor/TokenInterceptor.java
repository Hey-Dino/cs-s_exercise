package com.example.demo.interceptor;

import com.example.demo.entity.Rbody;
import com.example.demo.util.JwtUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURL());
        String method = request.getMethod();
        if ("options".equalsIgnoreCase(method)) {
            return true;
        }
        String token = request.getHeader("Authorization");
        if (token != null && token.length() > 0 && JwtUtil.verifyToken(token)) {
            String strId = JwtUtil.getAudience(token);
            request.setAttribute("userId", strId);
            return true;
        }
        // 令牌是空的
        final Rbody ret = new Rbody();
        ret.getMeta().setStatus(500);
        ret.getMeta().setMsg("令牌无效  ！");
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        final PrintWriter writer = response.getWriter();
        writer.write(new ObjectMapper().writeValueAsString(ret));
        writer.flush();

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("通过了");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

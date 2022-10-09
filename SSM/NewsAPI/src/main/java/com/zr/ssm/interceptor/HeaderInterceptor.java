package com.zr.ssm.interceptor;

import com.zr.ssm.customex.BussinessException;
import com.zr.ssm.pojo.ExType;
import com.zr.ssm.utils.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class HeaderInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        //放行跨域预检请求
        if (method.equalsIgnoreCase("options")) {
            return true;
        }
        String token = request.getHeader("Authorization");
        if (token == null)
            throw new BussinessException("invalid token", ExType.BussInvalidToken);
        boolean b = JwtUtils.verifyToken(token);
        if (!b)
            throw new BussinessException("invalid token", ExType.BussInvalidToken);
        Integer userId = Integer.parseInt(JwtUtils.getAudience(token));
        request.setAttribute("userId", userId);
        return true;
    }
}

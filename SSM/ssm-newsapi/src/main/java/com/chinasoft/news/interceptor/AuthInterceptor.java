package com.chinasoft.news.interceptor;

import com.chinasoft.news.customexception.BussinessException;
import com.chinasoft.news.pojo.ExType;
import com.chinasoft.news.utils.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 中软zhang
 * @create 2022-09-28 10:43
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        if (method.equalsIgnoreCase("options")) {
            return true;
        }
        String token = request.getHeader("Authorization");
        if (token == null) {
            throw  new BussinessException("invalid token from interceptor",
                    ExType.BussInvalidToken);
        }
        System.out.println("in pre handler ...");
        System.out.println(token);
        if (!JwtUtils.verifyToken(token)) {
            System.out.println("token 无效");
            throw  new BussinessException("invalid token from interceptor",
                    ExType.BussInvalidToken);
        }
        String strId = JwtUtils.getAudience(token);
        // 使用 ThreadLocal
        request.setAttribute("userId", Integer.parseInt(strId));
        // 请求放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}

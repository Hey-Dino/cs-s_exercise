package com.dino;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/aCookieServlet")
public class ACookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建Cookie对象
        //  - Tomcat8之前不支持中文编码
        Cookie cookie = new Cookie("username", "佩奇");
        //

        // 设置存活时间
        //  - setMaxAge() 参数以 second 为单位
        //  - 默认存活时间 为当前浏览器的存活时间
        // cookie.setMaxAge(604800);   // 不易阅读(可通过注解弥补)，但可以减少程序计算量
        cookie.setMaxAge(60*60*24*7);

        // 将Cookie加入到响应体
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

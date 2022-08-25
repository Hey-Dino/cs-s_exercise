package com.dino;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/bCookieServlet")
public class BSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求行携带的所有 Cookie
        Cookie[] cookies = req.getCookies();
        // 遍历 cookies，获取键和值
        for (Cookie cookie : cookies) {
            String name = cookie.getName();     // Cookie 名称
            String value = cookie.getValue();   // Cookie 值
            System.out.println(name + ": " + value);
        }

        // 将获取到的所有Cookie响应给客户端
        resp.getWriter().write(cookies.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

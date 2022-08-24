package com.dino;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/resp1")
public class RequestDirection01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("请求重定向 resp1...");
        /*// 1.设置响应行的请求状态码为302，表示重定向
        resp.setStatus(302);
        // 2.设置响应头的Location为"/req7"，表示重定向到/req7
        resp.setHeader("Location", "/Tomcat_Demo02_war/resp2");*/

        // 简写形式
        // 动态获取、配置虚拟目录
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath + "/resp2");

        /*
        * - 浏览器使用路径：需要添加虚拟目录，因而【请求重定向】需要
        * - 服务端使用路径：不需添加虚拟目录，因而【请求转发】不需要
        * */
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

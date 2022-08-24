package com.dino;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/req2")
public class ServletDemo02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数
        String params = "";
        // 请求方式
        String method = req.getMethod();

        // 根据请求方式，执行不同请求参数获取操作
        if ("GET".equals(method)) {
            params = req.getQueryString();
        } else if ("POST".equals(method)) {
            BufferedReader reader = req.getReader();
            params = reader.readLine();
        }

        System.out.println("\nServletDemo02.java:\n");
        System.out.println("请求参数：" + params);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

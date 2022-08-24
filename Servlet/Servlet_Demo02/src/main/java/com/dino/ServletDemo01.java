package com.dino;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/req1")
public class ServletDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 使用req对象，获取get请求数据
        String name = req.getParameter("name");
        // 设置响应体头部，编码中文乱码
        resp.setHeader("Content-type", "text/html;charset=utf-8");
        // 将具体内容响应给客户端
        resp.getWriter().write("<h1>" + name + ", 欢迎你！</h1>");  // getWriter() 字符输出流

        System.out.println("\n----请求行 相关信息----");
        System.out.println("请求方式：" + req.getMethod());  // GET
        System.out.println("请求参数：" + req.getQueryString());     // name=Dino
        System.out.println("访问路径：" + req.getContextPath());     // /Tomcat_Demo02_war
        System.out.println("统一资源标识符URI：" + req.getRequestURI());    // Tomcat_Demo02_war/ServletDemo01
        System.out.println("统一资源定位符URL：" + req.getRequestURL());    // http://localhost:8080/Tomcat_Demo02_war/ServletDemo01

        System.out.println("----请求头 相关信息----");
        System.out.println("浏览器版本信息：" + req.getHeader("user-agent"));   // Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("----请求体 相关信息（get请求无请求体）----");
        // 1.获取字符输入流
        BufferedReader br = req.getReader();
        // 2.读取数据
        String line = br.readLine();// line: name=Dino&age=22
        System.out.println("POST请求-后台读取到的数据：" + line);
    }
}

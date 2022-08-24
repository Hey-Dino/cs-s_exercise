package com.dino;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/req3")
public class ServletDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置字符输入流的编码，设置的字符集要和页面保持一致
        req.setCharacterEncoding("UTF-8");
        // 设置响应体的编码格式
        resp.setHeader("Content-type", "text/html;charset=utf-8");

        // 1.获取携带所有请求参数的集合
        Map<String, String[]> map = req.getParameterMap();

        for (String key:map.keySet()) {
            System.out.print(key + ": ");

            String[] values = map.get(key);
            for (String value : values) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        String hobby = req.getParameter("hobby");
        System.out.println("getParameter(\"hobby\"):" + hobby);

        /*
        * 另外两个方法：
        *   1.String[] getParameterValues(String name)  // 根据名称获取参数值（返回数组）
        *   2.String getParameter(String name)  // 根据名称获取参数值（返回单个值）,key对应多个值时，只取第一个值
        * */
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

package com.dino.web.servlet;

import com.alibaba.fastjson.JSON;
import com.dino.pojo.User;
import com.dino.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/selectUser")
public class SelectUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取用户姓名
        String username = req.getParameter("username");

        UserService userService = new UserService();
        User user = userService.selectByUsername(username);
        System.out.println(user);

        if (user != null) {
            resp.setContentType("text/json;charset=UTF-8");
            String s = JSON.toJSONString("1");
            resp.getWriter().write("1");
        } else {
            resp.setContentType("text/json;charset=UTF-8");
            String s = JSON.toJSONString("0");
            resp.getWriter().write(s);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

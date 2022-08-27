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

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置请求编码格式，避免从客户端传过来的中文乱码
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/json;charset=UTF-8");

        //  获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");

        // 通过Session，获取程序生成的验证码
        String checkCodeGen = (String) req.getSession().getAttribute("checkCodeGen");

        // 判断用户输入的验证码是否正确
        if (!checkCodeGen.equalsIgnoreCase(checkCode)) {
            /*req.setAttribute("checkCode_err", true);
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            // 直接退出
            return;*/

            String s = JSON.toJSONString("1");
            resp.getWriter().write(s);
            return;
        }

        UserService userService = new UserService();
        User selectedUser = userService.selectByUsername(username);

        // 判断用户名是否已存在
        if (selectedUser != null) {
            String s = JSON.toJSONString("2");
            resp.getWriter().write(s);
        } else {
            String s = JSON.toJSONString("0");
            resp.getWriter().write(s);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

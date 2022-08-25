package com.dino.web;

import com.dino.pojo.User;
import com.dino.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserService userService = new UserService();
        User selectedUser = userService.selectByUsername(username);

        if (selectedUser != null) {
            req.setAttribute("err", true);
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        } else {
            userService.insertUser(username, password);
            resp.sendRedirect("/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

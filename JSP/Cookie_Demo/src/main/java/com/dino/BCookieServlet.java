package com.dino;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/bSessionServlet")
public class BCookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.获取 Session 对象
        HttpSession session = req.getSession();
        // 2.获取数据
        Object username = session.getAttribute("username");

        // 3.销毁 Session 对象
        // session.invalidate();
        // 4.重新获取数据，报错：会话已失效
        // Object username1 = session.getAttribute("username");

        resp.getWriter().write(username.toString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

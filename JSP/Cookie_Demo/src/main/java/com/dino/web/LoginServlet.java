package com.dino.web;

import com.dino.pojo.User;
import com.dino.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int maxAge = 60 * 5;

        req.setCharacterEncoding("UTF-8");
        // 通过请求参数获取 用户名 和 密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // 调用 UserService，根据获取到的 用户名 和 密码 查询用户
        UserService userService = new UserService();
        User user = userService.selectUser(username, password);

        // 设置响应头，防止中文乱码
        // resp.setHeader("Content-type", "text/html;charset=utf-8");
        if (user == null) {     /* 登录失败 */
            req.setAttribute("err", true);
            // 将携带错误信息的请求头重新转发到 login.jsp
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            // 获取复选框数据
            String remember = req.getParameter("remember");
            // 创建Cookie对象
            Cookie c_username, c_password, c_remember;

            if ("1".equals(remember)) {     /* 已勾选记住 */
                // 1.为Cookie对象赋值
                c_username = new Cookie("username", username);
                c_password = new Cookie("password", password);
                c_remember = new Cookie("remember", remember);
                // 2.设置Cookie存活时间
                c_username.setMaxAge(maxAge);
                c_password.setMaxAge(maxAge);
                c_remember.setMaxAge(maxAge);
            } else {
                // 覆盖原先的Cookie
                c_username = new Cookie("username", "");
                c_password = new Cookie("password", "");
                c_remember = new Cookie("remember", "0");
                // 立即销毁Cookie
                c_username.setMaxAge(0);
                c_password.setMaxAge(0);
                c_remember.setMaxAge(0);
            }
            // 3.在响应头中加入Cookie
            resp.addCookie(c_username);
            resp.addCookie(c_password);
            resp.addCookie(c_remember);

            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            // 重定向
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

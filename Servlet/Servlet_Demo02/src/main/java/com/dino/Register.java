package com.dino;

import com.dino.mapper.UserMapper;
import com.dino.pojo.User;
import com.dino.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(null, username, password, null, null);

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User selectResult = mapper.selectByUsername(username);

        resp.setHeader("Content-type", "text/html;charset=UTF-8");
        if (selectResult != null) {
            // 用户名已存在，提示用户
            resp.getWriter().write("用户名已存在！");
        } else {
            // 用户名不存在，插入用户
            mapper.insertUser(user);
            resp.getWriter().write("用户添加成功！");
        }

        // 释放资源
        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

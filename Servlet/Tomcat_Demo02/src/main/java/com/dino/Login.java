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

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.接收 用户名 和 密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 2.生成 mapper 对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 3.调用方法
        User user = mapper.select(username, password);
        // 4.响应内容
        resp.setHeader("Content-type","text/html;charset=UTF-8");
        if (user != null) {
            resp.getWriter().write("登录成功");
        } else {
            resp.getWriter().write("登录失败");
        }
        // 5.释放资源
        sqlSession.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

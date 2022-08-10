package com.dino.jdbc;

import java.sql.*;

public class JDBCDemo05_prepareStatement {
    public static void main(String[] args) throws Exception {
        // 建立连接
        String url = "jdbc:mysql://127.0.0.1:3306/demo_cs?useSSL=false";
        String username = "root";
        String password = "w442395";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 定义SQL语句
        String sql = "SELECT * FROM account WHERE name = ? and password = ?";

        // 建立SQL语句执行对象
        String name = "张三";
        String pwd = "' or '1' = '1";   // 注入失败，登录失败
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, pwd);

        // 执行SQL
        ResultSet rs = ps.executeQuery();

        // 判断是否登录成功
        if (rs.next()) {
            System.out.println("登录成功");
        } else {
            System.out.println("登录失败");
        }

        // 释放资源
        rs.close();
        ps.close();
        conn.close();
    }
}

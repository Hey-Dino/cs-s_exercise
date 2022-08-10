package com.dino.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCDemo01 {
    public static void main(String[] args) throws Exception {
        // 1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2.获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/demo_cs?useSSL=false";
        String username = "root";
        String password = "w442395";
        Connection conn = DriverManager.getConnection(url, username, password);

        System.out.println(conn);
    }
}

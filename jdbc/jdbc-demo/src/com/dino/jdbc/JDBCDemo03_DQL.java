package com.dino.jdbc;

import java.sql.*;

public class JDBCDemo03_DQL {
    public static void main(String[] args) throws Exception {
        // 1.注册驱动，可以省略
        // Class.forName("com.mysql.jdbc.Driver");

        // 2.获取连接
        String url = "jdbc:mysql:///demo_cs?useSSL=false";
        String username = "root";
        String password = "w442395";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3.定义SQL
        String sql = "SELECT * FROM account";

        // 4.获取 statement 对象
        Statement statement = conn.createStatement();

        // 5.执行 SQL 语句
        ResultSet rs = statement.executeQuery(sql);

        // 6.遍历结果
        while (rs.next()) {
            int id = rs.getInt("id");   // 通过列名获取
            String name = rs.getString(2);  // 通过索引值(从1开始)获取
            double money = rs.getDouble("money");

            System.out.println(id + " " + name + " " + money);
        }

        // 7.释放资源
        rs.close();
        statement.close();
        conn.close();
    }
}

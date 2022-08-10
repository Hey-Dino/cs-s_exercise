package com.dino.jdbc;

import com.dino.pojo.User;

import java.sql.*;
import java.util.ArrayList;

public class JDBCDemo04 {
    public static void main(String[] args) throws Exception {
        // 1.注册驱动
        // Class.forName("com.mysql.jdbc.Driver");

        // 2.建立连接
        String url = "jdbc:mysql://127.0.0.1:3306/demo_cs?useSSL=false";
        String username = "root";
        String password = "w442395";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3.定义SQL语句
        String sql = "SELECT * FROM account";

        // 4.创建执行SQL语句的Statement对象
        Statement statement = conn.createStatement();

        // 5.执行SQL语句
        ResultSet rs = statement.executeQuery(sql);

        // 6.创建集合，用于存储获取到的数据
        ArrayList<User> list = new ArrayList<>();

        // 7.将数据存储到集合中
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            double money = rs.getDouble("money");

            list.add(new User(id, name, money));
        }

        System.out.println("ArrayList: " + list);

        // 8.释放资源
        rs.close();
        statement.close();
        conn.close();
    }
}

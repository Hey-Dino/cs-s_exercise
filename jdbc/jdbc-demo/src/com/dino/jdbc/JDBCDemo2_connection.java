package com.dino.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo2_connection {
    public static void main(String[] args) throws Exception {
        // 1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        // 2.获取连接，如果连接的是本机mysql且端口号为默认的3306，可以简写(注意要多写一个/)
        String url = "jdbc:mysql:///demo_cs?useSSL=false";
        String username = "root";
        String password = "w442395";
        Connection conn = DriverManager.getConnection(url, username, password);

        // 3.定义SQL
        String sql1 = "UPDATE account SET money=money-500 WHERE name=\"张三\"";
        String sql2 = "UPDATE account SET money=money+500 WHERE name=\"李四\"";

        // 4.获取执行SQL的对象 Statement
        Statement statement = conn.createStatement();
        try {
            conn.setAutoCommit(false);  // 开启事务
            // 5.执行SQL语句
            int count1 = statement.executeUpdate(sql1);
            int result = 1 / 0;     // 产生一个错误，触发事务回滚
            int count2 = statement.executeUpdate(sql2);
            System.out.println("修改结果-1：" + count1);   // 输出处理结果
            System.out.println("修改结果-2：" + count2);   // 输出处理结果

            conn.commit();      // 提交事务
        } catch (SQLException e) {
            conn.rollback();    // 若出现异常，则回滚事务
            e.printStackTrace();
        } finally {
            // 6.释放资源
            statement.close();
            conn.close();
        }
    }
}

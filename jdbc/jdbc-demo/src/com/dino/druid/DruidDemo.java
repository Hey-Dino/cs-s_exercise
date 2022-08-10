package com.dino.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws Exception {
        // 1.导入jar包，并右击，Create Library
        // 2.定义配置文件 druid.properties
        // 3.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo//src//com//dino//druid.properties"));

        // 4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        // 5.获取数据库连接
        Connection conn = dataSource.getConnection();

        System.out.println(conn);
    }
}

package com.dino.utils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtils {
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;

        try {
            // 加载核心注册文件
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            // 生成 SQL会话工厂
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
            // 生成 SQL会话
            sqlSession = sessionFactory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sqlSession;
    }
}


package com.dino;

import com.dino.mapper.UserMapper;
import com.dino.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MyBatisTest {
    /*
    * 若要实现事务自动提交的功能，可在sqlSessionFactory.openSession()方法中添加参数：true
    * */

    @Test
    public void testSelect() throws IOException {
        // 1.加载核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 2.获取 sqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        // 3.获取 sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        // 4.获取 SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 5.获取 UserMapper 接口对象，getMapper底层会实现接口
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 6.测试功能
        /*ArrayList<User> users = userMapper.selectAll();
        users.forEach(user -> System.out.println(user));*/
        User user = userMapper.selectById();
        System.out.println("查询单个用户：" + user);

        // 7.提交事务
        sqlSession.commit();

    }


    @Test
    public void testInsert() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        userMapper.insertUser();
    }

    @Test
    public void testUpdate() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.updateUser();
    }

    @Test
    public void testDelete() throws IOException{
        // 定义核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 获取 sql会话工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        // 获取 sql会话
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        // 获取接口的对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行 SQl语句
        userMapper.deleteUser();
    }
}

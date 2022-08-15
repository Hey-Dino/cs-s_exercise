package com.dino.test;

import com.dino.mapper.SpecialSqlMapper;
import com.dino.pojo.User;
import com.dino.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SpecialSqlMapperTest {
    @Test
    public void testGetUserByLike(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        List<User> users = mapper.getUserByLike("三");
        System.out.println(users);
    }

    @Test
    public void testDeleteMore(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        int result = mapper.deleteMore("5,6,7");
        System.out.println(result);
    }

    @Test
    public void testGetUserByTagName(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        List<User> users = mapper.getUserByTagName("user");
        System.out.println(users);
    }

    // 测试获取添加功能自增的主键
    @Test
    public void testInsertUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialSqlMapper mapper = sqlSession.getMapper(SpecialSqlMapper.class);
        User user = new User(0, "Dino", "123456", "男", "潮州");
        mapper.insertUser(user);
        System.out.println(user);   // User{id=7, username='Dino', password='123456', gender='男', addr='潮州'}
    }
}

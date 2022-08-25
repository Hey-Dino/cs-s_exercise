package com.dino.service;

import com.dino.mapper.UserMapper;
import com.dino.pojo.User;
import com.dino.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

public class UserService {
    public User selectByUsername(String name) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByUsername(name);

        sqlSession.close();

        return user;
    }

    public User selectUser(String name, String password) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectUser(name, password);

        sqlSession.close();

        return user;
    }

    public int insertUser(String username, String password) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result = mapper.insertUser(username, password);

        return result;
    }
}

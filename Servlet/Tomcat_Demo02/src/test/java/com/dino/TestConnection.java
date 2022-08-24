package com.dino;

import com.dino.mapper.UserMapper;
import com.dino.pojo.User;
import com.dino.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestConnection {
    @Test
    public void Test01(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.queryAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
}

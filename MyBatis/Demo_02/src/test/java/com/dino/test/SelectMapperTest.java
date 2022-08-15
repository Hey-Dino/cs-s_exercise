package com.dino.test;

import com.dino.mapper.ParameterMapper;
import com.dino.mapper.SelectMapper;
import com.dino.pojo.User;
import com.dino.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTest {
    public static SelectMapper getSelectMapper(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);

        return mapper;
    }

    @Test
    public void testGetUserById(){
        SelectMapper mapper = getSelectMapper();

        User user = mapper.getUserById("1");
        System.out.println(user);
    }

    @Test
    public void testGetAllUser(){
        SelectMapper mapper = getSelectMapper();

        List<User> users = mapper.getAllUsers();
        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void testGetCount(){
        SelectMapper mapper = getSelectMapper();

        int count = mapper.getCount();
        System.out.println(count);
    }

    @Test
    public void testGetUserByIdToMap(){
        SelectMapper mapper = getSelectMapper();

        Map<String, Object> userMap = mapper.getUserByIdToMap("1");
        System.out.println(userMap);
    }



    @Test
    public void testGetAllUserToMapList(){
        SelectMapper mapper = getSelectMapper();

        List<Map<String, Object>> userList = mapper.getAllUserToMapList();
        System.out.println(userList);
    }

    @Test
    public void testGetAllUserToMap(){
        SelectMapper mapper = getSelectMapper();

        Map<String, Object> userMap = mapper.getAllUserToMap();
        System.out.println(userMap);
    }
}

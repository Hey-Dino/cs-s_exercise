package com.dino.test;

import com.dino.utils.SqlSessionUtils;
import com.dino.mapper.ParameterMapper;
import com.dino.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParameterMapperTest {
    /*
    * MyBatis 获取参数值的各种情况：
    *   1.mapper接口方法的参数为单个的字面量类型
    *       可以通过$() 和 #{}方法获取参数值
    *       注意：
    *           (1).使用#{}时，参数名可以任意名称，而使用${}时，参数名必须为value
    *           (2).使用${}时，需要在两侧加上单引号''
    *
    *   2.mapper接口方法的参数为多个时：
    *     此时，Mybatis会把这些参数存放在一个map集合中，以两种方式存储
    *           (1).以arg0, arg1, ...作为键存储
    *           (2).以param1, param2, ...作为键存储
    *     例如，通过 #{arg0} 或 '${param1}' 即可访问同一值
    *
    *   3.mapper接口方法的参数为多个时:
    *     可以将【map集合】作为该方法的参数
    *     此时，通过 #{username} 或 '${username}' 即可访问同一值
    *
    *   4.mapper接口方法的参数为多个时
    *     可以将【实体类型】作为该放的参数
    *
    *   5.mapper接口方法的参数为多个时
    *     可以使用@Param注解命名参数，例如：@Param("username") String username
    *     此时，MyBatis仍是把这些数据存放在一个map集合中，以如下两种方式存储：
    *           (1).以username, ...作为键存储
    *           (2).以param1, param2, ...作为键存储
    *     例如，通过 #{username} 或 '${param1}' 即可访问同一值
    *
    * */

    public static ParameterMapper getParameterMapper(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);

        return mapper;
    }

    @Test
    public void testQueryAll(){
        ParameterMapper mapper = getParameterMapper();
        List<User> users = mapper.queryAll();
        users.forEach(user -> System.out.println(user));
    }

    @Test
    public void testQueryUserByUsername(){
        ParameterMapper mapper = getParameterMapper();

        User user = mapper.queryUserByUsername("张三");
        System.out.println(user);
    }

    @Test
    public void testCheckLogin(){
        ParameterMapper mapper = getParameterMapper();

        User user = mapper.checkLogin("张三", "123");
        System.out.println(user);
    }

    @Test
    public void testCheckLoginByMap(){
        ParameterMapper mapper = getParameterMapper();

        Map<String, Object> map = new HashMap<>();
        map.put("username", "张三");
        map.put("password", "123");

        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        ParameterMapper mapper = getParameterMapper();

        int result = mapper.insertUser(new User(0,"迪诺", "123", "男", "广州"));
        System.out.println(result);
    }

    @Test
    public void testCheckLoginByParam(){
        ParameterMapper mapper = getParameterMapper();

        User user = mapper.checkLoginByParam("张三", "123");
        System.out.println(user);
    }
}

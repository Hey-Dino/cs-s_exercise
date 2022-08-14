package com.dino.mapper;

import com.dino.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ParameterMapper {
    List<User> queryAll();

    User queryUserByUsername(String username);

    User checkLogin(String username, String password);

    // 使用【Map】
    User checkLoginByMap(Map<String, Object> map);

    // 使用【实体类对象】
    int insertUser(User user);

    // 使用【注解方法】
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
}

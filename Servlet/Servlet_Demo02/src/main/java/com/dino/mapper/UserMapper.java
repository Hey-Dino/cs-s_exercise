package com.dino.mapper;

import com.dino.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    List<User> queryAll();

    @Select("SELECT * FROM user WHERE username=#{username} AND password=#{password}")
    User select(@Param("username") String username, @Param("password") String password);

    @Select("SELECT * FROM user WHERE username=#{username}")
    User selectByUsername(String username);

    @Select("INSERT INTO user(id, username, password, gender, addr) VALUES(null, #{username}, #{password}, #{gender}, #{addr})")
    int insertUser(User user);
}

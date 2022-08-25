package com.dino.mapper;

import com.dino.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("SELECT * FROM user WHERE username=#{username}")
    User selectByUsername(@Param("username") String username);

    @Select("SELECT * FROM user WHERE username=#{username} AND password=#{password}")
    User selectUser(@Param("username") String username,@Param("password") String password);

    @Insert("INSERT INTO user(username, password) VALUES(#{username}, #{password})")
    int insertUser(@Param("username") String username,@Param("password") String password);
}

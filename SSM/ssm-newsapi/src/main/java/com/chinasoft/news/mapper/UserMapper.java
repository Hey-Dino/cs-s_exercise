package com.chinasoft.news.mapper;

import com.chinasoft.news.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;


public interface UserMapper {
    // @Insert("insert into ev_users(username, password, nickname, email, user_pic) " +
    @Insert("INSERT INTO ev_users(id, username, password, nickname, email, user_pic) " +
            "VALUES(null, #{username}, #{password}, #{nickname}, #{email}, #{user_pic})")
    int insert(User user);

    @Select("select * from ev_users where username = #{name}")
    User selectByName(String name);

    @Select("select * from ev_users where id = #{id}")
    User selectById(Integer id);
}

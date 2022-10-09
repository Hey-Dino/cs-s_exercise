package com.zr.ssm.mapper;

import com.zr.ssm.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

public interface UserMapper {

    @Insert("INSERT INTO ev_users(username, password) VALUES (#{username},#{password})")
    int register(User user);

    @Select("SELECT * FROM ev_users WHERE username = #{username}")
    User selectByUsername(User user);

    @Select("SELECT * FROM ev_users WHERE id = #{id}")
    User selectById(Integer id);

    @Select("SELECT * FROM ev_users WHERE username = #{username} AND password = #{password}")
    User selectSomeOne(User user);

    @Update("UPDATE ev_users SET nickname = #{nickname}, email = #{email} WHERE id = #{id}")
    int updateById(User user);

    @Update("UPDATE ev_users SET password = #{newPwd} WHERE id = #{id} ")
    int updatePwd(@Param("newPwd")String newPwd, @Param("id")Integer id);

    @Update("UPDATE ev_users SET user_pic = #{avatar} WHERE id = #{id} ")
    int updateAvatar(@Param("avatar")String avatar, @Param("id")Integer id);
}

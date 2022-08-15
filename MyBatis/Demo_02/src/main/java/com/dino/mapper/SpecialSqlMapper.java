package com.dino.mapper;

import com.dino.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialSqlMapper {
    List<User> getUserByLike(@Param("username") String username);

    int deleteMore(@Param("ids") String ids);

    List<User> getUserByTagName(@Param("tagName") String tagName);

    // 获取添加功能自增的主键
    void insertUser(User user);
}

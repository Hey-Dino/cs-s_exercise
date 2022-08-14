package com.dino.mapper;

import com.dino.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;

@Mapper
public interface UserMapper {
    /*
    * MyBatis面向【接口】编程的两个一致：
    *   1.映射文件的 namespace 要和mapper接口的 全类名 保持一致
    *   2.映射文件中SQL语句的 id 要和mapper接口的 方法名 保持一致
    * */

    // 查询所有用户信息
    ArrayList<User> selectAll();

    // 查询单个用户
    User selectById();

    // 插入用户信息
    void insertUser();

    // 更新用户信息
    void updateUser();

    // 删除用户信息
    void deleteUser();
}

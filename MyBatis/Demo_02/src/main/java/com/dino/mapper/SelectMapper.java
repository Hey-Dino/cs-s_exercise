package com.dino.mapper;

import com.dino.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {
    /*
    * 1、若查询为单条数据时：
    *   （1）可以使用实体类对象接受，此时映射文件中语句的resultType为User
    *   （2）可以使用Map接收，此时映射文件中语句的resultType为Map
    *
    * 2、若查询为多条数据时：
    *   （1）可以使用List集合包裹实体类对象 或 Map集合
    *   （2）可以使用MapKey()注解，以MapKey注解值为键，以实力类Map为值
    * */
    User getUserById(@Param("id") String id);

    List<User> getAllUsers();

    Integer getCount();

    Map<String, Object> getUserByIdToMap(@Param("id") String id);


    List<Map<String, Object>> getAllUserToMapList();

    @MapKey("id")
    Map<String, Object> getAllUserToMap();
}

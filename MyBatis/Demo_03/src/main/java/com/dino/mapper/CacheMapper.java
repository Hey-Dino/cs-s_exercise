package com.dino.mapper;

import com.dino.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CacheMapper {
    /*
    * 注解开发：可在无对应映射文件的情况下，操作数据库
    * */
    // @Select(value = "SELECT * FROM emp WHERE eid = #{eid}")      // 使用注解查询，无法实现二级缓存
    Emp getEmpById(@Param("eid") int eid);

    @Delete(value = "DELETE FROM emp WHERE eid = #{eid}")
    int deleteEmpById(@Param("eid") int eid);
}

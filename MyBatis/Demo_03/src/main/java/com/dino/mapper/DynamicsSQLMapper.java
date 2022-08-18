package com.dino.mapper;

import com.dino.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicsSQLMapper {
    // 0~n 个条件查询
    List<Emp> getEmpByCondition(Emp emp);
    List<Emp> getEmpByConditionTwo(Emp emp);


    // 0~1个条件查询，条件可能不同
    // 测试choose、when
    List<Emp> getEmpBySingleCondition(Emp emp);

    // 通过数组实现批量删除
    int deleteMoreByArray(@Param("eids")Integer[] eids);

    // 通过集合实现批量增加
    int insertMoreByList(@Param("emps")List<Emp> emps);
}

package com.dino.mapper;

import com.dino.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    // 解决属性名和字段名不一致
    List<Emp> getAllEmp();

    // 解决多对一的映射关系
    Emp getEmpAndDept(@Param("eid") Integer eid);
    /*
    * 通过分布查询，查询员工以及员工所对应的部门信息
    *   第一步：通过eid查询员工信息
    * */
    Emp getEmpAndDeptByStep(@Param("eid") Integer eid);
}

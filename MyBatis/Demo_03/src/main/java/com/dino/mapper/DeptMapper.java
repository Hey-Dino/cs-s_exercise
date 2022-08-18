package com.dino.mapper;

import com.dino.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    /*
     * 通过分布查询，查询员工以及员工所对应的部门信息
     *   第二步：通过第一步查询获得的did，查询员工所在的部门
     * */
    Dept getEmpAndDeptByStep(@Param("did") Integer did);

    /*
    * 获取部门以及部门中员工信息
    * */
    Dept getDeptAndEmp(@Param("did") Integer did);
    /*
    * 分布查询第一步：查询部门信息
    * */
    Dept getDeptAndEmpByStep(@Param("did") Integer did);
}

package com.dino.mapper;

import com.dino.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    /*
     * 通过分布查询，查询员工以及员工所对应的部门信息
     *   第二步：通过第一步查询获得的did，查询员工所在的部门
     * */
    Dept getEmpAndDeptByStep(@Param("did") Integer did);
}

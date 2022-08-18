package com.dino;

import com.dino.mapper.DeptMapper;
import com.dino.pojo.Dept;
import com.dino.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class DeptMapperTest {
    /*
     * 处理多对一的映射关系：
     *   (1).collection
     *   (2).分步查询
     * */
    @Test
    public void testGetDeptAndEmp() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept deptAndEmp = mapper.getDeptAndEmp(10);
        System.out.println(deptAndEmp);
    }

    @Test
    public void testGetDeptAndEmpByStep() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByStep(10);
        System.out.println(dept.getDeptName());
        System.out.println(dept.getEmps());
    }
}

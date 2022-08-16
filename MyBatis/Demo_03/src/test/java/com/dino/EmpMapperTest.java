package com.dino;

import com.dino.mapper.EmpMapper;
import com.dino.pojo.Emp;
import com.dino.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class EmpMapperTest {
    /*
    * 解决字段名和属性名的映射关系
    *   (1).通过【字段别名】解决字段名和属性名的映射关系 -> SELECT eid, emp_name empName, did FROM emp;
    *   (2).通过【全局配置】中的setting选项，将“_“自动映射为大驼峰
    *   (3).通过【resultMap】设置自定义的映射关系
    *       <resultMap id="empResultMap" type="emp">
                <id property="eid" column="eid"></id>
                <result property="empName" column="emp_name"></result>
                <result property="did" column="did"></result>
            </resultMap>
    * */
    @Test
    public void testGetAllEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> emps = mapper.getAllEmp();
        emps.forEach(emp -> System.out.println(emp));
    }


    /*
    * 处理多对一的映射关系：
    *   （1）级联属性赋值
    *   （2）使用association
    * */
    @Test
    public void testGetEmpAndDept(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDept(1001);
        System.out.println(emp);
    }

    @Test
    public void testGetEmpAndDeptByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStep(1001);
        System.out.println(emp);
    }

    @Test
    public void testLazyLoading(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStep(1001);
        System.out.println("empName:" + emp.getEmpName());
        System.out.println("---------------------------");
        System.out.println("dept:" + emp.getDept());
    }
}

package com.dino;

import com.dino.mapper.DynamicsSQLMapper;
import com.dino.pojo.Emp;
import com.dino.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicsSQLMapperTest {
    /*
    * 动态SQL：
    *   1、if：根据标签中test属性所对应的表达式，决定其中的内容是否需要拼接到SQL中
    *
    *   2、where：
    *       （1）当where标签中有内容时，会自动生成where关键字，并且将【内容前】多余的and或or去掉
    *       （2）当where标签中没有内容时，此时where标签没有任何效果
    *       注意：
    *           where标签不能将其中内容后多余的and或or去掉
    *
    *   3、trim：
    *       参数：
    *       prefix | suffix：将trim标签所包裹的【整体内容】前面或后面添加指定内容
    *       prefixOverrides | prefixOverrides：将trim【标签内内容】的前面或后面去掉指定内容
    *       注意：
    *           若需要去除多个内容时，可用|拼接，如【and|or】
    *           若标签内没有内容，trim标签无任何效果
    *
    *   4、choose、when、otherwise
    *       （1）choose标签包裹when、otherwise
    *       （2）when标签代表if 和 else-if，otherwise代表 else
    *       （3）when标签的参数与if相同，为test，代表判断条件
    *       （4）choose有0~n个when标签，0~1个otherwise标签
    *
    *   5、foreach
    *       - collection：设置需要循环的数组或集合
    *       - item：数组或集合中的单个数据
    *       - separator：循环体之间的分隔符
    *       - open：foreach标签循环的所有内容的开始符
    *       - close：foreach标签循环的所有内容的结束符
    *
    *   6、sql标签
    *       - 设置SQL片段：<sql id="empColumns">eid, emp_name, did</sql>
    *       - 引用SQL片段：<include refid="empColumns"></include>
    * */

    @Test
    public void getEmpByConditionTest(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicsSQLMapper mapper = sqlSession.getMapper(DynamicsSQLMapper.class);
        List<Emp> emp = mapper.getEmpByCondition(new Emp(null, "孙悟空", null));
        System.out.println(emp);

        // 释放资源
        sqlSession.close();
    }

    @Test
    public void getEmpByConditionTwoTest(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicsSQLMapper mapper = sqlSession.getMapper(DynamicsSQLMapper.class);
        List<Emp> emp = mapper.getEmpByConditionTwo(new Emp(null, "孙悟空", null));
        System.out.println(emp);

        // 释放资源
        sqlSession.close();
    }

    @Test
    public void getEmpByConditionSingleTest(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicsSQLMapper mapper = sqlSession.getMapper(DynamicsSQLMapper.class);
        // 以 eid 作为条件查询
        List<Emp> emp = mapper.getEmpBySingleCondition(new Emp(1002, null, null));
        // 以 empName 作为条件查询
        // List<Emp> emp = mapper.getEmpByConditionSingle(new Emp(null, "孙悟空", null));
        System.out.println(emp);

        // 释放资源
        sqlSession.close();
    }

    @Test
    public void deleteMoreByArrayTest(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicsSQLMapper mapper = sqlSession.getMapper(DynamicsSQLMapper.class);
        int result = mapper.deleteMoreByArray(new Integer[]{1015, 1016});
        System.out.println(result);

        // 释放资源
        sqlSession.close();
    }


    @Test
    public void insertMoreByListTest(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicsSQLMapper mapper = sqlSession.getMapper(DynamicsSQLMapper.class);

        Emp emp1 = new Emp(null, "Dino", null);
        Emp emp2 = new Emp(null, "Pedro", null);
        Emp emp3 = new Emp(null, "Peppa", null);
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        System.out.println(mapper.insertMoreByList(emps));

        // 释放资源
        sqlSession.close();
    }
}

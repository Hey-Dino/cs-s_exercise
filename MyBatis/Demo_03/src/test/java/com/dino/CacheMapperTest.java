package com.dino;

import com.dino.mapper.CacheMapper;
import com.dino.pojo.Emp;
import com.dino.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheMapperTest {
    /*
     * 1、默认开启一级缓存
     * 2、一级缓存的级别是 SqlSession 对象；同一SqlSession下再次查询同一数据，不再调用SQL语句，而是调用缓存
     * 3、缓存机制仅用于查询
     *
     * 导致一级缓存失效的4种情况：
     *   （1）不同的SqlSession对应不同的一级缓存
     *   （2）同一个SqlSession，但是查询条件不同
     *   （3）同一个SqlSession，两次查询期间，执行了任何一次增删改操作（无论对哪条数据执行都一样）
     *   （4）同一个SqlSession，两次查询期间，手动清空了缓存
     * */

    @Test
    public void l1CacheTest(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getEmpById(1001);
        System.out.println("emp1:" + emp1);

        /*
        * 查看一级缓存生效的范围
        * */
        // 同一SqlSession下，不同mapper不影响一级缓存
        CacheMapper mapper2 = sqlSession.getMapper(CacheMapper.class);
        Emp emp2 = mapper2.getEmpById(1001);
        System.out.println("emp2:" + emp2);


        /*
        * 使一级缓存失效的方法
        * */
        // 方法一：执行增删改操作
        mapper2.deleteEmpById(1017);
        // 方法二：手动清空缓存
        // sqlSession.clearCache();

        Emp emp3 = mapper2.getEmpById(1001);
        System.out.println("emp3:" + emp3);
    }

    /*
    * 二级缓存开启的条件：
    *   （1）在核心配置文件种，设置全局配置属性cacheEnabled="true"，默认为true，不需要设置
    *   （2）在映射文件中，设置标签<cache />
    *   （3）二级缓存必须在SqlSession关闭或提交之后生效
    *   （4）查询的数据所转换的实体类必须实现序列化接口，如Emp类实现【Serializable接口】
    *
    * 二级缓存失效的情况：
    *       两次查询之间执行了任意的增删改，会使一级和二级缓存同时失效
    *
    * 注意：
    *   使用注解方式进行查询时，无法实现二级缓存
    *   注解方式：@Select(value = "SELECT * FROM emp WHERE eid = #{eid}")
     * */
    @Test
    public void l2CacheTest(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            SqlSession sqlSession2 = sqlSessionFactory.openSession(true);

            CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
            System.out.println(mapper1.getEmpById(1001));
            sqlSession1.close();

            CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            System.out.println(mapper2.getEmpById(1001));
            // sqlSession2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    * 缓存查询的顺序：
    *   - 先查询二级缓存，因而二级缓存可能会有其他程序已经查询出的数据，可以直接拿来用
    *   - 如果二级缓存未命中，再查询一级缓存
    *   - 如果一级缓存仍未命中，则查询数据库
    *
    * SqlSession关闭后，一级缓存中的数据才写入二级缓存
    * */
}

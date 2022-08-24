package com.dino.service;

import com.dino.mapper.BrandMapper;
import com.dino.pojo.Brand;
import com.dino.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BrandService {
    public List<Brand> selectAll(){
        // 1.获取会话对象
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        // 2.获取接口对象
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 3.调用接口对象的 selectAll() 方法
        List<Brand> brands = mapper.selectAll();
        // 4.释放资源
        sqlSession.close();

        return brands;
    }

    public void addBrand(Brand brand){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.addBrand(brand);

        sqlSession.close();
    }

    public void delById(Integer id) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.delById(id);

        sqlSession.close();
    }

    public Brand selectById(Integer id) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(id);

        sqlSession.close();

        return brand;
    }
}

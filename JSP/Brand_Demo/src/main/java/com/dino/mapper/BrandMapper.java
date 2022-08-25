package com.dino.mapper;

import com.dino.pojo.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {
    // 展示品牌信息
    @Select("SELECT * FROM brand;")
    List<Brand> selectAll();

    // 插入品牌信息
    @Insert("INSERT INTO brand VALUES(null, #{brandName}, #{companyName}, #{ordered}, #{description}, #{status})")
    void addBrand(Brand brand);

    // 删除品牌信息
    @Delete("DELETE FROM brand WHERE id=#{id}")
    void delById(Integer id);

    // 配合下方的updateBrand实现品牌信息编辑
    @Select("SELECT * FROM brand WHERE id=#{id}")
    Brand selectById(Integer id);

    void updateBrand(Brand brand);
}

package com.dino.mapper;

import com.dino.pojo.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {
    @Select("SELECT * FROM brand;")
    List<Brand> selectAll();

    @Insert("INSERT INTO brand VALUES(null, #{brandName}, #{companyName}, #{ordered}, #{description}, #{status})")
    void addBrand(Brand brand);

    @Delete("DELETE FROM brand WHERE id=#{id}")
    void delById(Integer id);

    @Select("SELECT * FROM brand WHERE id=#{id}")
    Brand selectById(Integer id);
}

package com.zr.ssm.mapper;

import com.zr.ssm.pojo.ArticalCate;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ArticalCateMapper {
    // 查询所有文章分类信息
    @Select("SELECT * FROM ev_article_cate WHERE is_delete=0")
    List<ArticalCate> selectAll();

    // 添加文章分类信息
    @Insert("INSERT INTO ev_article_cate(name, alias) VALUES(#{name}, #{alias}) ")
    int addCates(ArticalCate articalCate);

    // 删除文章分类信息（逻辑删除）
    @Delete("UPDATE ev_article_cate SET is_delete=1 WHERE id = #{id}")
    int deleteCateById(Integer id);

    // 查询文章分类信息
    @Select("SELECT * FROM ev_article_cate WHERE id = #{id}")
    ArticalCate selectById(Integer id);

    // 更新文章分类信息
    @Update("update ev_article_cate set name = #{name}, alias = #{alias} where id = #{id}")
    int updateCateById(ArticalCate articalCate);
}

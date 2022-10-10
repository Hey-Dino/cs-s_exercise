package com.zr.ssm.mapper;

import com.zr.ssm.pojo.Artical;
import com.zr.ssm.pojo.ArticalSql;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ArticalMapper {
    @Insert("INSERT INTO ev_articles VALUES (null, #{title}, #{content}, #{cover_img}, #{pub_date}, #{state}, 0, #{cate_id}, #{author_id})")
    int insert(Artical artical);

    // 查询文章信息（使用动态SQL查询）
    @SelectProvider(value = ArticalSql.class, method = "getDynamicSql")
    List<Artical> selectAll(Integer cate_id, String state);

    // 删除文章（逻辑删除）
    @Delete("UPDATE ev_articles SET is_delete=1 WHERE id = #{id}")
    int deletById(Integer id);

    @Select("SELECT * FROM ev_articles WHERE id = #{id}")
    Artical selectById(Integer id);

    @Update("UPDATE ev_articles SET title = #{title}, cate_id = #{cate_id}, state = #{state}, content = #{content} WHERE id = #{id}")
    int updateArtical(Artical artical);
}

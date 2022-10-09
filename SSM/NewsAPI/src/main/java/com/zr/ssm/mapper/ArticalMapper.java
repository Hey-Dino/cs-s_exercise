package com.zr.ssm.mapper;

import com.zr.ssm.pojo.Artical;
import com.zr.ssm.pojo.ArticalSql;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ArticalMapper {

    @Insert("INSERT INTO ev_articles VALUES (null, #{title}, #{content},#{cover_img},#{pub_date}," +
            "#{state},0,#{cate_id},#{author_id})")
    int insert(Artical artical);

    // @Select("select * from ev_articles")
    @SelectProvider(value = ArticalSql.class, method = "getDynamicSql")
    List<Artical> selectAll(Integer cate_id, String state);

    @Delete("DELETE FROM ev_articles WHERE id = #{id}")
    int deletById(Integer id);

    @Select("SELECT * FROM ev_articles WHERE id = #{id}")
    Artical selectById(Integer id);
}

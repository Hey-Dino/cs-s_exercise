package com.chinasoft.news.mapper;

import com.chinasoft.news.pojo.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 中软zhang
 * @create 2022-09-28 14:26
 */
public interface ArticleMapper {

    @Insert("insert into ev_articles " +
            "values(null, #{title}, #{content}, #{cover_img}, #{pub_date}, " +
            " #{state}, #{is_delete}, #{cate_id}, #{author_id})")
    int insert(Article article);

    @Select("select * from ev_articles order by id ")
    List<Article> selectAll();

}

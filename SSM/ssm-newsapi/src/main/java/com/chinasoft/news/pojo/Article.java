package com.chinasoft.news.pojo;

import lombok.Data;

/*
* 文章信息的实体类
* */
@Data
public class Article {
    Integer id;
    String title;
    String content;
    String cover_img;
    String pub_date;
    String state;
    Boolean is_delete;
    Integer cate_id;
    Integer author_id;
}

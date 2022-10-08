package com.chinasoft.news.pojo;

import lombok.Data;

@Data
public class ArticleAddVO {
    String title;
    Integer cate_id;
    String content;
    String state;
}

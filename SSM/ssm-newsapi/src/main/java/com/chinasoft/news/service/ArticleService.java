package com.chinasoft.news.service;

import com.chinasoft.news.pojo.ArticleAddVO;

/**
 * @author 中软zhang
 * @create 2022-09-28 15:27
 */
public interface ArticleService {
    Boolean insertArticle(ArticleAddVO aav, String filename, Integer userId);
}

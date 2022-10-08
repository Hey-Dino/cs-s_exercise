package com.chinasoft.news.service.impl;

import com.chinasoft.news.mapper.ArticleMapper;
import com.chinasoft.news.pojo.Article;
import com.chinasoft.news.pojo.ArticleAddVO;
import com.chinasoft.news.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class AritcleServiceImpl implements ArticleService {

    ArticleMapper articleMapper;

    @Override
    public Boolean insertArticle(ArticleAddVO aav, String filename, Integer userId) {
        Article article = new Article();
        article.setAuthor_id(userId);
        article.setCover_img(filename);
        article.setCate_id(aav.getCate_id());
        article.setContent(aav.getContent());
        article.setPub_date(new Date().toString());
        article.setState(aav.getState());
        article.setTitle(aav.getTitle());
        article.setIs_delete(false);

        int insert = articleMapper.insert(article);
        if (insert == 1) {
            // 插入成功
            return true;
        } else {
            return false;
        }
    }
}

package com.chinasoft.news.mapper;

import com.chinasoft.news.config.SpringConfig;
import com.chinasoft.news.pojo.Article;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author 中软zhang
 * @create 2022-09-29 9:32
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class})
public class ArticleMapperTest {
    @Autowired
    ArticleMapper articleMapper;

    @Test
    public void selectAll() {
        // 对下面的 查询进行 分页， 要第一页的数据， 每页 5 条记录
        PageHelper.startPage(3, 2);

        List<Article> articles = articleMapper.selectAll();
        for (Article article : articles) {
            System.out.println(article);
        }

        System.out.println(articles.getClass());
        // 拿到其他 分页相关信息
        PageInfo<Article> info = new PageInfo<>(articles);
        // 得到 总共有多少条记录
        System.out.println(info.getTotal());
        // 有多少页
        System.out.println(info.getPages());
        System.out.println(info);
    }
}
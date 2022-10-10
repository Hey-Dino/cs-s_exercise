package com.zr.ssm.service;

import com.zr.ssm.pojo.ArticalCate;

import java.util.List;

public interface ArticalCateService {

    // 根据页号、每页记录数获取数据
    List<Object> getCates(Integer pageNo, Integer pageSize);

    // 获取全部文章分类信息
    List<ArticalCate> getAllCates();

    Boolean addCates(ArticalCate articalCate);

    Boolean deleteCate(Integer id);

    ArticalCate getCateInfo(Integer id);

    Boolean updateCateInfo(ArticalCate articalCate);
}

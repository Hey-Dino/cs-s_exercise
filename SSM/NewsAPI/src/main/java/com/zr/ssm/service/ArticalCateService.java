package com.zr.ssm.service;

import com.zr.ssm.pojo.ArticalCate;

import java.util.List;

public interface ArticalCateService {

    List<ArticalCate> getArticalCate();

    Boolean addCates(ArticalCate articalCate);

    Boolean deleteCate(Integer id);

    ArticalCate getCateInfo(Integer id);

    Boolean updateCateInfo(ArticalCate articalCate);
}

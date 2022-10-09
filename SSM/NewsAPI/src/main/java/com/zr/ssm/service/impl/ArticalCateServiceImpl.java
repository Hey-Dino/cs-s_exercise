package com.zr.ssm.service.impl;

import com.zr.ssm.mapper.ArticalCateMapper;
import com.zr.ssm.pojo.ArticalCate;
import com.zr.ssm.service.ArticalCateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArticalCateServiceImpl implements ArticalCateService {

    ArticalCateMapper articalCateMapper;

    @Override
    public List<ArticalCate> getArticalCate() {
        return articalCateMapper.selectAll();
    }

    @Override
    public Boolean addCates(ArticalCate articalCate) {
        int i = articalCateMapper.addCates(articalCate);
        return i == 1 ? true : false;
    }

    @Override
    public Boolean deleteCate(Integer id) {
        int i = articalCateMapper.deleteCateById(id);
        return i == 1 ? true : false;
    }

    @Override
    public ArticalCate getCateInfo(Integer id) {
        ArticalCate articalCate = articalCateMapper.selectById(id);
        return  articalCate;
    }

    @Override
    public Boolean updateCateInfo(ArticalCate articalCate) {
        int i = articalCateMapper.updateCateById(articalCate);
        return i == 1 ? true : false;
    }
}

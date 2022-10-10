package com.zr.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zr.ssm.mapper.ArticalCateMapper;
import com.zr.ssm.pojo.ArticalCate;
import com.zr.ssm.service.ArticalCateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ArticalCateServiceImpl implements ArticalCateService {

    ArticalCateMapper articalCateMapper;

    @Override
    public List<Object> getCates(Integer pageNo, Integer pageSize) {
        // 执行此操作后，后续的查询操作都会加上 Limit 实现分页
        PageHelper.startPage(pageNo, pageSize);

        List<ArticalCate> categoryList = articalCateMapper.selectAll();
        // System.out.println("Category List:" + categoryList);

        // 利用PageInfo对结果进行包装
        PageInfo page = new PageInfo(categoryList);
        // 获取总记录数
        Integer total = (int) page.getTotal();

        // 创建集合（用于存储多条信息）
        List<Object> data = new ArrayList<>();
        data.add(categoryList); // 存储分页后的文章分类信息
        data.add(total);        // 存储总记录数

        return data;
    }

    // 获取全部分类信息
    @Override
    public List<ArticalCate> getAllCates() {
        List<ArticalCate> cateList = articalCateMapper.selectAll();

        return cateList;
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

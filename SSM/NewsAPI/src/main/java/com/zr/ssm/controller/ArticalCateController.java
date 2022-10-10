package com.zr.ssm.controller;

import com.zr.ssm.pojo.ArticalCate;
import com.zr.ssm.pojo.Result;
import com.zr.ssm.service.ArticalCateService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin
@RequestMapping("/my/article")
public class ArticalCateController {
    ArticalCateService articalCateService;

    // 获取文章分类信息（根据页号、每页记录数）
    @PostMapping("/cates")
    public Result getCates(Integer pageNo, Integer pageSize) {
        // 初始化响应内容
        Result result;

        // 获取文章分类信息及数据总数
        List<Object> data = articalCateService.getCates(pageNo, pageSize);
        if (data != null) {
            result = new Result(200, "Query article category successfully.", data.get(0));
            result.setTotal((Integer) data.get(1));
        } else {
            result = new Result(201, "Query article category failed.");
        }

        return result;
    }

    // 获取所有文章分类信息
   @GetMapping("/cates")
    public Result getCates() {
        Result result;

        List<ArticalCate> cateList = articalCateService.getAllCates();
        if (cateList != null) {
            result = new Result(200, "Query all article category successfully.", cateList);
        } else {
            result = new Result(201, "Query all article category failed.");
        }

        return result;
    };

    @PostMapping("/addcates")
    public Result addCates(ArticalCate articalCate) {
        Result result;

        Boolean flag = articalCateService.addCates(articalCate);
        if (flag) {
            result = new Result(200, "Add article category successfully.");
        } else {
            result = new Result(201, "Add article category failed");
        }

        return result;
    }

    @GetMapping("/deletecate/{id}")
    public Result deleteCate(@PathVariable Integer id) {
        Result result;

        Boolean flag = articalCateService.deleteCate(id);
        if (flag) {
            result = new Result(200, "Delete article category successfully.");
        } else {
            result = new Result(201, "Delete article category failed.");
        }

        return result;
    }

    @GetMapping("/cates/{id}")
    public Result getCateInfo(@PathVariable Integer id) {
        Result result;

        ArticalCate cateInfo = articalCateService.getCateInfo(id);
        if (cateInfo != null) {
            result = new Result(200, "Query article category by id successfully.", cateInfo);
        } else {
            result = new Result(201, "Query article category by id failed.");
        }

        return result;
    }

    @PostMapping("/updatecate")
    public Result updateCate(ArticalCate articalCate) {
        Result result;

        Boolean flag = articalCateService.updateCateInfo(articalCate);
        if (flag) {
            result = new Result(200, "Update article category successfully.");
        } else {
            result = new Result(201, "Update article category failed.");
        }

        return result;
    }
}

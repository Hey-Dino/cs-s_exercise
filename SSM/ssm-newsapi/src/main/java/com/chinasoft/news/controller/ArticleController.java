package com.chinasoft.news.controller;

import com.chinasoft.news.customexception.SystemException;
import com.chinasoft.news.pojo.Article;
import com.chinasoft.news.pojo.ArticleAddVO;
import com.chinasoft.news.pojo.ExType;
import com.chinasoft.news.pojo.Result;
import com.chinasoft.news.service.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/my/article")
@CrossOrigin
@AllArgsConstructor
public class ArticleController {
    ArticleService articleService;

    @PostMapping("/add")
    public Result addArticle(HttpServletRequest request,
                             ArticleAddVO aav, MultipartFile cover_img) {
        // String servletPath = request.getServletPath();

        Result result = new Result(0, "add article succ");
        try {
            String realPath = request.getSession().getServletContext().getRealPath("/");
            System.out.println(realPath);
            System.out.println(aav);
            System.out.println(cover_img);
            Integer userId = (Integer) request.getAttribute("userId");
            if (cover_img != null) {
                String filename = UUID.randomUUID().toString();
                File newFile = new File(realPath + "uploads/" + filename);
                cover_img.transferTo(newFile);
                System.out.println(newFile);
                Boolean flag = articleService.insertArticle(aav, "uploads/" + filename, userId);
                if (!flag) {
                    result.setStatus(1);
                    result.setMessage("add article failed");
                    return result;
                }
            }
            return result;
        } catch (IOException e) {
            throw new SystemException("io exception", ExType.SystemIOFail, e);
        }
    }
}

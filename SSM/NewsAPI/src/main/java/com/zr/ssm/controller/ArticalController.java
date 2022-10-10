package com.zr.ssm.controller;

import com.zr.ssm.customex.SystemException;
import com.zr.ssm.pojo.Artical;
import com.zr.ssm.pojo.ExType;
import com.zr.ssm.pojo.Result;
import com.zr.ssm.service.ArticalService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/my/article")
@CrossOrigin
@AllArgsConstructor
public class ArticalController {
    ArticalService articalService;

    @PostMapping("/add")
    public Result addArtical(String title, Integer cate_id, String content, MultipartFile cover_img, String state,
                             HttpServletRequest request) {
        Result result = new Result(0, "add artical ok");
        Artical artical = new Artical(title, cate_id, content, state);
        try {
            // 根据上下文获取根目录getServletContext()
            String realPath = request.getSession().getServletContext().getRealPath("/");
            // 利用UUID生成文件名
            String fileName = UUID.randomUUID().toString();
            // 在指定目录下生成一个文件
            File file = new File(realPath + "uploads/" + fileName);

            // 将前端传过来的图片转换为文件并放在服务器中
            cover_img.transferTo(file);
            //获取token中的用户信息中的id补充作者id
            Integer id = (Integer) request.getAttribute("userId");
            String imgUrl = "uploads/" + fileName;
            artical.setAuthor_id(id);
            artical.setCover_img(imgUrl);

            System.out.println("~@@@~ " + artical);
            Boolean flag = articalService.addArtical(artical);
            if (!flag) {
                result.setStatus(1);
                result.setMessage("add artical ok");
            }
        } catch (IOException e) {
            // 捕获系统异常转换为自定义异常
            throw new SystemException("uploads fail", ExType.SystemIOException);
        }
        return result;
    }

    @GetMapping("/list")
    public Result getArtical(Integer pageNo, Integer pageSize, Integer cate_id, String state) throws UnsupportedEncodingException {
        Result result;

        List<Object> data = articalService.getArtical(pageNo, pageSize, cate_id, state);

        if (data != null) {
            result = new Result(200, "Query all artical successfully.", data.get(0));
            result.setTotal((Integer) data.get(1));
        } else {
            result = new Result(201, "Query all articals failed.");
        }

        return result;
    }

    @GetMapping("/delete/{id}")
    public Result deleteArtical(@PathVariable Integer id) {
        Result result;

        Boolean flag = articalService.deleteArtical(id);
        if (flag) {
            result = new Result(200, "Delete artical successfully.");
        } else {
            result = new Result(201, "Delete artical failed.");
        }

        return result;
    }

    @GetMapping("/{id}")
    public Result getOneArtical(@PathVariable Integer id) {
        Result result;

        Artical artical = articalService.getOneArtical(id);
        if (artical != null) {
            result = new Result(200, "Query artical by id successfully.", artical);
        } else {
            throw new SystemException("System error", ExType.SystemDbTimeOut);
        }

        return result;
    }

    @PostMapping("/updateArticle")
    public Result updateArtical(Artical artical){
        Result result;

        Boolean flag = articalService.updateArtical(artical);
        if (flag) {
            result = new Result(200, "Update article successfully.");
        } else {
            result = new Result(201, "Update article failed.");
        }

        return result;
    }
}

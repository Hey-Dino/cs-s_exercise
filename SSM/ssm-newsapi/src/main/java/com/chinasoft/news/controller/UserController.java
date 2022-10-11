package com.chinasoft.news.controller;

import com.chinasoft.news.pojo.Result;
import com.chinasoft.news.pojo.User;
import com.chinasoft.news.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/my/test")
    public String test() {              // 用于测试接口连通性的方法
        return "test in usercontroller";
    }

    @GetMapping("/my/userinfo")
    public Result getUserInfo(HttpServletRequest request) {     // request: springMvc 内置对象，对象是[系统产生]。
        // 从请求中获取用户ID
        Integer userId = (Integer) request.getAttribute("userId");
        // 通过ID获取用户信息
        User user = userService.getUserInfo(userId);
        // 置空用户密码，避免传输到客户端
        user.setPassword("");

        // 初始化响应结果实例
        Result result = new Result(0, "succ");
        // 将用户信息加入到响应结果
        result.setData(user);

        return result;
    }
}

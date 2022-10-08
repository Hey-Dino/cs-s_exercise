package com.chinasoft.news.controller;

import com.chinasoft.news.pojo.Code;
import com.chinasoft.news.pojo.Result;
import com.chinasoft.news.pojo.User;
import com.chinasoft.news.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin
public class AuthController {
    UserService userService;

    // 用户注册的控制器
    @PostMapping("/reguser")
    public Result register(User user) {
        Result result;

        // flag代表用户是否注册成功（false表示注册失败，true表示注册成功）
        Boolean flag = userService.registerUser(user);
        if (!flag) {
            result = new Result(
                    201,
                    "Register user failed. Cause: The user name is already occupied.",
                    null,
                    Code.RegisterOk);
        } else {
            result = new Result(200, "Register User OK", null, Code.RegisterOk);
        }

        return result;
    }

    // 用户登录的控制器
    @PostMapping("/login")
    public Result login(User user) {
        Result res = userService.login(user);

        return res;
    }
}

package com.zr.ssm.controller;

import com.zr.ssm.pojo.Result;
import com.zr.ssm.pojo.User;
import com.zr.ssm.service.UserService;
import com.zr.ssm.utils.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api")
public class InitController {
    UserService userService;

    @PostMapping("/reguser")
    public Result register(User user) {
        Result result;

        // 判断用户名是否被占用
        Boolean isOccupy = userService.selectByUsername(user);
        if (isOccupy) {
            result = new Result(201, "Register user failed. Cause: The User Name is Already Occupied.");
        } else {
            // 调用服务注册用户，并获取注册结果
            Boolean flag = userService.register(user);
            if (flag) {
                result = new Result(200, "Register user successfully.");
            } else {
                result = new Result(201, "Register user failed.");
            }
        }

        return result;
    }

    @PostMapping("/login")
    public Result login(User user) {
        Result result = new Result(200, "login ok");
        User loginUser = userService.login(user);
        if (loginUser != null) {
            String token = JwtUtils.createToken(loginUser.getId().toString(), loginUser.getUsername());
            result.setToken(token);
        } else {
            result.setStatus(201);
            result.setMessage("login fail");
        }
        return result;
    }
}

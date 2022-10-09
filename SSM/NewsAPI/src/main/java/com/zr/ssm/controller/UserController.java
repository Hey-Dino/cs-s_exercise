package com.zr.ssm.controller;

import com.zr.ssm.pojo.Result;
import com.zr.ssm.pojo.User;
import com.zr.ssm.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/my")
@AllArgsConstructor
@CrossOrigin
public class UserController {
    UserService userService;

    // 【获取】用户信息
    @GetMapping("/userinfo")
    public Result getUserInfo(HttpServletRequest request) {
        // 从请求中获取用户ID
        Integer userId = (Integer) request.getAttribute("userId");
        // 根据用户ID获取用户信息
        User user = userService.selectByUserId(userId);
        // 初始化响应结果实例
        Result result = new Result(200, "Query User Information Successfully.");
        // 将用户信息加入到响应结果
        result.setData(user);

        return result;
    }

    // 【更新】用户信息
    @PostMapping("/userinfo")
    public Result updateInfo(User user) {
        Result result;

        Boolean flag = userService.updateUserInfo(user);
        if (flag) {
            result = new Result(200, "Update User Information Successfully.");
        } else {
            result = new Result(201, "Update User Information Failed.");
        }

        return result;
    }

    @PostMapping("/updatepwd")
    public Result updatePwd(String newPwd, HttpServletRequest request) {
        Result result;
        System.out.println(newPwd);

        // 获取用户ID
        Integer id = (Integer) request.getAttribute("userId");
        // 调用服务更新密码，获取更新结果
        Boolean flag = userService.updatePwd(newPwd, id);
        if (flag) {
            result = new Result(200, "Update User's Password Successfully.");
        } else {
            result = new Result(201, "Update User's Password Failed.");
        }

        return result;
    }

    @PostMapping("/update/avatar")
    public Result updateAvatar(String avatar, HttpServletRequest request) {
        Result result;

        // 获取用户ID
        Integer id = (Integer) request.getAttribute("userId");
        // 调用服务更新用户头像，获取更新结果
        Boolean flag = userService.updateAvatar(avatar, id);
        if (flag) {
            result = new Result(200, "Update User's Avatar Successfully.");
        } else {
            result = new Result(201, "Update User's Avatar Failed.");
        }

        return result;
    }
}

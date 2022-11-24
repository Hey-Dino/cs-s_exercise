package com.example.demo.controller;

import com.example.demo.entity.Rbody;
import com.example.demo.entity.SpGoods;
import com.example.demo.entity.User;
import com.example.demo.entity.UserReq;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Rbody<User> login(@RequestBody UserReq userReq){
        return userService.login(userReq.getUsername(),userReq.getPassword());
    }

}

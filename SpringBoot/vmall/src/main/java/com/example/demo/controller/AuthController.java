package com.example.demo.controller;

import com.example.demo.entity.Rbody;
import com.example.demo.entity.SpPermission;
import com.example.demo.entity.State;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class AuthController {
    @Autowired
    AuthService authService;

    @GetMapping("/rights/{type}")
    public Rbody<List<SpPermission>> getAllPermission(@PathVariable String type) {
        Rbody<List<SpPermission>> rbody;

        // 判断是以何种形式展示权限数据，以 列表形式 还是 树形
        if ("list".equals(type)) {
            rbody = authService.getPermissionList();
        } else if ("tree".equals(type)) {
            rbody = authService.getPermissionTree();
        } else {
            rbody = new Rbody<>();
            rbody.setData(null);
            rbody.setMeta(new State("Incorrect Query Type.", 201));
        }

        return rbody;
    }

    @GetMapping("/menus")
    public Rbody<List<SpPermission>> getMenus() {
        return authService.getPermissionTree();
    }
}

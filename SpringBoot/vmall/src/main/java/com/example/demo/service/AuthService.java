package com.example.demo.service;

import com.example.demo.entity.Rbody;
import com.example.demo.entity.SpPermission;

import java.util.List;

public interface AuthService {
    Rbody<List<SpPermission>> getPermissionList();

    Rbody<List<SpPermission>> getPermissionTree();
}

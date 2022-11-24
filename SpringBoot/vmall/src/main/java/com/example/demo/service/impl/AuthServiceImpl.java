package com.example.demo.service.impl;

import com.example.demo.dao.AuthMapper;
import com.example.demo.entity.Rbody;
import com.example.demo.entity.SpPermission;
import com.example.demo.entity.State;
import com.example.demo.service.AuthService;
import com.example.demo.util.PermissionTreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    AuthMapper authMapper;

    @Override
    public Rbody<List<SpPermission>> getPermissionList() {
        List<SpPermission> permissionList = authMapper.getAllPermission();

        Rbody<List<SpPermission>> rbody = new Rbody<>();
        if (permissionList.size() > 0) {
            rbody.setData(permissionList);
            rbody.setMeta(new State("Select Permission List Successfully.", 200));
        } else {
            rbody.setData(null);
            rbody.setMeta(new State("Select Permission List Failed.", 201));
        }

        return rbody;
    }

    @Override
    public Rbody<List<SpPermission>> getPermissionTree() {
        List<SpPermission> permissionList = authMapper.getAllPermission();

        Rbody<List<SpPermission>> rbody = new Rbody<>();
        if (permissionList.size() > 0) {
            List<SpPermission> permissionTree = PermissionTreeUtil.getTree(permissionList);
            rbody.setData(permissionTree);
            rbody.setMeta(new State("Select Permission Tree Successfully.", 200));
        } else {
            rbody.setData(null);
            rbody.setMeta(new State("Select Permission Tree Failed.", 201));
        }

        return rbody;
    }
}

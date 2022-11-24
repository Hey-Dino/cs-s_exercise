package com.example.demo.service;

import com.example.demo.entity.Rbody;
import com.example.demo.entity.SpRole;

import java.util.List;

public interface RoleService {
    Rbody<List<SpRole>> getRoleList();

    Rbody<SpRole> addRole(SpRole spRole);

    Rbody<SpRole> getRoleById(Integer roleId);

    Rbody<SpRole> deleteRoleById(Integer roleId);

    Rbody<SpRole> updateRole(SpRole spRole);

    Rbody<SpRole> addAuth(Integer roleId, String rids);
}

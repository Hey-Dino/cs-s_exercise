package com.example.demo.service.impl;

import com.example.demo.dao.AuthMapper;
import com.example.demo.dao.RoleMapper;
import com.example.demo.entity.Rbody;
import com.example.demo.entity.SpPermission;
import com.example.demo.entity.SpRole;
import com.example.demo.entity.State;
import com.example.demo.service.RoleService;
import com.example.demo.util.PermissionTreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    AuthMapper authMapper;

    @Override
    public Rbody<List<SpRole>> getRoleList() {
        List<SpRole> roleList = roleMapper.getRoleList();

        Rbody<List<SpRole>> rbody = new Rbody<>();
        // 判断获取的用户列表是否为空
        if (roleList != null) {
            roleList.forEach(role -> {
                // 将用户 权限字符串rids 转换为 权限数组
                String[] ridList = role.getPsIds().split(",");
                // 根据 权限ID 获取 权限列表
                List<SpPermission> permissionList = authMapper.getPermissionByRids(ridList);

                // 判断获取的权限列表是否为空
                if (permissionList != null) {
                    // 将 权限列表 转化为 嵌套关系的 权限树
                    List<SpPermission> permissionTree = PermissionTreeUtil.getTree(permissionList);
                    // 设置 属性children 为 权限树
                    role.setChildren(permissionTree);
                    // 清空无需数据
                    role.setPsIds(null);
                    role.setPsCa(null);

                    rbody.setData(roleList);
                    rbody.setMeta(new State("Get Role List Successfully.", 200));
                } else {
                    rbody.setData(null);
                    rbody.setMeta(new State("Get Role List Failed.", 201));
                }
            });
        } else {
            rbody.setData(null);
            rbody.setMeta(new State("Get Role List Failed.", 201));
        }

        return rbody;
    }

    @Override
    public Rbody<SpRole> addRole(SpRole spRole) {
        Integer affectRow = roleMapper.addRole(spRole);

        Rbody<SpRole> rbody = new Rbody<>();
        // 影响行数为1，代表插入成功
        if (affectRow == 1) {
            rbody.setData(spRole);
            rbody.setMeta(new State("Add Role Successfully.", 200));
        } else {
            rbody.setData(null);
            rbody.setMeta(new State("Add Role Failed.", 201));
        }

        return rbody;
    }

    @Override
    public Rbody<SpRole> getRoleById(Integer roleId) {
        SpRole spRole = roleMapper.getRoleById(roleId);

        Rbody<SpRole> rbody = new Rbody<>();
        if (spRole != null) {
            rbody.setData(spRole);
            rbody.setMeta(new State("Select Role By Id Successfully.", 200));
        } else {
            rbody.setData(null);
            rbody.setMeta(new State("Select Role By Id Failed.", 201));
        }

        return rbody;
    }

    @Override
    public Rbody<SpRole> deleteRoleById(Integer roleId) {
        Integer affectRow = roleMapper.deleteRoleById(roleId);

        Rbody<SpRole> rbody = new Rbody<>();
        rbody.setData(null);
        // 影响行数为1，代表删除成功
        if (affectRow == 1) {
            rbody.setMeta(new State("Delete Role Successfully.", 200));
        } else {
            rbody.setMeta(new State("Delete Role Failed.", 201));
        }

        return rbody;
    }

    @Override
    public Rbody<SpRole> updateRole(SpRole spRole) {
        Integer affectRow = roleMapper.updateRole(spRole);

        Rbody<SpRole> rbody = new Rbody<>();
        // 影响行数为1，代表更新成功
        if (affectRow == 1) {
            // 根据ID，查询更新后的角色信息
            SpRole newRole = roleMapper.getRoleById((int) spRole.getRoleId());
            if (spRole != null) {
                rbody.setData(spRole);
                rbody.setMeta(new State("Update Role By Id Successfully.", 200));
            } else {
                rbody.setData(null);
                rbody.setMeta(new State("Update Role By Id Failed.", 201));
            }
        } else {
            rbody.setData(null);
            rbody.setMeta(new State("Update Role Failed.", 201));
        }

        return rbody;
    }

    @Override
    public Rbody<SpRole> addAuth(Integer roleId, String rids) {
        Integer affectRow = roleMapper.updateAuth(roleId, rids);

        Rbody<SpRole> rbody = new Rbody<>();
        rbody.setData(null);
        // 影响行数为1，代表插入成功
        if (affectRow == 1) {
            rbody.setMeta(new State("Update Role's Authorization Successfully.", 200));
        } else {
            rbody.setMeta(new State("Update Role's Authorization Failed.", 201));
        }

        return rbody;
    }
}

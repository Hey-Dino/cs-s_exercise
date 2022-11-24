package com.example.demo.util;

import com.example.demo.entity.SpPermission;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PermissionTreeUtil {
    /* 将 权限列表 转化为 权限树 */
    public static List<SpPermission> getTree(List<SpPermission> permissionList) {
        List<SpPermission> permissionTree = permissionList
                .stream()
                .filter(permission -> permission.getPid() == 0)
                .map(permission -> {
                    permission.setChildren(getChildren(permission, permissionList));
                    return permission;
                })
                .collect(Collectors.toList());

        return permissionTree;
    }

    /* 获取 权限树 中的children */
    public static List<SpPermission> getChildren(SpPermission root, List<SpPermission> all) {
        List<SpPermission> children = all
                .stream()
                .filter(permission ->  Objects.equals(permission.getPid(), root.getId()) )
                .map(permission -> {
                    permission.setChildren(getChildren(permission, all));
                    return permission;
                })
                .collect(Collectors.toList());

        return children;
    }
}

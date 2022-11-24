package com.example.demo.controller;

import com.example.demo.entity.Rbody;
import com.example.demo.entity.RidsReq;
import com.example.demo.entity.SpRole;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/roles")
    public Rbody<List<SpRole>> getRoleList() {
        return roleService.getRoleList();
    }

    @PostMapping("/roles")
    public Rbody<SpRole> addRole(@RequestBody SpRole spRole) {
        return roleService.addRole(spRole);
    }

    @GetMapping("/roles/{roleId}")
    public Rbody<SpRole> getRoleById(@PathVariable Integer roleId) {
        return roleService.getRoleById(roleId);
    }

    @PutMapping("/roles/{roleId}")
    public Rbody<SpRole> updateRole(@PathVariable Integer roleId, @RequestBody SpRole spRole) {
        // 将params参数整合到body中
        spRole.setRoleId(roleId);

        return roleService.updateRole(spRole);
    }

    @DeleteMapping("/roles/{roleId}")
    public Rbody<SpRole> deleteRoleById(@PathVariable Integer roleId) {
        return roleService.deleteRoleById(roleId);
    }

    @PostMapping("/roles/{roleId}/rights")
    public Rbody<SpRole> addAuth(@PathVariable Integer roleId, @RequestBody RidsReq ridsReq) {
        String rids = ridsReq.getRids();

        return roleService.addAuth(roleId, rids);
    }
}

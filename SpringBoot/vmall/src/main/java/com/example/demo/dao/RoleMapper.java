package com.example.demo.dao;

import com.example.demo.entity.SpRole;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface RoleMapper {
    List<SpRole> getRoleList();

    Integer addRole(SpRole spRole);

    SpRole getRoleById(Integer roleId);

    Integer deleteRoleById(Integer roleId);

    Integer updateRole(SpRole spRole);

    Integer updateAuth(Integer roleId, String rids);
}

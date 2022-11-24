package com.example.demo.dao;

import com.example.demo.entity.SpPermission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AuthMapper {
    List<SpPermission> getAllPermission();

    // 根据角色权限ID，获取具体权限信息
    List<SpPermission> getPermissionByRids(String[] rids);
}

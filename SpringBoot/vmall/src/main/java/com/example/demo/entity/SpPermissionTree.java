package com.example.demo.entity;

import lombok.Data;

import java.util.List;

@Data
public class SpPermissionTree {
    private long id;
    private String authName;
    private long pid;
    private String level;
    private String path;
    private List<SpPermission> children;
}

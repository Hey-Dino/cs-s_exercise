package com.example.demo.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.List;

@Data
// 阻止空值返回
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class SpRole {

  private long roleId;
  private String roleName;
  private String psIds;
  private String psCa;
  private String roleDesc;
  private List<SpPermission> children;
}
package com.example.demo.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.util.List;

@Data
// 阻止空值返回
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class SpPermission {

  private long id;
  private String authName;
  private long pid;
  /*private String psC;
  private String psA;*/
  private String level;
  private String path;
  private List<SpPermission> children;
}

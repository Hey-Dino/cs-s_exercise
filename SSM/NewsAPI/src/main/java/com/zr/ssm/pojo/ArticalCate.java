package com.zr.ssm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticalCate {

    Integer id;
    String name;
    String alias;
    Boolean is_delete;
}

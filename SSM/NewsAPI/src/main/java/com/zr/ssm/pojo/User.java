package com.zr.ssm.pojo;

import lombok.Data;

/**
 * @author 中软zhang
 * @create 2022-09-27 15:41
 */
@Data
public class User {
    Integer id;
    String username;
    String password;
    String nickname;
    String email;
    String user_pic;
}

package com.chinasoft.news.pojo;

import lombok.Data;

@Data
public class User {
    Integer id;
    String username;
    String password;
    String nickname;
    String email;
    String user_pic;
}

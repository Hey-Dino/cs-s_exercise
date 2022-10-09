package com.zr.ssm.service;

import com.zr.ssm.pojo.User;

public interface UserService {

     Boolean register(User user);

     Boolean selectByUsername(User user);

     User login(User user);

     User selectByUserId(Integer userId);

     Boolean updateUserInfo(User user);

     Boolean updatePwd(String newPwd, Integer id);

     Boolean updateAvatar(String avatar, Integer id);
}

package com.chinasoft.news.service;

import com.chinasoft.news.pojo.Result;
import com.chinasoft.news.pojo.User;

public interface UserService {
    Result login(User user);

    Boolean registerUser(User user);

    User getUserInfo(String token);

    User getUserInfo(Integer userId);
}

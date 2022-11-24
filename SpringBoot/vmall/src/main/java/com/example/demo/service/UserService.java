package com.example.demo.service;

import com.example.demo.entity.Rbody;
import com.example.demo.entity.SpGoods;
import com.example.demo.entity.User;

import java.util.List;

public interface UserService {

    Rbody<User> login(String username, String password);
}

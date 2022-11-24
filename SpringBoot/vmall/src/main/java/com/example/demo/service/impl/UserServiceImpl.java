package com.example.demo.service.impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.Rbody;
import com.example.demo.entity.State;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Rbody<User> login(String username, String password) {
        User user = userMapper.login(username, password);
        State state = new State("登陆失败",101);
        if(user != null){
            String token = JwtUtil.createToken(String.valueOf(user.getId()), user.getUsername());
            user.setToken(token);
            state = new State("登陆成功",200);
        }
        return new Rbody<User>(user,state);
    }
}

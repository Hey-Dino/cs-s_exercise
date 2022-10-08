package com.chinasoft.news.service.impl;

import com.chinasoft.news.customexception.BussinessException;
import com.chinasoft.news.customexception.SystemException;
import com.chinasoft.news.mapper.UserMapper;
import com.chinasoft.news.pojo.ExType;
import com.chinasoft.news.pojo.Result;
import com.chinasoft.news.pojo.User;
import com.chinasoft.news.service.UserService;
import com.chinasoft.news.utils.JwtUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    UserMapper userMapper;

    @Override
    public Result login(User user) {
        Result result;

        // 1.根据用户名查询用户数据
        User userDb = userMapper.selectByName(user.getUsername());

        if (userDb == null) {   // 用户不存在
            result = new Result(201, "Login failed. Cause: The user does not exist or the password is incorrect.");
        } else {
            // 获取用户密码密文，并转化为明文
            String loginPwd = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
            // 将密码明文与用户所输入的密码做比较
            Boolean isCorrectPwd = userDb.getPassword().equals(loginPwd);

            // 2.判断用户输入的密码是否正确
            if (isCorrectPwd) {     // 密码不正确
                // 3.生成 Token 字符串
                String token = JwtUtils.createToken(userDb.getId().toString(), user.getUsername());
                result = new Result(200, "Login successful.", token);
            } else {
                result = new Result(201, "Login failed. Cause: The user does not exist or the password is incorrect.");
            }
        }

        return result;
    }

    @Override
    public Boolean registerUser(User user) {
        // 查询用户名是否占用
        User userDb = userMapper.selectByName(user.getUsername());
        if (userDb != null) {
            return false;
        }

        // 将用户密码转换为 md5码，即从[明文]转换为[密文]
        String newPW = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(newPW);

        // 新增用户
        int insert = userMapper.insert(user);
        if (insert != 1) {
            throw new SystemException("Insert User Failed " + user, ExType.SystemInsertFail);
        }

        return true;
    }

    @Override
    public User getUserInfo(String token) {
        String strId = JwtUtils.getAudience(token);
        User user = userMapper.selectById(Integer.parseInt(strId));
        if (user == null) {
            throw new BussinessException("user not found " + strId, ExType.BussRecordNotFound);
        }
        return user;
    }

    @Override
    public User getUserInfo(Integer userId) {
        User user = userMapper.selectById(userId);
        if (user == null) {
            throw new BussinessException("user not found " + userId, ExType.BussRecordNotFound);
        }
        return user;
    }
}

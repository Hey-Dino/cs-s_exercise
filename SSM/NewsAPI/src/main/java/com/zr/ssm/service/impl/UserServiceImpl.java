package com.zr.ssm.service.impl;

import com.zr.ssm.customex.SystemException;
import com.zr.ssm.mapper.UserMapper;
import com.zr.ssm.pojo.ExType;
import com.zr.ssm.pojo.User;
import com.zr.ssm.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    UserMapper userMapper;

    /* 注册账户的服务 */
    @Override
    public Boolean register(User user) {
        // 通过 MD5 对账户密码进行加密
        String encryptedPwd = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        // 更新加密后的密码
        user.setPassword(encryptedPwd);

        // 调用映射文件（执行SQL语句），获取影响行数
        int register = userMapper.register(user);
        if (register != 1) {
            throw new SystemException("system error!", ExType.SystemInsertFail);
        }

        return true;
    }

    /* 通过用户名查询用户信息（用户注册） */
    @Override
    public Boolean selectByUsername(User user) {
        User user1 = userMapper.selectByUsername(user);
        return user1 != null ? true : false;
    }

    /* 登录账户的服务 */
    @Override
    public User login(User user) {
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        User user1 = userMapper.selectSomeOne(user);
        return user1 != null ? user1 : null;
    }

    @Override
    public User selectByUserId(Integer userId) {
        User user = userMapper.selectById(userId);
        return user;
    }

    /* 更新用户信息的服务 */
    @Override
    public Boolean updateUserInfo(User user) {
        int i = userMapper.updateById(user);

        return i == 1 ? true : false;
    }

    /* 更新用户头像的服务 */
    @Override
    public Boolean updatePwd(String newPwd, Integer id) {
        newPwd = DigestUtils.md5DigestAsHex(newPwd.getBytes());
        int i = userMapper.updatePwd(newPwd, id);
        return i == 1 ? true : false;
    }

    @Override
    public Boolean updateAvatar(String avatar, Integer id) {
        int i = userMapper.updateAvatar(avatar, id);
        return i == 1 ? true : false;
    }
}

package com.dino;

import com.dino.pojo.User;
import com.dino.service.UserService;
import com.dino.utils.CheckCodeUtil;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TestUserService {
    UserService userService = new UserService();

    @Test
    public void testSelectByUsername(){
        User user = userService.selectByUsername("Dino");
        System.out.println(user);
    }

    @Test
    public void testSelecUser(){
        User user = userService.selectUser("Dino", "123456");
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        int result = userService.insertUser("Peppa", "peppa");
        System.out.println(result);
    }

    /* 试验验证码生成 */
    @Test
    public void testVerifyImgAndCode() throws IOException {
        // 待存储验证码的位置
        OutputStream os = new FileOutputStream("src/main/resource/statics/verifyImg.jpg");
        // checkCode为最终生成的验证码数据
        String checkCode = CheckCodeUtil.outputVerifyImage(100, 50, os, 4);
        System.out.println(checkCode);
    }
}

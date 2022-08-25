package com.dino;

import com.dino.pojo.User;
import com.dino.service.UserService;
import org.junit.Test;

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
}

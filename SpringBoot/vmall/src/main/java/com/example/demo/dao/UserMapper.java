package com.example.demo.dao;

import com.example.demo.entity.SpGoods;
import com.example.demo.entity.SpUser;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    User login(String username, String password);
}

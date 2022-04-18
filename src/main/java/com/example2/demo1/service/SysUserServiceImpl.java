package com.example2.demo1.service;

import com.example2.demo1.mapper.UserMapper;
import com.example2.demo1.model.UserModel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserServiceImpl implements SysUserService{
    @Resource
    private UserMapper userMapper;

    @Override
    public UserModel getOneUserByUsername(String username) {
        UserModel user_one = userMapper.selectOneUserByUserName(username);
        return user_one;
    }
}

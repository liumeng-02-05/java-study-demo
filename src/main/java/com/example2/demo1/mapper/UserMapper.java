package com.example2.demo1.mapper;

import com.example2.demo1.model.UserModel;

public interface UserMapper {
    public UserModel selectOneUserByUserName(String username);
}

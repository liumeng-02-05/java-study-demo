package com.example2.demo1.mapper;

import com.example2.demo1.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    public UserModel selectOneUserByUserName(String username);
}

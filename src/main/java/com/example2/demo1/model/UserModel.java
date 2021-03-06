package com.example2.demo1.model;

import java.util.List;

public class UserModel {
    private Integer userId;
    private String userName;
    private String password;
    private List<String> roles;
    private String nickName;

    public Integer getUserId() {
        return this.userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return this.roles;
    }
    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public String getNickName() {
        return this.nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}

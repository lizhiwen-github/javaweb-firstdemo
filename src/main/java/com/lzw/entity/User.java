package com.lzw.entity;

/**
 * @Classname User 用户实体类
 * @Description TODO 保存用户的用户名和密码
 * @Version 1.0.0
 * @Created by 李志文
 * @Date 2022/1/27 16:45
 */
public class User {
    private String password;
    private String username;

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

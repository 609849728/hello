package com.sp.entity;

import lombok.Data;

@Data
public class User {

    private Integer id;

    private String username;

    private String password;

    private String salt;

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}

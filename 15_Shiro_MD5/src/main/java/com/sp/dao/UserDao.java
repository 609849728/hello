package com.sp.dao;

import com.sp.entity.User;

import java.util.Set;

public interface UserDao {

    //登录，根据用户名查询密码，这样既能判断用户是否存在，也能判断密码是否正确
    String getPassword(String username);

    //根据用户名，查询该用户拥有哪些角色，一个用户可以拥有多个角色
    Set<String> getListRoleByUser(String username);

    //根据用户名，查询该用户拥有哪些权限，一个用户可以拥有多个权限
    Set<String> getListPermitByUser(String username);


    //注册
    String createUser(String username,String password);

    //查询用户信息
    User getUser(String username);


}

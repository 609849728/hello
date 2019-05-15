package com.sp.dao;

import com.sp.entity.User;

import java.util.List;

public interface UserDao {

    //查询所有用户，并且使用分页插件进行分页
    List<User> getUserList();

}

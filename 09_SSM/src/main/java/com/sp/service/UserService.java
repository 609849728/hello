package com.sp.service;

import com.github.pagehelper.PageInfo;
import com.sp.entity.User;

import java.util.List;

public interface UserService {

    //对应dao层的List<User> getUserList();
    PageInfo getUserList(Integer pageNum);

    User getUserById(Integer id);

    void updateUser(User user);

    void addUser(User user);

    void deleteUser(Integer id);

}

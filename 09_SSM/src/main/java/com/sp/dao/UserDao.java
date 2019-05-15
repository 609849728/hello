package com.sp.dao;

import com.sp.entity.User;

import java.util.List;

public interface UserDao {

    List<User> getUserList();

    User getUserById(Integer id);

    void updateUser(User user);

    void addUser(User user);

    void deleteUser(Integer id);

}

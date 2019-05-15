package com.sp.service.impl;


import com.sp.dao.UserDao;
import com.sp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public String getPassword(String username) {
        return userDao.getPassword(username);
    }


}

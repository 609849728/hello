package com.sp.service.impl;

import com.sp.dao.UserDao;
import com.sp.entity.User;
import com.sp.service.UserService;
import com.sp.web.mapper.IBaseMapper;
import com.sp.web.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {


    @Autowired
    private UserDao userDao;


    @Override
    protected IBaseMapper<User> getBaseMapper() {
        return userDao;
    }

    @Override
    public User login(String username, String password) {
        return userDao.login(username,password);
    }

}

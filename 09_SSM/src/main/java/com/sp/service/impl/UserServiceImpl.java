package com.sp.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sp.dao.UserDao;
import com.sp.entity.User;
import com.sp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public PageInfo getUserList(Integer pageNum) {
        Integer pageSize = 4;  //页面大小

        if(pageNum==null) {
            PageHelper.offsetPage(0,pageSize);
        } else {
            PageHelper.offsetPage((pageNum-1)*pageSize,pageSize);
        }

        List<User> userList = userDao.getUserList();

        PageInfo pageInfo = new PageInfo(userList);
        return pageInfo;
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.getUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }

}

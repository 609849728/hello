package com.sp.service.impl;


import com.sp.dao.UserDao;
import com.sp.entity.Book;
import com.sp.entity.User;
import com.sp.service.UserService;
import com.sp.web.dao.IBaseDao;
import com.sp.web.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    protected IBaseDao<User> getBaseDao() {
        return userDao;
    }


    //登录
    @Override
    public User login(String name, String password) {
        return userDao.login(name,password);
    }


    //查询所有用户，用于显示在书籍的添加页面
    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }


    //根据作者id，查询作者所有的书籍
    @Override
    public User getBookListByUserId(Integer id) {
        return userDao.getBookListByUserId(id);
    }


    //根据用户的id，删除用户的同时，用户的书籍也应该全部删除
    @Override
    public void removeUserAndBook(Integer id) {
        //先删除关联
        userDao.removeUserAndBook(id);
        //再删除用户
        userDao.remove(id);
    }


}

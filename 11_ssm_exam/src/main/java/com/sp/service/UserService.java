package com.sp.service;

import com.sp.entity.Book;
import com.sp.entity.User;
import com.sp.web.service.IBaseService;

import java.util.List;

public interface UserService extends IBaseService<User> {


    //登录
    User login(String name,String password);


    //查询所有用户，用于显示在书籍的添加页面
    List<User> getAllUser();


    //根据作者id，查询作者所有的书籍
    User getBookListByUserId(Integer id);

    //根据用户的id，删除用户的同时，用户的书籍也应该全部删除
    void removeUserAndBook(Integer id);

}

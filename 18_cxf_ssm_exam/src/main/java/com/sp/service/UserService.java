package com.sp.service;

import com.sp.entity.User;
import com.sp.web.service.IBaseService;

public interface UserService extends IBaseService<User> {

    User login(String username,String password);

}

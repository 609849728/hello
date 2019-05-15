package com.sp.dao;

import com.sp.entity.User;
import com.sp.web.mapper.IBaseMapper;

public interface UserDao extends IBaseMapper<User> {

    User login(String username,String password);

}

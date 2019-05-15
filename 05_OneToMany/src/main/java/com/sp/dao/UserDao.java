package com.sp.dao;

import com.sp.entity.User;

public interface UserDao {

    //一对多：根据id查询用户信息，并且查询出此用户的所有订单
    User getUserById(Integer id);

}

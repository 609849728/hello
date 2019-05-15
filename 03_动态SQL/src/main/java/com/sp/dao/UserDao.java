package com.sp.dao;

import com.sp.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface UserDao {


    //模糊查询username，测试<if>元素。一个参数的情况，不会包装成map，想要在各种SQL动态元素中使用，就必须添加@Param注解
    List<User> getUserList(@Param("username")String username);


    //使用<where>元素，模糊查询username
    List<User> getUserList02(@Param("username")String username);


    //测试传入的参数为数组，<foreach>元素的使用
    List<User> getUserListById(Object[] obj);


    //测试<bind>元素，传入的参数是普通类型时，必须要加@Param注解
    List<User> bindTest02(@Param("name")String name);


}

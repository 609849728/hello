package com.sp.dao;

import com.sp.entity.Customer;

import java.util.List;

public interface CustomerDao {


    /*
    <choose><when><otherwise>
    当名称不为空，则只根据名称进行模糊查询
    当名称为空，而职业不为空，则根据职业进行模糊查询
    当名称和职业都为空时，就查询所有电话不为空的

    这里是多个参数，可以不用加@Param注解，自动包装成map，动态SQL使用时，直接用形参名获取参数即可
    单个参数，要在动态SQL使用时，就必须添加@Param注解
     */
    List<Customer> getCustomerList(String name,String job);


    //测试<set>元素，主要用于更新操作
    void updateCustomer(Customer customer);


    //测试<trim>元素，该元素使用灵活，可以替代<where>和<set>
    //替代<where>
    List<Customer> getCustomerList02(String name,String job);
    //替代<set>
    void updateCustomer02(Customer customer);


}

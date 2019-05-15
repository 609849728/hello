package com.sp.dao;


import com.sp.entity.Order;

public interface OrderDao {


    //多对一==一对一：查询订单信息，并查询出该订单属于哪个用户
    Order getOrderById(Integer id);


}

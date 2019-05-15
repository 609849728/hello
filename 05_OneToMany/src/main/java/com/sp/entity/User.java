package com.sp.entity;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private Integer id;

    private String username;

    private String password;

    private List<Order> orderList;  //一对多，一个用户存在多个订单


}

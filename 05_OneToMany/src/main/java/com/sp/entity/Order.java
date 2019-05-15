package com.sp.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {

    private Integer id;

    private Date createTime;

    private User user;  //一个订单对应一个用户

}

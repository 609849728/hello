package com.sp.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Leave {

    private Integer id;

    private String reason;  //请假原因

    private Integer days;  //请假天数

    private Date createTime;  //请假条的创建时间

    private Integer state;  //请假状态，0表示为审核，1表示审核中，2表示审核通过

    private Emp emp;  //请假人

}
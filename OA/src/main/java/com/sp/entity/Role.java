package com.sp.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Role {

    private Integer id;

    private String roleName;  //角色名称

    private String roleDesc;  //角色描述

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date roleCreateTime;  //创建时间

}
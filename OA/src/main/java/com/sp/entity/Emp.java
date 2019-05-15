package com.sp.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Emp {

    private Integer id;

    private String username;

    private String password;

    private String salt;

    private Integer sex;

    private String email;

    private Integer phone;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date hiredate;

    private Dept dept;  //用户所对应的部门

    private String roleName;  //角色名称

    private Integer reId;  //中间表的主键

}
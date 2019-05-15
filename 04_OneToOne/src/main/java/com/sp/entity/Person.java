package com.sp.entity;

import lombok.Data;

//人
@Data
public class Person {

    private Integer id;

    private String name;

    private Code code;  //关联的身份证，一个人对应一张身份证

}

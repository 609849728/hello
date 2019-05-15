package com.sp.entity;

import lombok.Data;

import java.util.List;

@Data
public class Teacher {

    private Integer id;

    private String name;

    private List<Class> classList;  //多对多，一个老师同时教多个班级

}

package com.sp.entity;

import lombok.Data;

import java.util.List;

@Data
public class Class {

    private Integer id;

    private String className;

    private List<Teacher> teacherList;  //多对多，一个班级可以有多个老师带课

}

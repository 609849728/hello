package com.sp.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Dept {

    private Integer id;  //部门id

    private String deptName;  //部门名称

    private String deptDesc;  //部门描述

    private Integer deptIndex;  //部门排序规则

    private Integer deptState;  //部门状态，0表示不可用，1表示可用

    private Date deptCreateTime;  //部门创建时间

    private Integer deptParentId;  //父部门的id

    private String deptParentName;  //父部门的名称

    private Integer sonId;  //子部门的id，如果为空，在树里就是文件形式，如果不为空就是文件夹形式

}
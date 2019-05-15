package com.sp.entity;

import lombok.Data;

@Data
public class Menu {

    private Integer id;

    private String menuName;

    private String menuDesc;

    private Integer menuType;  //类型，1为目录，0为菜单

    private String menuUrl;

    private String menuCode;

    private String menuParentName;  //菜单的所属目录名称

    private Integer menuParentId;  //菜单的所属目录的id

    private Integer sonId;  //目录的子id

    private Integer rmId;  //中间表的主键

}
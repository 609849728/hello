package com.sp.mapper;

import com.sp.entity.Menu;

import java.util.List;
import java.util.Set;

public interface MenuMapper extends BaseMapper<Menu> {

    //获取Menu的树，也就是获取目录
    List<Menu> getMenuTree(Integer id);

    //根据用户id，查询它拥有的所有菜单对象
    Set<Menu> getSetMenuByEmpId(Integer empId);


    //根据用户名，查询它拥有的所有菜单
    Set<String> getSetMenuByEmpName(String empName);

}
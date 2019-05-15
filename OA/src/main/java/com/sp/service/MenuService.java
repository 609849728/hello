package com.sp.service;

import com.sp.entity.Menu;

import java.util.List;
import java.util.Set;


public interface MenuService extends BaseService<Menu> {

    //获取Menu的树，也就是获取目录
    List<Menu> getMenuTree(Integer id);


    //根据用户id，查询它拥有的所有菜单
    Set<Menu> getSetMenuByEmpId(Integer empId);


    //是否进行拦截，如果访问的url在存在它的菜单里，那么就代表有这个权限，可以访问，否则就进行拦截
    boolean needInterceptor(String empName,String requestURI);

    //根据用户名，查询它拥有的所有菜单
    Set<String> getSetMenuByEmpName(String empName);


}

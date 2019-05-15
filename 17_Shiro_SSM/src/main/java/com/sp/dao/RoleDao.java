package com.sp.dao;

import java.util.Set;

public interface RoleDao {

    //通过用户名查询该用户拥有哪些角色
    Set<String> getRoleSetByUsername(String username);

}

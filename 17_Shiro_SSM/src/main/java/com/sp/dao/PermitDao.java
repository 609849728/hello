package com.sp.dao;

import java.util.Set;

public interface PermitDao {

    //通过用户名，查询该用户拥有的权限
    Set<String> getPermitSetByUsername(String username);

}

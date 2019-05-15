package com.sp.service;

import java.util.Set;

public interface PermitService {

    //通过用户名，查询该用户拥有的权限
    Set<String> getPermitSetByUsername(String username);

}

package com.sp.service;

import com.sp.entity.Emp;

public interface EmpService extends BaseService<Emp> {

    //登录，传入用户名
    Emp getEmpByUsername(String username);


}

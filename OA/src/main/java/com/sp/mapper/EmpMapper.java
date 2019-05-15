package com.sp.mapper;

import com.sp.entity.Emp;

public interface EmpMapper extends BaseMapper<Emp> {


    //登录，传入用户名
    Emp getEmpByUsername(String username);


}
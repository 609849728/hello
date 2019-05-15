package com.sp.service.impl;

import com.sp.entity.Emp;
import com.sp.mapper.BaseMapper;
import com.sp.mapper.EmpMapper;
import com.sp.service.EmpService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl extends BaseServiceImpl<Emp> implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    protected BaseMapper<Emp> getBaseMapper() {
        return empMapper;
    }


    @Override
    public Emp getEmpByUsername(String username) {
        Emp emp = empMapper.getEmpByUsername(username);

        return emp;
    }

}

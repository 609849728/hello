package com.sp.service.impl;

import com.sp.entity.Role;
import com.sp.mapper.BaseMapper;
import com.sp.mapper.RoleMapper;
import com.sp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    protected BaseMapper<Role> getBaseMapper() {
        return roleMapper;
    }


}

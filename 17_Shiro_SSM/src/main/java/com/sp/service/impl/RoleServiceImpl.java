package com.sp.service.impl;

import com.sp.dao.RoleDao;
import com.sp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Set<String> getRoleSetByUsername(String username) {
        return roleDao.getRoleSetByUsername(username);
    }

}

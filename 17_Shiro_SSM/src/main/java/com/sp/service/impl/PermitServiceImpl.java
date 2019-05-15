package com.sp.service.impl;

import com.sp.dao.PermitDao;
import com.sp.service.PermitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PermitServiceImpl implements PermitService {

    @Autowired
    private PermitDao permitDao;

    @Override
    public Set<String> getPermitSetByUsername(String username) {
        return permitDao.getPermitSetByUsername(username);
    }
}

package com.sp.service.impl;


import com.sp.entity.Dept;
import com.sp.mapper.BaseMapper;
import com.sp.mapper.DeptMapper;
import com.sp.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl extends BaseServiceImpl<Dept> implements DeptService {


    @Autowired
    private DeptMapper deptMapper;


    @Override
    protected BaseMapper<Dept> getBaseMapper() {
        return deptMapper;
    }


    @Override
    public List<Dept> getDeptTree(Integer id) {
        return deptMapper.getDeptTree(id);
    }

}

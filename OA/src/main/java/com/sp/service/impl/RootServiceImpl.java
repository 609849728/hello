package com.sp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sp.entity.Emp;
import com.sp.entity.Menu;
import com.sp.mapper.RootMapper;
import com.sp.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RootServiceImpl implements RootService {

    @Autowired
    private RootMapper rootMapper;



    @Override
    public List<Emp> getListEmpByRoleId(Integer roleId) {
        return rootMapper.getListEmpByRoleId(roleId);
    }


    @Override
    public PageInfo getPageInfoEmpByRoleId(Integer pageNum, Integer pageSize, Integer roleId) {
        if(pageSize==null) {
            pageSize = 4;
        }

        if(pageNum==null || pageNum==0) {
            PageHelper.offsetPage(0,pageSize);
        } else {
            PageHelper.offsetPage((pageNum-1)*pageSize,pageSize);
        }

        List<Emp> list = rootMapper.getListEmpByRoleId(roleId);

        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public int batchDelete(Integer[] ids) {
        return rootMapper.batchDelete(ids);
    }

    @Override
    public int batchRoot(Integer roleId, Integer[] ids) {
        return rootMapper.batchRoot(roleId,ids);
    }

    @Override
    public List<Map<String, Object>> getMenuTree(Integer roleId) {
        return rootMapper.getMenuTree(roleId);
    }

    @Override
    public int batchDeleteMenu(Integer id) {
        return rootMapper.batchDeleteMenu(id);
    }

    @Override
    public int batchRootMenu(Integer roleId, Integer[] ids) {
        return rootMapper.batchRootMenu(roleId,ids);
    }

    @Override
    public List<Emp> getEmpListByRoleId(Integer roleId) {
        return rootMapper.getEmpListByRoleId(roleId);
    }

    @Override
    public List<Menu> getMenuListByRoleId(Integer roleId) {
        return rootMapper.getMenuListByRoleId(roleId);
    }


    @Override
    public int deleteEmp(Integer reId) {
        return rootMapper.deleteEmp(reId);
    }

    @Override
    public int deleteMenu(Integer rmId) {
        return rootMapper.deleteMenu(rmId);
    }

}

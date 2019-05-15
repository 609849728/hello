package com.sp.service.impl;

import com.sp.entity.Menu;
import com.sp.mapper.BaseMapper;
import com.sp.mapper.MenuMapper;
import com.sp.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;


    @Override
    protected BaseMapper<Menu> getBaseMapper() {
        return menuMapper;
    }

    @Override
    public List<Menu> getMenuTree(Integer id) {
        return menuMapper.getMenuTree(id);
    }


    @Override
    public Set<Menu> getSetMenuByEmpId(Integer empId) {
        return menuMapper.getSetMenuByEmpId(empId);
    }


    @Override
    public boolean needInterceptor(String empName,String requestURI) {
        Set<String> menuUrlSet = getSetMenuByEmpName(empName);

        for(String url:menuUrlSet) {
            if(url != null) {
                if(url.startsWith(requestURI)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public Set<String> getSetMenuByEmpName(String empName) {
        return menuMapper.getSetMenuByEmpName(empName);
    }

}

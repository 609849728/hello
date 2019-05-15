package com.sp.controller;

import com.sp.entity.Role;
import com.sp.service.BaseService;
import com.sp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/RoleController")
public class RoleController extends BaseController<Role> {

    @Autowired
    private RoleService roleService;

    @Override
    protected BaseService<Role> getBaseService() {
        return roleService;
    }

}

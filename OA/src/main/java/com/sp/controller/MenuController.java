package com.sp.controller;

import com.google.gson.Gson;
import com.sp.entity.Dept;
import com.sp.entity.Menu;
import com.sp.service.BaseService;
import com.sp.service.MenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/MenuController")
public class MenuController extends BaseController<Menu> {

    @Autowired
    private MenuService menuService;

    @Override
    protected BaseService<Menu> getBaseService() {
        return menuService;
    }


    @RequestMapping(value = "/getMenuTree",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getMenuTree(Integer id) {
        if(id == null) {
            id = 0;
        }

        List<Menu> menuList = menuService.getMenuTree(id);

        List<Map<String,Object>> list = new ArrayList<>();
        for(Menu menu : menuList) {
            Map<String,Object> map = new HashMap<>();

            map.put("id",menu.getId());
            map.put("pid",menu.getMenuParentId());
            map.put("name",menu.getMenuName());
            map.put("isParent",menu.getSonId() == null ? false : true);

            list.add(map);
        }

        //转成JSON格式，返回
        return new Gson().toJson(list);
    }



}

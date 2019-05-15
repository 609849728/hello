package com.sp.controller;

import com.google.gson.Gson;
import com.sp.entity.Dept;
import com.sp.service.BaseService;
import com.sp.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/DeptController")
public class DeptController extends BaseController<Dept> {

    @Autowired
    private DeptService deptService;


    @Override
    protected BaseService<Dept> getBaseService() {
        return deptService;
    }


    //查询所有父部门(树插件)，用于添加部门信息时，点击选择父部门的异步加载
    @RequestMapping(value = "/getDeptTree",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getDeptTree(Integer id) {
        if(id == null) {
            id = 0;
        }

        List<Dept> deptList = deptService.getDeptTree(id);

        List<Map<String,Object>> list = new ArrayList<>();
        for(Dept dept:deptList) {
            Map<String,Object> map = new HashMap<>();
            map.put("id",dept.getId());
            map.put("pid",dept.getDeptParentId());
            map.put("name",dept.getDeptName());
            map.put("isParent",dept.getSonId() == null ? false : true);

            list.add(map);
        }

        //转成JSON格式，返回
        return new Gson().toJson(list);
    }







}

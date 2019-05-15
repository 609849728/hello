package com.sp.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.sp.entity.Emp;
import com.sp.entity.Menu;
import com.sp.entity.Role;
import com.sp.service.EmpService;
import com.sp.service.RoleService;
import com.sp.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/RootController")
public class RootController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private EmpService empService;

    @Autowired
    private RootService rootService;


    //获取所有的角色名称，用于显示在下拉选择框里
    @RequestMapping("/getRoleList")
    public String getRoleList(Role role, Model model) {
        List<Role> list = roleService.getList(role);
        model.addAttribute("list",list);

        return "root/rootList";
    }


    //根据选择的角色名称，点击添加授权人员，传一个角色名称的id，根据id赛选
    @RequestMapping("/getEmpPageInfo/{roleId}")
    public String getEmpPageInfo(Integer pageNum, Integer pageSize, @PathVariable Integer roleId, Model model) {
        PageInfo pageInfo = rootService.getPageInfoEmpByRoleId(pageNum, pageSize, roleId);

        model.addAttribute("pageUrl","RootController/getEmpPageInfo/"+roleId+"?");
        model.addAttribute("roleId",roleId);
        model.addAttribute("page",pageInfo);
        return "root/rootEmp";
    }


    //批量授权
    @RequestMapping("/batchRoot")
    @ResponseBody
    public String batchRoot(Integer roleId,Integer[] ids) {
        rootService.batchDelete(ids);  //授权之前先删除掉已经授权过的用户

        int i = rootService.batchRoot(roleId, ids);

        if(i>0) {
            return "true";
        }

        return "false";
    }


    //接收角色的id，跳转至treeMenu数页面
    @RequestMapping("/showMenuTree/{role}")
    public String showMenuTree(@PathVariable Integer role,Model model) {
        model.addAttribute("roleId",role);
        return "root/treeMenu";
    }


    //通过角色的id，查询它授权了的树，得到目录的树，含有多选框
    @RequestMapping(value = "/getMenuTree/{roleId}",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getMenuTree(@PathVariable Integer roleId) {
        List<Map<String, Object>> menuTree = rootService.getMenuTree(roleId);

        return new Gson().toJson(menuTree);
    }



    //批量授权菜单
    @RequestMapping("/batchRootMenu")
    @ResponseBody
    public String batchRootMenu(Integer roleId,Integer[] ids) {
        rootService.batchDeleteMenu(roleId);  //授权菜单之前，先把该角色授权了的菜单删除掉

        int i = rootService.batchRootMenu(roleId,ids);

        if(i>0) {
            return "true";
        }

        return "false";
    }



    //查询类型为用户
    @RequestMapping("/getEmpPageInfoByRoleId/{roleId}")
    public String getEmpPageInfoByRoleId(@PathVariable Integer roleId,Model model) {
        List<Emp> list = rootService.getEmpListByRoleId(roleId);

        model.addAttribute("list",list);
        return "root/empList";
    }



    //查询类型为菜单
    @RequestMapping("/getMenuPageInfoByRoleId/{roleId}")
    public String getMenuPageInfoByRoleId(@PathVariable Integer roleId,Model model) {
        List<Menu> list = rootService.getMenuListByRoleId(roleId);

        model.addAttribute("list",list);
        return "root/menuList";
    }


    //删除中间表的用户
    @RequestMapping("/deleteEmp/{reId}")
    @ResponseBody
    public String deleteEmp(@PathVariable Integer reId) {
        int i = rootService.deleteEmp(reId);

        if(i > 0) {
            return "true";
        }
        return "false";
    }


    //删除中间表的菜单
    @RequestMapping("/deleteMenu/{rmId}")
    @ResponseBody
    public String deleteMenu(@PathVariable Integer rmId) {
        int i = rootService.deleteMenu(rmId);

        if(i > 0) {
            return "true";
        }
        return "false";
    }




}

package com.sp.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {


    @RequestMapping("/index")
    public String index(){
        return "index";
    }


    @RequiresPermissions("deleteOrder")
    @RequestMapping("/deleteOrder")
    public String deleteOrder(){
        return "deleteOrder";
    }


    @RequiresRoles("admin")
    @RequestMapping("/deleteProduct")
    public String deleteProduct(){
        return "deleteProduct";
    }


    @RequestMapping("/listProduct")
    public String listProduct(){
        return "listProduct";
    }


    @GetMapping("/toLogin")
    public String toLogin(){
        System.out.println("toLogin()");
        return "login";
    }


    @RequestMapping("/unauthorized")
    public String noPerms(){
        return "unauthorized";
    }


}

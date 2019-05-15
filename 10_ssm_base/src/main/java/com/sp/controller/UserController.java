package com.sp.controller;

import com.github.pagehelper.PageInfo;
import com.sp.entity.User;
import com.sp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/UserController")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/getUserList")
    public String getUserList(Integer pageNum, Model model) {
        PageInfo pageInfo = userService.getPageInfo(pageNum);

        model.addAttribute("page",pageInfo);
        model.addAttribute("pageUrl","UserController/getUserList?");
        return "userList";
    }


    @RequestMapping("/addUser")
    public String addUser(User user) {
        userService.add(user);

        return "redirect:/UserController/getUserList";
    }


    @RequestMapping("/getUserById/{id}")
    public String getUserById(@PathVariable Integer id, Model model) {
        User user = userService.getById(id);

        model.addAttribute("user",user);
        return "userUpdate";
    }


    @RequestMapping("/updateUser")
    public String updateUser(User user) {
        userService.edit(user);

        return "redirect:/UserController/getUserList";
    }


    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.remove(id);

        return "redirect:/UserController/getUserList";
    }



}

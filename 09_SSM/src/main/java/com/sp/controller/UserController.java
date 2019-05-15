package com.sp.controller;

import com.github.pagehelper.PageInfo;
import com.sp.entity.User;
import com.sp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/UserController")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/getUserList/{pageNum}")
    public String getUserList(@PathVariable Integer pageNum,Model model) {
        PageInfo pageInfo = userService.getUserList(pageNum);

        model.addAttribute("pageUrl","UserController/getUserList");
        model.addAttribute("page",pageInfo);
        return "userList";
    }


    @RequestMapping("/addUser")
    public String addUser(User user) {
        userService.addUser(user);

        return "redirect:/UserController/getUserList/1";
    }


    @RequestMapping("/getUserById/{id}")
    public String getUserById(@PathVariable Integer id, Model model) {
        User user = userService.getUserById(id);

        model.addAttribute("user",user);
        return "updateUser";
    }


    @RequestMapping("/updateUser")
    public String updateUser(User user) {
        userService.updateUser(user);

        return "redirect:/UserController/getUserList/1";
    }


    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);

        return "redirect:/UserController/getUserList/1";
    }


}

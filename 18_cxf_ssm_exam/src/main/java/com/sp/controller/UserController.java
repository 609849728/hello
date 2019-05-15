package com.sp.controller;

import com.github.pagehelper.PageInfo;
import com.sp.entity.User;
import com.sp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/userController")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    public String login(String username, String password, HttpServletRequest request) {
        User user = userService.login(username, password);

        if(user == null) {
            return "redirect:/login.jsp";
        }

        //登录成功
        request.getSession().setAttribute("USER_SESSION",user);
        return "redirect:/";
    }


    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }


    @RequestMapping("/getUserPageInfo")
    public String getUserPageInfo(Integer pageNum, Integer pageSize, Model model) {
        PageInfo pageInfo = userService.getPageInfo(pageNum, pageSize);

        model.addAttribute("page",pageInfo);
        model.addAttribute("pageUrl","userController/getUserPageInfo?");
        return "userList";
    }


    @RequestMapping("/addUser")
    public String addUser(User user) {
        userService.insertSelective(user);

        return "redirect:/userController/getUserPageInfo";
    }


    @RequestMapping("/getUserById/{id}")
    public String getUserById(@PathVariable Integer id,Model model) {
        User user = userService.selectByPrimaryKey(id);

        model.addAttribute("user",user);
        return "userUpdate";
    }


    @RequestMapping("/updateUser")
    public String updateUser(User user) {
        userService.updateByPrimaryKeySelective(user);

        return "redirect:/userController/getUserPageInfo";
    }


    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteByPrimaryKey(id);

        return "redirect:/userController/getUserPageInfo";
    }


}

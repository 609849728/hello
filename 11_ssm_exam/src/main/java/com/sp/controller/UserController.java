package com.sp.controller;

import com.github.pagehelper.PageInfo;
import com.sp.entity.Book;
import com.sp.entity.User;
import com.sp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/UserController")
public class UserController {

    @Autowired
    private UserService userService;


    //去登录
    @GetMapping("/login")
    public String toLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String name, String password, HttpServletRequest request) {
        User u = userService.login(name, password);

        if(u!=null) {
            //如果正确，存进session
            request.getSession().setAttribute("u",u);
            return "redirect:getUserList";
        }

        request.setAttribute("msg","用户名或密码错误！");
        return "login";
    }



    @RequestMapping("/getUserList")
    public String getUserList(Integer pageNum, Model model) {
        PageInfo pageInfo = userService.getPageInfo(pageNum);

        model.addAttribute("page",pageInfo);
        model.addAttribute("pageUrl","UserController/getUserList?");

        return "userList";
    }



    @RequestMapping("/getUserById/{id}")
    public String getUserById(@PathVariable Integer id,Model model) {
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
        //删除用户的同时，用户的书籍也当然要跟着全部删除
        userService.removeUserAndBook(id);

        return "redirect:/UserController/getUserList";
    }



    @RequestMapping("/addUser")
    public String addUser(User user) {
        userService.add(user);

        return "redirect:/UserController/getUserList";
    }



    //根据作者id，查询作者的所有书籍
    @RequestMapping("/getBookByUserId/{id}")
    public String getBookByUserId(@PathVariable Integer id,Model model) {
        User user = userService.getBookListByUserId(id);

        model.addAttribute("user",user);
        return "user_book";
    }






}

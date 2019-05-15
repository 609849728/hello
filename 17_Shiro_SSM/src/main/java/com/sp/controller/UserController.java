package com.sp.controller;

import com.sp.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/UserController")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/login")
    public String login(String username, String password, Model model) {
        System.out.println("UserController.login()");
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token = new UsernamePasswordToken(username,password);

        try {
            subject.login(token);
            Session session = subject.getSession();
            session.setAttribute("subject",subject);
            return "redirect:/index";
        } catch (AuthenticationException e) {
            model.addAttribute("msg","用户名或密码错误！");
            return "login";
        }

    }


}

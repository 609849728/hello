package com.sp.servlet;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取账号和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //获得Subject对象
        Subject subject = SecurityUtils.getSubject();

        //将用户名和密码存进token中，进行判断
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);


        //如果用户名和密码错误，会报AuthenticationException异常
        try {
            /*
            登录操作：
            到此处时就会进入我们编写的Realm类里进行判断验证doGetAuthenticationInfo
            如果在doGetAuthenticationInfo方法里验证失败，会抛出throw new AuthenticationException();异常
            这时catch就会扑获到，然后进行相应的操作
             */
            subject.login(token);

            /*
            登录成功的话：
            获取shiro的session对象
            shiro的这个session和httpsession是串通好了的，所以在这里放了，它会自动放在httpsession里，它们之间是同步的
             */
            Session session = subject.getSession();
            //存放进Session对象里
            session.setAttribute("subject",subject);

            response.sendRedirect("/");
        } catch (AuthenticationException e) {
            //用户名和密码错误！
            request.setAttribute("msg","用户名或密码错误！");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }


    }
}

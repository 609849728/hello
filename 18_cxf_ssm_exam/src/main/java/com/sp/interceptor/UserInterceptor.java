package com.sp.interceptor;

import com.sp.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        System.out.println("---拦截---");

        //获取用户
        User user = (User) request.getSession().getAttribute("USER_SESSION");

        //判断用户是否登录
        if(user==null) {
            //没登录就跳转至登录页面
            response.sendRedirect("/login.jsp");
            return false;
        }

        //登录了就放行，mvc配置文件已经忽略了登录的url，所以不会拦截登录的请求
        return true;
    }
}

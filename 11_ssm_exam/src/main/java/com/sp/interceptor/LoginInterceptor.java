package com.sp.interceptor;

import com.sp.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException {
        System.out.println("---preHandle---");

        //获取用户
        User u = (User) request.getSession().getAttribute("u");

        //判断用户是否登录
        if(u==null) {
            //没登录就跳转至登录页面
            request.setAttribute("msg","你还没有登录，请先登录！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            return false;
        }

        //登录了就放行，mvc配置文件已经忽略了登录的url，所以不会拦截登录的请求
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        System.out.println("---postHandle---");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        System.out.println("---afterCompletion---");
    }

}

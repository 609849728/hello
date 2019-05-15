package com.sp.filter;

import com.sp.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class URLPathMatchingFilter extends PathMatchingFilter {

    @Autowired
    private MenuService menuService;


    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        //获取访问的url
        String requestUrl = getPathWithinApplication(request);
        String[] split = requestUrl.split("/");
        requestUrl = "/"+split[1];
        //System.out.println(requestUrl);

        Subject subject = SecurityUtils.getSubject();

        //如果没有登录，就跳转至登录界面
        if(!subject.isAuthenticated()) {
            WebUtils.issueRedirect(request,response,"/toLogin");
            return false;
        }

        //如果登录了，就获取用户名
        String username = subject.getPrincipal().toString();
        //查看该用户是否有权限可以访问此URL
        boolean flag = menuService.needInterceptor(username, requestUrl);

        if(flag) {
            return true;
        } else {
            //返回false，代表不可以访问
            UnauthorizedException ex = new UnauthorizedException("当前用户没有访问路径 " + requestUrl + " 的权限");

            subject.getSession().setAttribute("e", ex);

            WebUtils.issueRedirect(request, response, "/unauthorized");
            return false;
        }

    }


}

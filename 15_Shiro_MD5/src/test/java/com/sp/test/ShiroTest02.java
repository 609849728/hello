package com.sp.test;

import com.sp.dao.UserDao;
import com.sp.dao.impl.UserDaoImpl;
import com.sp.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class ShiroTest02 {

    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl();

        //注册
        userDao.createUser("hxz","520");

        //然后登录
        User user = new User("hxz","520");
        if(login(user)) {
            System.out.println("登录成功！");
        } else {
            System.out.println("登录失败！");
        }
    }


    //获取Subject
    private static Subject getSubject(User user) {
        //1.加载配置文件，并获取工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro02.ini");

        //2.获取安全管理者的实例
        SecurityManager sm = factory.getInstance();

        //3.将安全管理者放入全局对象
        SecurityUtils.setSecurityManager(sm);

        //4.全局对象通过安全管理者生成Subject对象
        Subject subject = SecurityUtils.getSubject();

        return subject;
    }


    private static boolean hasRole(User user, String role) {
        Subject subject = getSubject(user);
        return subject.hasRole(role);
    }


    private static boolean isPermitted(User user, String permit) {
        Subject subject = getSubject(user);
        return subject.isPermitted(permit);
    }



    //登录
    private static boolean login(User user) {
        Subject subject = getSubject(user);

        //如果已经登录过了，那么就退出
        if(subject.isAuthenticated()) {
            subject.logout();
        }

        //封装用户的数据(用户名和密码)
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());

        //将用户的数据token 最终传递到Realm中进行对比
        try {
            subject.login(token);
        } catch (Exception e) {
            //验证错误，用户名和密码不匹配
            return false;
        }

        return subject.isAuthenticated();
    }


}

package com.sp.test;

import com.sp.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

import java.util.ArrayList;
import java.util.List;

public class ShiroTest {

    public static void main(String[] args) {
        //假设有3个用户
        User user1 = new User("li4","abcde");
        User user2 = new User("钢铁侠","456");
        User user3 = new User("灭霸","789");
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);


        //2种角色
        String roleAdmin = "admin";  //管理员
        String roleProductManager ="productManager";  //产品经理
        List<String> roleList = new ArrayList<>();
        roleList.add(roleAdmin);
        roleList.add(roleProductManager);


        //2种权限
        String permitAddProduct = "addProduct";  //添加产品
        String permitAddOrder = "addOrder";  //添加订单
        List<String> permitList = new ArrayList<>();
        permitList.add(permitAddProduct);
        permitList.add(permitAddOrder);


        //将每个用户进行登录
        for(User user:userList) {
            if(login(user)) {
                System.out.println(user.getUsername()+"登录成功！密码为："+user.getPassword());
            } else {
                System.out.println(user.getUsername()+"登录失败！密码为："+user.getPassword());
            }
        }

        System.out.println("#################################################################");

        //判断能够登录的用户是否拥有某个角色
        for(User user:userList) {
            for(String role:roleList) {
                if(login(user)) {
                    if(hasRole(user,role)) {
                        System.out.println(user.getUsername()+"拥有角色："+role);
                    } else {
                        System.out.println(user.getUsername()+"不拥有角色："+role);
                    }
                }
            }
        }

        System.out.println("#################################################################");

        //判断能够登录的用户是否拥有某种权限
        for(User user:userList) {
            for(String permit:permitList) {
                if(login(user)) {
                    if(isPermitted(user,permit)) {
                        System.out.println(user.getUsername()+"拥有权限："+permit);
                    } else {
                        System.out.println(user.getUsername()+"不拥有角色："+permit);
                    }
                }
            }
        }

    }


    //获取Subject
    private static Subject getSubject(User user) {
        //1.加载配置文件，并获取工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

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

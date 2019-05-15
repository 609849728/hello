package com.sp.realm;

import com.sp.entity.Emp;
import com.sp.service.EmpService;
import com.sp.service.MenuService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private EmpService empService;

    @Autowired
    private MenuService menuService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户名
        String username = principalCollection.getPrimaryPrincipal().toString();

        //通过用户名获取它的所有菜单的url
        Set<String> menuUrlSet = menuService.getSetMenuByEmpName(username);

        //
        SimpleAuthorizationInfo sai = new SimpleAuthorizationInfo();
        sai.setStringPermissions(menuUrlSet);

        return sai;
    }


    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取输入的账号
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getPrincipal().toString();

        //通过用户名查询用户，登录
        Emp emp = empService.getEmpByUsername(username);

        //如果为空，那就是用户名不存在
        if(emp == null) {
            throw new AuthenticationException();
        }

        //不为空，那就代表有该用户，获取他的密码和盐
        String password = emp.getPassword();
        String salt = emp.getSalt();

        //交给Shrio自动效验，需要在配置文件中配置
        SimpleAuthenticationInfo a = new SimpleAuthenticationInfo(username,password,ByteSource.Util.bytes(salt),getName());
        return a;
    }


}

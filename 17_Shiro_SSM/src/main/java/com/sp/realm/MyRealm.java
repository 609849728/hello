package com.sp.realm;

import com.sp.service.PermitService;
import com.sp.service.RoleService;
import com.sp.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermitService permitService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户名
        String username = principalCollection.getPrimaryPrincipal().toString();

        //通过用户名获取该用户的角色和权限
        Set<String> roleSet = roleService.getRoleSetByUsername(username);
        Set<String> permitSet = permitService.getPermitSetByUsername(username);

        SimpleAuthorizationInfo sai = new SimpleAuthorizationInfo();
        sai.setRoles(roleSet);
        sai.setStringPermissions(permitSet);

        return sai;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取输入的账号和密码
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getPrincipal().toString();
        String password = new String(token.getPassword());


        //通过用户名获取用户密码
        String passwordDB = userService.getPassword(username);

        //验证
        if(passwordDB == null || !password.equals(passwordDB)) {
            throw new AuthenticationException();
        }

        SimpleAuthenticationInfo sai = new SimpleAuthenticationInfo(username,password,getName());
        return sai;
    }


}

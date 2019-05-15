package com.sp.realm;

import com.sp.dao.UserDao;
import com.sp.dao.impl.UserDaoImpl;
import com.sp.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.Set;

/*
在 Shiro 中存在 Realm 这么个概念， Realm 这个单词翻译为 域，其实是非常难以理解的。
域 是什么鬼？和权限有什么毛关系？
那么 Realm 在 Shiro里到底扮演什么角色呢？
当应用程序向 Shiro 提供了 账号和密码之后， Shiro 就会问 Realm 这个账号密码是否对， 如果对的话，其所对应的用户拥有哪些角色，哪些权限。
所以Realm 是什么？
其实就是个中介。 Realm 得到了 Shiro 给的用户和密码后，有可能去找 ini 文件，就像Shiro 入门中的 shiro.ini，也可以去找数据库，就如同本知识点中的 DAO 查询信息。

Realm 就是干这个用的，它才是真正进行用户认证和授权的关键地方。
*/


/*
DatabaseRealm这个类，用户提供，但是不由用户自己调用，而是由 Shiro 去调用。 就像Servlet的doPost方法，是被Tomcat调用一样。
那么 Shiro 怎么找到这个 Realm 呢？ 那么就需要下一步，修改 shiro.ini
*/
public class MyRealm02 extends AuthorizingRealm {


    /*
    授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //能进入到这里，表示账号已经通过验证了
        String username = (String) principalCollection.getPrimaryPrincipal();

        //通过Dao获取角色和权限
        UserDao userDao = new UserDaoImpl();
        Set<String> roleSet = userDao.getListRoleByUser(username);
        Set<String> permitSet = userDao.getListPermitByUser(username);

        //授权对象
        SimpleAuthorizationInfo sai = new SimpleAuthorizationInfo();

        //把通过dao获取到的角色和权限放进去
        sai.setRoles(roleSet);
        sai.setStringPermissions(permitSet);

        return sai;
    }


    /*
    认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println(this.getCredentialsMatcher());
        //获取账号密码
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username= token.getPrincipal().toString();


        //获取数据库中的密码
        UserDao userDao = new UserDaoImpl();
        User user = userDao.getUser(username);
        String password = user.getPassword();
        String salt = user.getSalt();

        //认证信息里存放账号密码, getName() 是当前Realm的继承方法,通常返回当前类名 :databaseRealm
        //盐也放进去
        //这样通过shiro.ini里配置的 HashedCredentialsMatcher 进行自动校验
        SimpleAuthenticationInfo a = new SimpleAuthenticationInfo(username,password, ByteSource.Util.bytes(salt),getName());
        return a;
    }


}

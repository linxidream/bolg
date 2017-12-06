package com.example.mybolg.security.shiro.session;

import com.example.mybolg.entity.Module;
import com.example.mybolg.entity.Role;
import com.example.mybolg.entity.User;
import com.example.mybolg.security.shiro.pojo.UserPojo;
import com.example.mybolg.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AuthRealm extends AuthorizingRealm {

    private Logger logger= LoggerFactory.getLogger(AuthorizingRealm.class);

    @Autowired
    private UserService userService;


    //认证 登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken= (UsernamePasswordToken) authenticationToken;
        logger.info("验证当前Subject时获取到token为：" + authenticationToken.toString());
        String username=usernamePasswordToken.getUsername();//获取用户输入的token
        UserPojo userPojo = userService.userLogin(username);
        return new SimpleAuthenticationInfo(userPojo,userPojo.getPassword(),this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码
    }
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        UserPojo userPojo= (UserPojo) principalCollection.fromRealm(this.getClass().getName()).iterator().next();//获取session中的用户
        if(userPojo!=null){
            String modules=userPojo.getModules();
            SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
            simpleAuthorizationInfo.addStringPermission(modules);
            return simpleAuthorizationInfo;
        }
        return null;
    }
}

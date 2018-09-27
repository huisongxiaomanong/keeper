package com.qfedu.keep.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

@Service
public class UserRelam extends AuthorizingRealm {
    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        return simpleAuthorizationInfo;
    }

    // 认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        // 判断令牌中是否有用户的信息
        if (token.getUsername().length() > 0) {
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(token.getUsername(), token.getPassword(), getName());
            return simpleAuthenticationInfo;
        }

        return null;
    }

    //授权
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//
//        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
//
//        return simpleAuthorizationInfo;
//    }
//
//    // 代表认证
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        //获取令牌
//        UsernamePasswordToken usertoken =(UsernamePasswordToken) token;
//        // 如果外界已经进行了校验，那么这里会进行对象的封装
//        if (usertoken.getUsername().length() > 0) {
//            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(usertoken.getUsername(),usertoken.getPassword(),getName());
//            // 存放到session中
//            return simpleAuthenticationInfo;
//        }
//        return null;
//    }
}

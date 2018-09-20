package com.qfedu.keep.configure;

import com.qfedu.keep.shiro.UserRelam;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.security.auth.Subject;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfigure {

    @Bean
    public SecurityManager getSecurityManager(UserRelam userRelam) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(userRelam);
        return defaultWebSecurityManager;
    }

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("login.html");
        shiroFilterFactoryBean.setSuccessUrl("index.html");
        shiroFilterFactoryBean.setUnauthorizedUrl("noauth.html");
        Map<String, String> accessConfigura = new HashMap<>();
        accessConfigura.put("/js", "anon");
        accessConfigura.put("/login.html", " anon");
        accessConfigura.put("/adminlogin.do", "anon");
        accessConfigura.put("/regist.html", "anon");
        accessConfigura.put("/layui/**", "anon");
        accessConfigura.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(accessConfigura);
        return shiroFilterFactoryBean;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }
}

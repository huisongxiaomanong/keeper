package com.qfedu.keep.service.impl;

import com.qfedu.keep.domain.Admin;
import com.qfedu.keep.domain.ClassOrder;
import com.qfedu.keep.domain.FirstClass;
import com.qfedu.keep.domain.SecondClass;
import com.qfedu.keep.mapper.AdminMapper;
import com.qfedu.keep.mapper.ClassOrderMapper;
import com.qfedu.keep.mapper.FirstClassMapper;
import com.qfedu.keep.mapper.SecondClassMapper;
import com.qfedu.keep.service.AdminService;
import com.qfedu.keep.vo.PageVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Autowired
    ClassOrderMapper classOrderMapper;


    @Override
    public PageVo login(String name, String password) {
        Admin admin = adminMapper.selectByName(name);
        if (!Objects.equals(admin,null) && Objects.equals(admin.getPassword(), password)) {
            //获取主题---当前登录信息
            Subject subject=SecurityUtils.getSubject();
            // 创建令牌
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(admin.getName(), admin.getPassword());
            subject.login(usernamePasswordToken);
            subject.getSession().setAttribute("admin", admin);
            return PageVo.creatJson(4000, "登录成功", null);
        }
        return PageVo.creatJson(4001, "用户名或密码错误", null);
    }


    @Override
    public PageVo addClassOrder(ClassOrder classOrder) {
        int insert = classOrderMapper.insert(classOrder);
        if (insert > 0) {
            return PageVo.creatJson(5000, "添加成功", null);
        } else {
            return PageVo.creatJson(5000, "添加失败", null);
        }
    }

    @Override
    public PageVo logout() {
        SecurityUtils.getSubject().getSession().removeAttribute("user");
        return PageVo.creatJson(1000, "退出", null);
    }
}

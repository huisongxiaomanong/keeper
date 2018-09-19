package com.qfedu.keep.service.impl;

import com.qfedu.keep.domain.Admin;
import com.qfedu.keep.domain.ClassOrder;
import com.qfedu.keep.domain.FirstClass;
import com.qfedu.keep.domain.SecondClass;
import com.qfedu.keep.mapper.AdminMapper;
import com.qfedu.keep.mapper.FirstClassMapper;
import com.qfedu.keep.mapper.SecondClassMapper;
import com.qfedu.keep.service.AdminService;
import com.qfedu.keep.vo.PageVo;
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
    FirstClassMapper firstClassMapper;

    @Autowired
    SecondClassMapper secondClassMapper;

    @Override
    public PageVo login(String name, String password) {
        Admin admin = adminMapper.selectByName(name);
        if (!Objects.equals(admin,null) && Objects.equals(admin.getPassword(), password)) {
            return PageVo.creatJson(4000, "登录成功", null);
        }
        return PageVo.creatJson(4001, "用户名或密码错误", null);
    }

    @Override
    public PageVo addFirstClassType(FirstClass firstClass) {
        int insert = firstClassMapper.insert(firstClass);
        if (insert > 0) {
            return PageVo.creatJson(4000, "保存成功", null);
        } else {
            return PageVo.creatJson(4001, "保存失败", null);
        }
    }

    @Override
    public PageVo showFirstClassType() {

        return null;
    }

    @Override
    public PageVo addSecondClassType(SecondClass secondClass) {
        int insert = secondClassMapper.insert(secondClass);
        if (insert > 0) {
            return PageVo.creatJson(4000, "保存成功", null);
        } else {
            return PageVo.creatJson(4001, "保存失败", null);
        }
    }

    @Override
    public PageVo deleteClassType(String name, int level) {
        return null;
    }

    @Override
    public PageVo modifyClassType(String name, int level) {
        return null;
    }

    @Override
    public PageVo queryClassType(String name, int level) {
        return null;
    }

    @Override
    public PageVo addClassOrder(ClassOrder classOrder) {
        return null;
    }
}

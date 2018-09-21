package com.qfedu.keep.controller;

import com.qfedu.keep.common.util.JudgeNull;
import com.qfedu.keep.domain.ClassOrder;
import com.qfedu.keep.domain.FirstClass;
import com.qfedu.keep.domain.SecondClass;
import com.qfedu.keep.service.AdminService;
import com.qfedu.keep.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// 该controller主要实现后台管理者的登录和退出，以及处理用户的订单
@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    /**
     * 后台管理员登录
     * @param name
     * @param password
     * @return
     */
    @RequestMapping("adminlogin.do")
    public PageVo login(String name, String password) {
        PageVo<Object> resultPageVo = new PageVo<>();
        if (!JudgeNull.isNull(name, password)) {
            return adminService.login(name, password);
        } else {
            resultPageVo.setCode(4001);
            resultPageVo.setMsg("传入参数为空");
            return resultPageVo;
        }
    }

    /**
     * 退出登录操作
     * @return
     */
    @RequestMapping("adminloginout.do")
    public PageVo loginout() {
        return adminService.logout();
    }


    // 增加订单的操作
    @RequestMapping("addClassOrder.do")
    public PageVo addClassOrder(ClassOrder classOrder) {
        if (!JudgeNull.isNull(classOrder.getName()) && !JudgeNull.isNull(classOrder.getAllprice()) && !JudgeNull.isNull(classOrder.getSid())) {
            return adminService.addClassOrder(classOrder);
        } else {
            return PageVo.creatJson(5000, "传入的参数为空", null);
        }

    }
}

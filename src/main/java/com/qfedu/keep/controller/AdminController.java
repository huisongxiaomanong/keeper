package com.qfedu.keep.controller;

import com.qfedu.keep.common.util.JudgeNull;
import com.qfedu.keep.domain.FirstClass;
import com.qfedu.keep.domain.SecondClass;
import com.qfedu.keep.service.AdminService;
import com.qfedu.keep.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin2.main.client.MessagePassingOneWayJSObject;

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
        PageVo<Object> resultPageVo = new PageVo<>();
        return null;
    }

    /**
     * 管理员添加第一种商品类型
     * @param firstClass
     * @return
     */
    @RequestMapping("addFirstClassType.do")
    public PageVo addFirstClassType(FirstClass firstClass) {
        PageVo<Object> resultPageVo = new PageVo<>();
        if (!JudgeNull.isNull(firstClass)) {
            return adminService.addFirstClassType(firstClass);
        } else {
            resultPageVo.setCode(4001);
            resultPageVo.setMsg("传入参数为空");
            return resultPageVo;
        }
    }

    /**
     * 管理员添加第二种商品类型
     * @param secondClass
     * @return
     */
    @RequestMapping("addSecondClassType.do")
    public PageVo addSecondClassType(SecondClass secondClass) {
        PageVo<Object> resultPageVo = new PageVo<>();
        if (!JudgeNull.isNull(secondClass)) {
            return adminService.addSecondClassType(secondClass);
        } else {
            resultPageVo.setCode(4001);
            resultPageVo.setMsg("传入参数为空");
            return resultPageVo;
        }
    }


}

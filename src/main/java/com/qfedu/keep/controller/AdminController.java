package com.qfedu.keep.controller;

import com.qfedu.keep.common.util.JudgeNull;
import com.qfedu.keep.domain.FirstClass;
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

    @RequestMapping("login.do")
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
}

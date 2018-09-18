package com.qfedu.keep.controller;

import com.qfedu.keep.domain.User;
import com.qfedu.keep.result.Result;
import com.qfedu.keep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //按照用户名登录
    @RequestMapping("/userloginbyusername.do")
    public Result userloginbyusername(String username, String password) {
        Result result = new Result();
        User user = userService.loginByUsername(username, password);
        if (user != null) {
            result.setMsg("登录成功");
            result.setCode(1);
            List data = new ArrayList();
            data.add(user);
            result.setData(data);
            return result ;
        }
        result.setCode(0);
        result.setMsg("请检查您的账户或者密码");
        return result ;
    }
    //按照手机号登录
    @RequestMapping("/userloginbyphone.do")
    public Result userloginbyphone(String phone,String password) {
        Result result = new Result();
        User user = userService.loginByPhone(phone, password);
        if (user != null) {
            result.setMsg("登录成功");
            result.setCode(1);
            List data = new ArrayList();
            data.add(user);
            result.setData(data);
            return result;
        }
        result.setCode(0);
        result.setMsg("请检查您的手机号或者密码");
        return result;
    }
    //用户注册
}

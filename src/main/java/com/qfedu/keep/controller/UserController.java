package com.qfedu.keep.controller;

import com.qfedu.keep.common.RedisUtil;
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
    @Autowired
    private RedisUtil redisUtil;

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
    @RequestMapping("/usersave.do")
    public Result usersave(User user){
        Result result = new Result();
        if (userService.save(user)) {
            result.setCode(1);
            result.setMsg("注册成功");
            return result;
        }
        result.setMsg("注册失败，稍后再试");
        result.setCode(1);
        return result;
    }
    //检查手机号已注册
    @RequestMapping("/checkphone.do")
    public Result checkPhone(String phone) {
        Result result = new Result();
        if (userService.haveByPhone(phone)){
            result.setCode(0);
            result.setMsg("手机号已注册");
            return result;
        }
        result.setCode(1);
        result.setMsg("手机号可用");
        return result;
    }
    //检查名字是否已存在
    @RequestMapping("/checkname.do")
    public Result checkName(String username) {
        Result result = new Result();
        if (userService.haveByUsername(username)){
            result.setCode(0);
            result.setMsg("用户名已被用");
            return result;
        }
        result.setCode(1);
        result.setMsg("用户名可用");
        return result;
    }
    //修改用户名
    @RequestMapping("/modify.do")
    public Result modify(User user){
        Result result = new Result();
        if (userService.modifyName(user)) {
            result.setCode(1);
            result.setMsg("修改用户名成功");
            return result;
        } result.setCode(0);
        result.setMsg("修改失败，请更换用户名");
        return result;
    }
}

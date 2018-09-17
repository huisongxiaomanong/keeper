package com.qfedu.keep.controller;

import com.qfedu.keep.service.UserService;
import com.qfedu.keep.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

//    @RequestMapping("userlogin")
//    public PageVo userLogin(String username,String password) {
//        return ;
//    }

}

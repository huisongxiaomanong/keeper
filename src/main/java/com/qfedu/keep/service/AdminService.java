package com.qfedu.keep.service;

import com.qfedu.keep.domain.ClassOrder;
import com.qfedu.keep.domain.FirstClass;
import com.qfedu.keep.domain.SecondClass;
import com.qfedu.keep.vo.PageVo;


public interface AdminService {
    // 后台登录接口
    PageVo login (String name, String password);

    // 添加订单
    PageVo addClassOrder(ClassOrder classOrder);

    // 退出登录
    PageVo logout();

}

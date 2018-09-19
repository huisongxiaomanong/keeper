package com.qfedu.keep.service;

import com.qfedu.keep.domain.ClassOrder;
import com.qfedu.keep.domain.FirstClass;
import com.qfedu.keep.domain.SecondClass;
import com.qfedu.keep.vo.PageVo;


public interface AdminService {
    // 后台登录接口
    PageVo login (String name, String password);

    // 添加课程类别
    PageVo addFirstClassType(FirstClass firstClass);

    PageVo showFirstClassType();

    PageVo addSecondClassType(SecondClass secondClass);

    // 删除课程类别
    PageVo deleteClassType(String name, int level);

    // 修改课程类别
    PageVo modifyClassType(String name, int level);

    // 查询课程类别
    PageVo queryClassType(String name, int level);

    // 添加订单
    PageVo addClassOrder(ClassOrder classOrder);

}

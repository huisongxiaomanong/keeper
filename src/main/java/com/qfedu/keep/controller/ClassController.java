package com.qfedu.keep.controller;

import com.qfedu.keep.common.util.JudgeNull;
import com.qfedu.keep.domain.ClassDetail;
import com.qfedu.keep.domain.FirstClass;
import com.qfedu.keep.domain.SecondClass;
import com.qfedu.keep.service.ClassService;
import com.qfedu.keep.service.ClassTypeService;
import com.qfedu.keep.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 该controller主要实现课程详情的增删改查等操作
@RestController
public class ClassController {

    @Autowired
    ClassService classService;

    // 课程的增加
    @RequestMapping("addClassDetail.do")
    public PageVo addClassDetail() {
        // list《step》
        // list《question》
        // 属性值：breath、feeling、classDetailImgLit、classDetailImgdes

    }


    // 课程的修改

    // 课程的删除

    // 课程的查询

}

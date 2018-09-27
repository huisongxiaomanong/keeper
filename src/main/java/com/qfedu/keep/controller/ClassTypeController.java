package com.qfedu.keep.controller;

import com.qfedu.keep.common.util.JudgeNull;
import com.qfedu.keep.domain.FirstClass;
import com.qfedu.keep.domain.SecondClass;
import com.qfedu.keep.service.ClassTypeService;
import com.qfedu.keep.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 该controller主要实现的就是课程类型的增删改查
@RestController
public class ClassTypeController {
    @Autowired
    ClassTypeService classTypeService;

    // 查询以及课程类型
    @RequestMapping("queryFirstClassType.do")
    public PageVo queryFirstClassType() {
        return classTypeService.showFirstClassType();
    }

    // 查询二级课程类型
    @RequestMapping("querySecondClassType.do")
    public PageVo querySecondClassType(String fid) {
        if (!JudgeNull.isNull(fid)) {
            return classTypeService.showSecondClassType(fid);
        } else {
            return PageVo.creatJson(5000, "传入参数为空", null);
        }
    }

}

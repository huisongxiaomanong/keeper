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
    /**
     * 管理员添加第一种商品类型
     * @param firstClass
     * @return
     */
    @RequestMapping("addFirstClassType.do")
    public PageVo addFirstClassType(FirstClass firstClass) {
        PageVo<Object> resultPageVo = new PageVo<>();
        if (!JudgeNull.isNull(firstClass)) {
            return classTypeService.addFirstClassType(firstClass);
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
            return classTypeService.addSecondClassType(secondClass);
        } else {
            resultPageVo.setCode(4001);
            resultPageVo.setMsg("传入参数为空");
            return resultPageVo;
        }
    }

    // 删除操作
    @RequestMapping("deleteFirstClassType.do")
    public PageVo deleteFirstClassType(String id) {

        if (!JudgeNull.isNull(id)) {
            return classTypeService.deleteClassType(id, 1);
        } else {
            return PageVo.creatJson(4001, "传入参数为空", null);
        }
    }

    @RequestMapping("deleteSecondClassType.do")
    public PageVo deleteSecondClassType(String id) {

        if (!JudgeNull.isNull(id)) {
            return classTypeService.deleteClassType(id, 2);
        } else {
            return PageVo.creatJson(4001, "传入参数为空", null);
        }
    }

    @RequestMapping("modifyFirstClassType.do")
    public PageVo modifyFirstClassType(FirstClass firstClass) {
        if (!JudgeNull.isNull(firstClass.getName()) && !JudgeNull.isNull(firstClass.getId())) {
            return classTypeService.modifyFirstClassType(firstClass);
        } else {
            return PageVo.creatJson(4001, "传入参数为空", null);

        }
    }

    @RequestMapping("modifySecondClassType.do")
    public PageVo modifySecondClassType(SecondClass secondClass) {
        if (!JudgeNull.isNull(secondClass.getName()) && !JudgeNull.isNull(secondClass.getFid())) {
            return classTypeService.modifySecondClassType(secondClass);
        } else {
            return PageVo.creatJson(4001, "传入参数为空", null);
        }
    }

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

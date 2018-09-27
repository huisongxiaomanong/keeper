package com.qfedu.keep.controller;

import com.qfedu.keep.common.util.FDFSUtil;
import com.qfedu.keep.common.util.JudgeNull;
import com.qfedu.keep.domain.*;
import com.qfedu.keep.service.ClassService;
import com.qfedu.keep.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.ArrayList;
import java.util.List;

// 该controller主要实现课程详情的增删改查等操作
@RestController
public class ClassController {

    @Autowired
    ClassService classService;

    @Autowired
    FDFSUtil fdfsUtil;

    // 课程的查询
    @RequestMapping("queryClassDetail.do")
    public PageVo queryClassDetail(String sid) {
        if (!JudgeNull.isNull(sid)) {
            return classService.showClassDetail(sid);
        } else {
            return PageVo.creatJson(6001, "传入参数为空", null);
        }
    }
}

package com.qfedu.keep.controller;

import com.qfedu.keep.common.util.FDFSUtil;
import com.qfedu.keep.common.util.JudgeNull;
import com.qfedu.keep.domain.*;
import com.qfedu.keep.service.ClassService;
import com.qfedu.keep.service.ClassTypeService;
import com.qfedu.keep.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// 该controller主要实现课程详情的增删改查等操作
@RestController
public class ClassController {

    @Autowired
    ClassService classService;

    @Autowired
    FDFSUtil fdfsUtil;

    // 课程的增加
    @RequestMapping("addOrUpClassDetail.do")
    public PageVo addOrUpClassDetail(ClassDetail classDetail, @RequestParam("cstep") String[] csteps, @RequestParam("question") String questions,
                                     @RequestParam("solution")String solution, @RequestParam("flag")int flag,
                                     @RequestParam("questionid")int questionid, @RequestParam("stepid")int stepid) {
        // 这里要考虑前端传过来的数据类型，
        // classdetail对象的几个属性：id、name、sid、classimg、content、
        //                  breath、feeling、classDetailImgLit、 classDetailImgdes
        // 其次应该有对应的数组来对应里面的list属性值
        // list<step>
        // question
        // 考虑到前端传过来如果只是键值对，那么就要进行对象的拼接
        // 课程的添加和修改是根据传入的flag值来确认的

        if (!JudgeNull.isNull(classDetail)) {
            // 先处理cstep对象
            List<Cstep> cstepsToSave = new ArrayList<>();
            if (!JudgeNull.isNull(csteps)) {
                for (int i = 0; i < csteps.length; i++) {
                    Cstep cstep = new Cstep();
                    cstep.setCstepdid(classDetail.getId());
                    cstep.setId(stepid);
                    cstepsToSave.add(cstep);
                }
            }
            Question questionToSave = new Question();
            questionToSave.setCdid(classDetail.getId());
            questionToSave.setQuestion(questions);
            questionToSave.setSolution(solution);
            questionToSave.setId(questionid);
            classDetail.setCsteps(cstepsToSave);
            classDetail.setQuestions(questionToSave);
            PageVo resultPage = new PageVo();
            if (flag == 0) {
                resultPage = classService.addClassDetail(classDetail);
            } else {
                resultPage = classService.modifyClassDetail(classDetail);
            }
            return resultPage;
        } else {
            return PageVo.creatJson(6001, "传入参数为空", null);
        }
    }

    // 上传图片的接口
    @RequestMapping("uploadClassImg.do")
    public PageVo uploadClassImg(@RequestParam("classImgpage")CommonsMultipartFile classImgPage) throws Exception {
            String filename=classImgPage.getOriginalFilename();
            String sub=filename.substring(filename.lastIndexOf(".")+1);
            String filepath= fdfsUtil.upload_file(classImgPage.getBytes(),sub,null);
            List<String> filePaths = new ArrayList<>();
            return PageVo.creatJson(6000, "上传成功", filePaths);
    }

    @RequestMapping("uploadClassImgLit.do")
    public PageVo uploadClassImgLit(@RequestParam("ClassImgLit")CommonsMultipartFile classImgPage) throws Exception {

        String filename=classImgPage.getOriginalFilename();
        String sub=filename.substring(filename.lastIndexOf(".")+1);
        String filepath= fdfsUtil.upload_file(classImgPage.getBytes(),sub,null);
        List<String> filePaths = new ArrayList<>();
        return PageVo.creatJson(6000, "上传成功", filePaths);
    }


    // 课程的删除
    @RequestMapping("deleteClassDetail.do")
    public PageVo deleteClassDetail(String detailid) {
        if (!JudgeNull.isNull(detailid)) {
            return classService.deleteClassDetail(detailid);
        } else {
            return PageVo.creatJson(6001, "传入参数为空", null);
        }
    }
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

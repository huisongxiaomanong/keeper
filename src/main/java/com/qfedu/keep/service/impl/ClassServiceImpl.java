package com.qfedu.keep.service.impl;

import com.qfedu.keep.common.util.JudgeNull;
import com.qfedu.keep.domain.*;
import com.qfedu.keep.mapper.*;
import com.qfedu.keep.service.ClassService;
import com.qfedu.keep.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ClassServiceImpl implements ClassService {

    @Autowired
    ClassDetailMapper classDetailMapper;

    @Autowired
    CstepMapper cstepMapper;

    @Autowired
    QuestionMapper questionMapper;

    @Autowired
    UandClassMapper uandClassMapper;

    @Autowired
    ClassAchieveMapper classAchieveMapper;

    @Override
    public PageVo showClassDetail(String sid) {
        List<ClassDetail> classDetails = classDetailMapper.selectBySid(Integer.valueOf(sid));
        return PageVo.creatJson(6000, "查询成功", classDetails);
    }

    @Override
    public PageVo addClassDetail(ClassDetail classDetail) {

        // 添加事件详情表时要注意的是，这里设计到三个表的操作。
        // 这里的顺序是先添加步骤表，再添加问题表，最后添加事件的详情表，任何一个表的添加失败都会直接返回

        // 第一步：进行步骤表的添加
        List<Cstep> csteps = classDetail.getCsteps();
        if (JudgeNull.isNull(csteps)) {
            return PageVo.creatJson(6001, "传入参数为空", null);
        } else {
            for (int i = 0; i < csteps.size(); i++) {
                //
                csteps.get(i).setCstepdid(classDetail.getId());
                int insert = cstepMapper.insert(csteps.get(i));
                if (insert <= 0) {
                    return PageVo.creatJson(6001, "数据库插入失败", null);
                }
            }
        }

       // 进行问题表的添加
        Question questions = classDetail.getQuestions();

        if (JudgeNull.isNull(questions)) {
            return PageVo.creatJson(6001, "传入问题参数为空", null);
        } else {
                int insert = questionMapper.insert(questions);
                if (insert <= 0) {
                    return PageVo.creatJson(6001, "添加问题失败", null);
                }
        }

        // 最后进行事件详情的添加
        int insert = classDetailMapper.insert(classDetail);
        if (insert > 0) {
            return PageVo.creatJson(6000, "保存成功", null);
        } else {
            return PageVo.creatJson(6001, "保存失败", null);
        }
    }

    @Override
    public PageVo deleteClassDetail(String id) {
        int i = classDetailMapper.deleteByPrimaryKey(Integer.valueOf(id));
        if (i > 0) {
            return PageVo.creatJson(6000, "删除成功", null);
        } else {
            return PageVo.creatJson(6001, "删除失败", null);
        }
    }

    @Override
    public PageVo modifyClassDetail(ClassDetail classDetail) {
        // 修改时要修改三个表的数据，顺序为：修改question表，修改step表，修改classdetail表
        Question question = classDetail.getQuestions();
        questionMapper.updateByPrimaryKey(question);

        List<Cstep> csteps = classDetail.getCsteps();
        for (int i = 0; i < csteps.size(); i++) {
            cstepMapper.updateByPrimaryKey(csteps.get(i));
        }

        int i = classDetailMapper.updateByPrimaryKey(classDetail);
        if (i > 0) {
            return PageVo.creatJson(6000, "修改成功", null);
        } else {
            return PageVo.creatJson(6001, "修改失败", null);
        }
    }

    @Override
    public PageVo joinClass(String sid, HttpSession session) {
        User user = (User) session.getAttribute("user");
        UandClass uandClass = new UandClass();
        uandClass.setClassid(Integer.valueOf(sid));
        uandClass.setUid(user.getId());
        int insert = uandClassMapper.insert(uandClass);
        if (insert > 0) {
            return PageVo.creatJson(1000, "添加成功", null);
        } else {
            return PageVo.creatJson(1001, "添加失败", null);
        }
    }

    @Override
    public PageVo addClassAchieve(ClassAchieve classAchieve) {
        int insert = classAchieveMapper.insert(classAchieve);
        if (insert > 0) {
            return PageVo.creatJson(1000, "参加成功", null);
        } else {
            return PageVo.creatJson(1001, "参加失败", null);
        }
    }

    @Override
    public PageVo showClassAchieve(String cid) {
        List<ClassAchieve> classAchieves = classAchieveMapper.selectByClassid(Integer.valueOf(cid));
        return PageVo.creatJson(1000, "查询成功", classAchieves);
    }
}

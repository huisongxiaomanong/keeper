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

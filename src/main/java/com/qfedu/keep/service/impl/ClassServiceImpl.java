package com.qfedu.keep.service.impl;

import com.qfedu.keep.domain.ClassAchieve;
import com.qfedu.keep.domain.ClassDetail;
import com.qfedu.keep.mapper.ClassDetailMapper;
import com.qfedu.keep.service.ClassService;
import com.qfedu.keep.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ClassServiceImpl implements ClassService {

    @Autowired
    ClassDetailMapper classDetailMapper;

    @Override
    public PageVo showClassDetail(String sid) {
        ClassDetail classDetail = classDetailMapper.selectByPrimaryKey(Integer.valueOf(sid));
        List<ClassDetail> classDetails = new ArrayList<>();
        classDetails.add(classDetail);
        return PageVo.creatJson(6000, "查询成功", classDetails);
    }

    @Override
    public PageVo addClassDetail(ClassDetail classDetail) {
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
        int i = classDetailMapper.updateByPrimaryKey(classDetail);
        if (i > 0) {
            return PageVo.creatJson(6000, "修改成功", null);
        } else {
            return PageVo.creatJson(6001, "修改失败", null);
        }
    }

    @Override
    public PageVo joinClass(String sid) {
        return null;
    }

    @Override
    public PageVo addClassAchieve(ClassAchieve classAchieve) {
        return null;
    }

    @Override
    public PageVo showClassAchieve(String sid) {
        return null;
    }
}

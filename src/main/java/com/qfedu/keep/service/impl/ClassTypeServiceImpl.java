package com.qfedu.keep.service.impl;

import com.qfedu.keep.domain.FirstClass;
import com.qfedu.keep.domain.SecondClass;
import com.qfedu.keep.mapper.FirstClassMapper;
import com.qfedu.keep.mapper.SecondClassMapper;
import com.qfedu.keep.service.ClassTypeService;
import com.qfedu.keep.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClassTypeServiceImpl implements ClassTypeService {

    @Autowired
    FirstClassMapper firstClassMapper;

    @Autowired
    SecondClassMapper secondClassMapper;

    @Override
    public PageVo addFirstClassType(FirstClass firstClass) {
        int insert = firstClassMapper.insert(firstClass);
        if (insert > 0) {
            return PageVo.creatJson(4000, "保存成功", null);
        } else {
            return PageVo.creatJson(4001, "保存失败", null);
        }
    }

    @Override
    public PageVo showFirstClassType() {

        List<FirstClass> firstClasses = firstClassMapper.selectAll();
        return PageVo.creatJson(2000, "第一种类型查询完毕", firstClasses);
    }

    @Override
    public PageVo showSecondClassType(String fid) {
        List<SecondClass> secondClasses = secondClassMapper.selectByFid(Integer.valueOf(fid));
        return PageVo.creatJson(5000, "查询结束", secondClasses);
    }

    @Override
    public PageVo addSecondClassType(SecondClass secondClass) {
        int insert = secondClassMapper.insert(secondClass);
        if (insert > 0) {
            return PageVo.creatJson(4000, "保存成功", null);
        } else {
            return PageVo.creatJson(4001, "保存失败", null);
        }
    }

    @Override
    public PageVo deleteClassType(String name, int level) {
        boolean result = false;
        if (level == 1) {
            int i = firstClassMapper.deleteByPrimaryKey(Integer.valueOf(name));
            if (i > 0) {
                result = true;
            }
        } else {
            int i = secondClassMapper.deleteByPrimaryKey(Integer.valueOf(name));
            if (i > 0) {
                result = true;
            }
        }
        if (result) {
            return PageVo.creatJson(4000, "删除成功", null);
        } else {
            return PageVo.creatJson(4001, "删除失败", null);
        }
    }

    @Override
    public PageVo modifyFirstClassType(FirstClass firstClass) {
        int i = firstClassMapper.updateByPrimaryKey(firstClass);
        if (i > 0) {
            return PageVo.creatJson(4000, "修改成功", null);
        } else {
            return PageVo.creatJson(4001, "修改失败", null);
        }

    }

    @Override
    public PageVo modifySecondClassType(SecondClass secondClass) {
        int i = secondClassMapper.updateByPrimaryKey(secondClass);
        if (i > 0) {
            return PageVo.creatJson(4000, "修改成功", null);
        } else {
            return PageVo.creatJson(4001, "修改失败", null);
        }
    }

    @Override
    public PageVo queryClassType(String name, int level) {
        return null;
    }

}

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
    public PageVo queryClassType(String name, int level) {
        return null;
    }

}

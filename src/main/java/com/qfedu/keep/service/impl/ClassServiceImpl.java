package com.qfedu.keep.service.impl;

import com.qfedu.keep.domain.ClassAchieve;
import com.qfedu.keep.service.ClassService;
import com.qfedu.keep.vo.PageVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClassServiceImpl implements ClassService {
    @Override
    public PageVo showClassType(String level) {
        return null;
    }

    @Override
    public PageVo showClassDetail(String sid) {
        return null;
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

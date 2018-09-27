package com.qfedu.keep.service;

import com.qfedu.keep.domain.FirstClass;
import com.qfedu.keep.domain.SecondClass;
import com.qfedu.keep.vo.PageVo;

public interface ClassTypeService {


    // 展示一级的类型
    PageVo showFirstClassType();

    // 展示二级的类型
    PageVo showSecondClassType(String fid);

    // 查询课程类别
    PageVo queryClassType(String name, int level);



}

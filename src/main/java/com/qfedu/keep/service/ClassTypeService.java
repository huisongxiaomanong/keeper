package com.qfedu.keep.service;

import com.qfedu.keep.domain.FirstClass;
import com.qfedu.keep.domain.SecondClass;
import com.qfedu.keep.vo.PageVo;

public interface ClassTypeService {

    // 添加课程类别
    PageVo addFirstClassType(FirstClass firstClass);

    // 展示一级的类型
    PageVo showFirstClassType();

    // 展示二级的类型
    PageVo showSecondClassType(String fid);

    PageVo addSecondClassType(SecondClass secondClass);

    // 删除课程类别
    PageVo deleteClassType(String name, int level);

    // 修改课程类别
    PageVo modifyFirstClassType(FirstClass firstClass);

    PageVo modifySecondClassType(SecondClass secondClass);

    // 查询课程类别
    PageVo queryClassType(String name, int level);



}

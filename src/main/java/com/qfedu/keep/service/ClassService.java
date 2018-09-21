package com.qfedu.keep.service;

import com.qfedu.keep.domain.ClassAchieve;
import com.qfedu.keep.domain.ClassDetail;
import com.qfedu.keep.vo.PageVo;

public interface ClassService {

    // 展示课程的具体步骤
    PageVo showClassDetail(String sid);

    // 增加课程具体步骤
    PageVo addClassDetail(ClassDetail classDetail);

    // 删除课程具体步骤
    PageVo deleteClassDetail(String id);

    // 修改课程具体步骤
    PageVo modifyClassDetail(ClassDetail classDetail);

    // 参加具体的某个课程
    PageVo joinClass(String sid);

    // 添加用户的课程成果
    PageVo addClassAchieve(ClassAchieve classAchieve);

    // 用户参加完课程的展示
    PageVo showClassAchieve(String sid);
}

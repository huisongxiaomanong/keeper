package com.qfedu.keep.mapper;

import com.qfedu.keep.domain.ClassAchieve;

public interface ClassAchieveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClassAchieve record);

    int insertSelective(ClassAchieve record);

    ClassAchieve selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClassAchieve record);

    int updateByPrimaryKey(ClassAchieve record);
}
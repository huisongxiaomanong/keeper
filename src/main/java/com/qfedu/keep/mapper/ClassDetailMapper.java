package com.qfedu.keep.mapper;

import com.qfedu.keep.domain.ClassDetail;

public interface ClassDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClassDetail record);

    int insertSelective(ClassDetail record);

    ClassDetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClassDetail record);

    int updateByPrimaryKey(ClassDetail record);
}
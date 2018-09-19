package com.qfedu.keep.mapper;

import com.qfedu.keep.domain.ClassOrder;

public interface ClassOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClassOrder record);

    int insertSelective(ClassOrder record);

    ClassOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClassOrder record);

    int updateByPrimaryKey(ClassOrder record);
}
package com.qfedu.keep.mapper;

import com.qfedu.keep.domain.SecondClass;

public interface SecondClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SecondClass record);

    int insertSelective(SecondClass record);

    SecondClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SecondClass record);

    int updateByPrimaryKey(SecondClass record);
}
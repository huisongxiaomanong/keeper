package com.qfedu.keep.mapper;

import com.qfedu.keep.domain.FirstClass;

public interface FirstClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FirstClass record);

    int insertSelective(FirstClass record);

    FirstClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FirstClass record);

    int updateByPrimaryKey(FirstClass record);
}
package com.qfedu.keep.mapper;

import com.qfedu.keep.domain.UandClass;

public interface UandClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UandClass record);

    int insertSelective(UandClass record);

    UandClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UandClass record);

    int updateByPrimaryKey(UandClass record);


}
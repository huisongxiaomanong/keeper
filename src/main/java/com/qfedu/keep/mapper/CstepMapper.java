package com.qfedu.keep.mapper;

import com.qfedu.keep.domain.Cstep;

public interface CstepMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cstep record);

    int insertSelective(Cstep record);

    Cstep selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cstep record);

    int updateByPrimaryKey(Cstep record);
}
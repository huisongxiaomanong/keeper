package com.qfedu.keep.mapper;

import com.qfedu.keep.domain.SecondClass;

import java.util.List;

public interface SecondClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SecondClass record);

    int insertSelective(SecondClass record);

    SecondClass selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SecondClass record);

    int updateByPrimaryKey(SecondClass record);

    List<SecondClass> selectByFid(int fid);
}
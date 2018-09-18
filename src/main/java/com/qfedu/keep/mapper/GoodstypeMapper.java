package com.qfedu.keep.mapper;

import com.qfedu.keep.domain.Goodstype;

public interface GoodstypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goodstype record);

    int insertSelective(Goodstype record);

    Goodstype selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goodstype record);

    int updateByPrimaryKey(Goodstype record);
}
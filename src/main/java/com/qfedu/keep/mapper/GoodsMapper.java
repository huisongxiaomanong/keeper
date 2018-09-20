package com.qfedu.keep.mapper;

import com.qfedu.keep.domain.Goods;
import com.qfedu.keep.domain.Goodstype;

import java.util.List;

public interface GoodsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> selectGoodsBygoodstype(Goodstype goodstype);
}
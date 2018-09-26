package com.qfedu.keep.mapper;

import com.qfedu.keep.domain.Goodsvideo;

public interface GoodsvideoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Goodsvideo record);

    int insertSelective(Goodsvideo record);

    Goodsvideo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goodsvideo record);

    int updateByPrimaryKey(Goodsvideo record);
    Goodsvideo selectBygoodsid(Integer id);
}
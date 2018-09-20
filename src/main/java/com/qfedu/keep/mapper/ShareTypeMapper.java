package com.qfedu.keep.mapper;

import com.qfedu.keep.domain.ShareType;

import java.util.List;

public interface ShareTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShareType record);

    int insertSelective(ShareType record);

    ShareType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ShareType record);

    int updateByPrimaryKey(ShareType record);

    List<ShareType> selectType();
}
package com.qfedu.keep.mapper;

import com.qfedu.keep.domain.Context;
import com.qfedu.keep.vo.ContextVo;

import java.util.List;

public interface ContextMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Context record);

    int insertSelective(Context record);

    Context selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Context record);

    int updateByPrimaryKeyWithBLOBs(Context record);

    int updateByPrimaryKey(Context record);

    List<ContextVo> selectByType(int id);
}
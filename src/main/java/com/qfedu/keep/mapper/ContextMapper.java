package com.qfedu.keep.mapper;

import com.qfedu.keep.domain.Context;
import com.qfedu.keep.vo.ContextVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ContextMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Context record);

    int insertSelective(Context record);

    Context selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Context record);

    int updateByPrimaryKeyWithBLOBs(Context record);

    int updateByPrimaryKey(Context record);

    List<ContextVo> selectByType(int tid, @Param("index") int index,@Param("count") int cunt);
    int selectCountByType(int tid);

    List<ContextVo> selectByuid(int uid,@Param("index") int index,@Param("count") int cunt);
    int selectCountByUid(int uid);
}
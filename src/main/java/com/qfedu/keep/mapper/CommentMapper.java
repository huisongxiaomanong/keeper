package com.qfedu.keep.mapper;

import com.qfedu.keep.domain.Comment;
import com.qfedu.keep.vo.CommentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);

    List<CommentVo>queryBySid(int sid, @Param("index") int index,@Param("count") int count);

    int selectBycount(int sid);

}
package com.qfedu.keep.mapper;

import com.qfedu.keep.domain.Photos;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PhotosMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Photos record);

    int insertSelective(Photos record);

    Photos selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Photos record);

    int updateByPrimaryKey(Photos record);

    int inserts(@Param("list")List<String> photos,@Param("sid") int sid);
}
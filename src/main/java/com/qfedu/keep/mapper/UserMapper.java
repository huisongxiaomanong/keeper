package com.qfedu.keep.mapper;

import com.qfedu.keep.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


public interface UserMapper {
    User selectByName(String username);
    User selectByPhone(String phone);

    int insert(User user);
//    boolean haveName(String username);
//    boolean havePhone(String phone);
    int updateByIdSelective(User user);

}

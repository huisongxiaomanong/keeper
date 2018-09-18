package com.qfedu.keep.mapper;

import com.qfedu.keep.domain.User;
import org.apache.ibatis.annotations.Mapper;


public interface UserMapper {
    User selectByName(String username);
    User selectByPhone(String phone);
}

package com.qfedu.keep.mapper;

import com.qfedu.keep.domain.User;

public interface UserMapper {
    User selectByName(String username);
    User selectByPhone(String username);
}

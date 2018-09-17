package com.qfedu.keep.service.impl;

import com.qfedu.keep.domain.User;
import com.qfedu.keep.mapper.UserMapper;
import com.qfedu.keep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User loginByUsername(String username, String password) {
        User user = userMapper.selectByName(username);
        if (user != null) {
            if (Objects.equals(user.getPassword(),password)) {
                return user;
            }
            return null;
        }
        return null;
    }

    @Override
    public User loginByPhone(String phone, String password) {
        User user = userMapper.selectByName(phone);
        if (user != null) {
            if (Objects.equals(user.getPassword(),password)) {
                return user;
            }
            return null;
        }
        return null;
    }
}

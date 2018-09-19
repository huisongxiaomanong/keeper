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
    public boolean modifyName(String username, int id) {
        return userMapper.setName(username,id) > 0;
    }

    @Override
    public boolean haveByUsername(String username) {
        User user = userMapper.selectByName(username);
        if (user != null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean haveByPhone(String phone) {
        return userMapper.selectByPhone(phone) != null;
    }

    @Override
    public boolean save(User user) {
        return userMapper.insert(user) > 0;
    }

    @Override
    public User loginByUsername(String username, String password) {
        User user = userMapper.selectByName(username);
        if (user != null) {
            if (Objects.equals(user.getPassword(),password)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User loginByPhone(String phone, String password) {
        User user = userMapper.selectByPhone(phone);
        if (user != null) {
            if (Objects.equals(user.getPassword(),password)) {
                return user;
            }
        }
        return null;
    }
}

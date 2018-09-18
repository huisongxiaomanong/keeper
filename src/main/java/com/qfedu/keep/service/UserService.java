package com.qfedu.keep.service;

import com.qfedu.keep.domain.User;

public interface UserService {
    public User loginByUsername(String username, String password);
    public User loginByPhone(String phone,String password);
}

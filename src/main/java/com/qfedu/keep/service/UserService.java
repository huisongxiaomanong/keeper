package com.qfedu.keep.service;

import com.qfedu.keep.domain.User;

public interface UserService {
    public User loginByUsername(String username, String password);
    public User loginByPhone(String phone, String password);
    public boolean save(User user);

    public boolean haveByUsername(String username);
    public boolean haveByPhone(String phone);

    public boolean modifyName(User user);
}

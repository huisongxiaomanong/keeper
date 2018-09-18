package com.qfedu.keep.service;

import com.qfedu.keep.vo.PageVo;

public interface AdminService {
    // 后台接口
    PageVo login (String name, String password);
}

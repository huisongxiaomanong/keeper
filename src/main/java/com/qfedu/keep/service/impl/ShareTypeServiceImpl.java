package com.qfedu.keep.service.impl;

import com.qfedu.keep.domain.ShareType;
import com.qfedu.keep.mapper.ShareTypeMapper;
import com.qfedu.keep.service.ShareTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ShareTypeServiceImpl implements ShareTypeService {
    @Autowired
    private ShareTypeMapper mapper;
    @Override
    public List<ShareType> queryAll() {
        return mapper.selectType();
    }
}

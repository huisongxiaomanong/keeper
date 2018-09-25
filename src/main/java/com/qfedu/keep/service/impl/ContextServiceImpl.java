package com.qfedu.keep.service.impl;

import com.qfedu.keep.domain.Context;
import com.qfedu.keep.mapper.ContextMapper;
import com.qfedu.keep.service.ContextService;
import com.qfedu.keep.vo.ContextVo;
import com.qfedu.keep.vo.PageVo_Mx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * ${MaXin} on
 * 2018/9/20 21:05
 */
@Service
@Transactional
public class ContextServiceImpl implements ContextService {
    @Autowired
    private  ContextMapper mapper;
    @Override
    public boolean insertContext(Context context) {

        return mapper.insert(context)>0;
    }

    @Override
    public PageVo_Mx<ContextVo> queryBytid(int tid, int page, int limit) {
        int index=(page-1)*limit;

        return new PageVo_Mx<>(mapper.selectCountByType(tid),mapper.selectByType(tid, index, limit));
    }

    @Override
    public PageVo_Mx<ContextVo> queryByuid(int uid, int page, int limit) {
        int index=(page-1)*limit;
        return new PageVo_Mx<>(mapper.selectCountByUid(uid),mapper.selectByuid(uid, page, limit));
    }



}

package com.qfedu.keep.service.impl;


import com.qfedu.keep.domain.Goodstype;
import com.qfedu.keep.mapper.GoodstypeMapper;
import com.qfedu.keep.service.GoodstypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GoodstypeServiceImpl implements GoodstypeService {
    @Autowired
    private GoodstypeMapper goodstypeMapper;

    @Override
    public boolean saveGoodstype(Goodstype goodstype) {

        return goodstypeMapper.insertSelective(goodstype) > 0 ? true : false;
    }

    @Override
    public Goodstype queryByID(int id) {
        return goodstypeMapper.selectByPrimaryKey(id);
    }
}

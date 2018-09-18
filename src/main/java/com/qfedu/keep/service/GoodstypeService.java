package com.qfedu.keep.service;

import com.qfedu.keep.domain.Goodstype;

public interface GoodstypeService {
    boolean saveGoodstype(Goodstype goodstype);
    Goodstype queryByID(int id);
}

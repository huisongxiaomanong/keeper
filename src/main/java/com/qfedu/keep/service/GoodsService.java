package com.qfedu.keep.service;

import com.qfedu.keep.domain.Goods;
import com.qfedu.keep.domain.Goodstype;

import java.util.List;

public interface GoodsService {
    boolean saveGoods(Goods goods);
    List<Goods> queryByGoodstype(Goodstype goodstype);
}

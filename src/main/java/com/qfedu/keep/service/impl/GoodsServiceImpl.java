package com.qfedu.keep.service.impl;

import com.qfedu.keep.domain.Goods;
import com.qfedu.keep.domain.Goodstype;
import com.qfedu.keep.mapper.GoodsMapper;
import com.qfedu.keep.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @project:keeper
 * @description:商品的service实现类
 * @author:刘飞跃
 * @create:2018年09月19日22点12
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    /*
     * @Description:
     * @Author: 刘飞跃
     * @Date: 2018/9/19
     * @Param: [goods] 前端传过来的商品类型（name=type）
     * @Return: boolean 如果添加成功返回true
     */
    @Override
    public boolean saveGoods(Goods goods) {
        return goodsMapper.insertSelective(goods) > 0;
    }
    /*
     * @Description:
     * @Author: 刘飞跃
     * @Date: 2018/9/19
     * @Param: [goodstype] 前端传入的商品类型（name=type）
     * @Return: java.util.List<com.qfedu.keep.domain.Goods>
     *     同类型的所有商品
     */
    @Override
    public List<Goods> queryByGoodstype(Goodstype goodstype) {

        return goodsMapper.selectGoodsBygoodstype(goodstype);
    }
}

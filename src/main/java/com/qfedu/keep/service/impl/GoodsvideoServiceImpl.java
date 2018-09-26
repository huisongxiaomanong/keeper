package com.qfedu.keep.service.impl;

import com.qfedu.keep.domain.Goodsvideo;
import com.qfedu.keep.mapper.GoodsvideoMapper;
import com.qfedu.keep.service.GoodsvideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @project:keeper
 * @description:根据goodsid查询相应的视频的service
 * @author:刘飞跃
 * @create:2018年09月20日17点24
 */
@Service
@Transactional
public class GoodsvideoServiceImpl  implements GoodsvideoService {
    @Autowired
    private GoodsvideoMapper goodsvideoMapper ;
    @Override
    public Goodsvideo queryGoodsvideoByGoodsid(int id) {
        return goodsvideoMapper.selectBygoodsid(id);
    }
}

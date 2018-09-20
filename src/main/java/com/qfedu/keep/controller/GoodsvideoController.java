package com.qfedu.keep.controller;

import com.qfedu.keep.domain.Goods;
import com.qfedu.keep.domain.Goodsvideo;
import com.qfedu.keep.service.GoodsvideoService;
import com.qfedu.keep.vo.V;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @project:keeper
 * @description:根据商品id 查询相对性的视频的路径
 * @author:刘飞跃
 * @create:2018年09月20日17点34
 */
@Controller
public class GoodsvideoController {
    @Autowired
    private GoodsvideoService goodsvideoService;
    /*
     * @Description:
     * @Author: 刘飞跃
     * @Date: 2018/9/20
     * @Param: id商品的id.        name=id
     * @Return: com.qfedu.keep.vo.V<com.qfedu.keep.domain.Goodsvideo>V的code  0表示查询异常 1表示查询正常。
     */
    @ResponseBody
    @RequestMapping("querygoodsvideobyID.do")
    public V<Goodsvideo> querygoodsvideobyID(int id) {
        Goodsvideo goodsvideo = goodsvideoService.queryGoodsvideoByGoodsid(id);
        if (goodsvideo != null) {
            V<Goodsvideo> objectV = new V<>();
            objectV.setData(goodsvideo);
            objectV.setCode(1);
            objectV.setMsg("查询商品视频正常");
            return objectV;
        }
        return V.setError(0, "所传的参数异常");

    }
}

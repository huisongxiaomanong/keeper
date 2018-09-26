package com.qfedu.keep.controller;

import com.qfedu.keep.domain.Goods;
import com.qfedu.keep.domain.Goodstype;
import com.qfedu.keep.service.GoodsService;
import com.qfedu.keep.vo.LiuVo;
import com.qfedu.keep.vo.V;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @project:keeper
 * @description:商品Controller
 * @author:刘飞跃
 * @create:2018年09月19日22点24
 */
@Controller
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    /*
     * @Description:
     * @Author: 刘飞跃
     * @Date: 2018/9/19
     * @Param: [goods] 前端传过来的goods对象属性参数
     * @Return: com.qfedu.keep.vo.V
     */
    @RequestMapping("savenewgoods.do")
    @ResponseBody
    public V savenewgoods(Goods goods) {
        return goodsService.saveGoods(goods) ? V.setOk(1, "添加商品成功") : V.setError(0, "添加商品失败");
    }

    /*
     * @Description:
     * @Author: 刘飞跃
     * @Date: 2018/9/20
     * @Param: [goodstype] 根据前端传来的商品类型组合成Goodstyp对象（name=type）
     * @Return: com.qfedu.keep.vo.LiuVo返回基本包装类LiyVo code=0代表查询失败code=1代表正常查询返回。
     */
    @RequestMapping("queryBygoodtype.do")
    @ResponseBody
    public LiuVo queryBygoodtype(Goodstype goodstype) {
        if (goodstype == null)
            return LiuVo.setError(0, "根据商品类型查询商品失败", 0);

        List<Goods> goods = goodsService.queryByGoodstype(goodstype);
        if (goods.isEmpty() || goods == null)
            return LiuVo.setError(0, "根据商品类型查询商品失败", 0);
        LiuVo<Goods> vo = new LiuVo();
        System.out.println(goods);
        vo.setCode(1);
        vo.setMsg("成功");
        vo.setDatas(goods);
        vo.setCount(goods.size());
        return vo;
    }
}

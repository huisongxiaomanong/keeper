package com.qfedu.keep.controller;

import com.qfedu.keep.domain.Goodstype;
import com.qfedu.keep.service.impl.GoodstypeServiceImpl;
import com.qfedu.keep.vo.V;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GoodstypeController {
    @Autowired
    private GoodstypeServiceImpl goodstypeService;
    @RequestMapping(value = "savegoodstype.do")
    @ResponseBody
    public V<Goodstype> save(Goodstype goodstype){
        System.out.println(goodstype.getType());
        return goodstypeService.saveGoodstype(goodstype)?V.setOk(1,"添加商品类型成功"):V.setError(0,"添加商品类型失败");
    }
    @RequestMapping("querygoodstype.do")
    @ResponseBody
    public V<Goodstype> query(int id){
        Goodstype goodstype = goodstypeService.queryByID(id);
        V<Goodstype> goodstypeV = new V<>();
        goodstypeV.setMsg("chenggong");
        goodstypeV.setCode(1);
        goodstypeV.setData(goodstype);
        return goodstypeV;
    }
}

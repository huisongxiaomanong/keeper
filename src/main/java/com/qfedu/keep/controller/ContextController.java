package com.qfedu.keep.controller;

import com.qfedu.keep.service.ContextService;
import com.qfedu.keep.vo.ContextVo;
import com.qfedu.keep.vo.PageVo_Mx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ${MaXin} on
 * 2018/9/20 22:15
 */
@Controller
public class ContextController {
    @Autowired
    private ContextService service;
    @RequestMapping("querybytype.do")
    public PageVo_Mx<ContextVo> queryByTid(int tid,int page,int limit){
            return service.queryBytid(tid, page, limit);
    }
    @RequestMapping("queryByUid.do")
    public PageVo_Mx<ContextVo>queryByUid(int uid,int page,int limit){
        return service.queryByuid(uid, page, limit);
    }



}

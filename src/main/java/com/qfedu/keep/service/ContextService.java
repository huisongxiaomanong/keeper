package com.qfedu.keep.service;

import com.qfedu.keep.domain.Context;
import com.qfedu.keep.vo.ContextVo;
import com.qfedu.keep.vo.PageVo_Mx;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * ${MaXin} on
 * 2018/9/20 20:36
 */
public interface ContextService {
    //添加帖子
    boolean insertContext(Context context);
    //根据类型查找帖子
    PageVo_Mx<ContextVo> queryBytid(int tid, int page, int limit);
    //查看自己发的帖子
    PageVo_Mx<ContextVo> queryByuid(int uid,int page,int limit);
}

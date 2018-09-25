package com.qfedu.keep.service;

import com.qfedu.keep.domain.Comment;

import com.qfedu.keep.vo.CommentVo;
import com.qfedu.keep.vo.PageVo_Mx;



public interface CommentService {
    boolean insert(Comment comment);

    PageVo_Mx<CommentVo> queryBySid(int sid, int page, int limit);
}

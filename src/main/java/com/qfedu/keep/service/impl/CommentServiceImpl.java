package com.qfedu.keep.service.impl;

import com.qfedu.keep.domain.Comment;
import com.qfedu.keep.mapper.CommentMapper;
import com.qfedu.keep.service.CommentService;
import com.qfedu.keep.vo.CommentVo;
import com.qfedu.keep.vo.PageVo_Mx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper mapper;
    @Override
    public boolean insert(Comment comment) {
        return mapper.insert(comment)>0;
    }

    @Override
    public PageVo_Mx<CommentVo> queryBySid(int sid, int page, int limit) {
        int index = (page-1)*limit;
        return new PageVo_Mx<>(mapper.selectBycount(sid),mapper.queryBySid(sid,index,limit));
    }


}

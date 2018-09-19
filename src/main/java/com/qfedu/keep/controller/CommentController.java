package com.qfedu.keep.controller;

import com.qfedu.keep.domain.Comment;
import com.qfedu.keep.domain.User;
import com.qfedu.keep.service.CommentService;
import com.qfedu.keep.vo.CommentVo;
import com.qfedu.keep.vo.PageVo;
import com.qfedu.keep.vo.PageVo_Mx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//留言
@Controller
public class CommentController {
    @Autowired
    private CommentService service;
    //留言新增
    public void insert(Comment comment, HttpServletResponse response,HttpSession session) throws IOException {
           //获取当前用户的id
            User user = (User) session.getAttribute("user");
            int id = user.getId();
            comment.setUid(id);
        if (service.insert(comment)){

            response.getWriter().print("成了 实在不知道写啥啊");
        }else {
            response.getWriter().print("gg了");
        }
    }
    //相对应文章留言展示 同时查出留言的名字
    public PageVo_Mx<CommentVo> queryBySid(int sid,int page,int limit){
        return service.queryBySid(sid,page,limit);
    }

}

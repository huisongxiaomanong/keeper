package com.qfedu.keep.controller;

import com.qfedu.keep.common.result.R;
import com.qfedu.keep.common.util.FDFSUtil;
import com.qfedu.keep.domain.Context;
import com.qfedu.keep.mapper.PhotosMapper;
import com.qfedu.keep.service.ContextService;
import com.qfedu.keep.vo.ContextVo;
import com.qfedu.keep.vo.PageVo_Mx;
import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ${MaXin} on
 * 2018/9/20 22:15
 */
@Controller
public class ContextController {
    @Autowired
    private ContextService service;


    String fn  = "D:\\keeper/src/main/resources/fdfs_client.conf";
    String url="47.98.187.110/";
    @PostMapping("/contextsave.do")
    public R insert(Context context, @RequestParam("picurl") MultipartFile[] files, HttpSession session) throws Exception {
              //  int uid = (int) session.getAttribute("user");
              //  context.setUid(uid);

             service.insertContext(context);
        ClientGlobal.init(fn);
        TrackerClient trackerClient = new TrackerClient();
        //跟踪节点---服务器
        System.out.println(trackerClient==null ? "null trackerClient" : "OK!");

        TrackerServer trackerServer=trackerClient.getConnection();
        System.out.println(trackerServer==null ? "null trackerClient" : "OK!");
        //存储节点--服务器
        StorageServer storageServer=null;
        //存储节点---客户端
        StorageClient storageClient=new StorageClient(trackerServer,storageServer);
        for (MultipartFile file: files) {
           String extName=file.getOriginalFilename().split("\\.")[1];
           byte[] bytes = file.getBytes();
           String [] res =storageClient.upload_appender_file(bytes,extName,null);
           String img = res[0]+"/"+res[1];
            System.out.println("_________>"+context.getId());
            int sid = context.getId();
            service.Photoinsert(url+img,sid);

        }
            return new R(1,"上传成功");
    }

    @RequestMapping("querybytype.do")
    public PageVo_Mx<ContextVo> queryByTid(int tid,int page,int limit){
            return service.queryBytid(tid, page, limit);
    }
    @RequestMapping("queryByUid.do")
    public PageVo_Mx<ContextVo>queryByUid(int uid,int page,int limit){
        return service.queryByuid(uid, page, limit);
    }

}

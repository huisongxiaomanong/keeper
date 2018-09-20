package com.qfedu.keep.controller;

import com.qfedu.keep.domain.ShareType;
import com.qfedu.keep.service.ShareTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ShareTypeController {
    @Autowired
    private ShareTypeService service;

    public List<ShareType> queryType(){
        return service.queryAll();
    }

}

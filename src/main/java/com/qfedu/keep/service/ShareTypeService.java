package com.qfedu.keep.service;

import com.qfedu.keep.domain.ShareType;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ShareTypeService {
    List<ShareType> queryAll();
}

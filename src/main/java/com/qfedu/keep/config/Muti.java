package com.qfedu.keep.config;


import com.qfedu.keep.common.util.FDFSUtil;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.MultipartConfigElement;

@Configuration

public class Muti{
    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("102400KB");
        factory.setMaxRequestSize("1024000KB");
        return factory.createMultipartConfig();
    }

    @Bean
    public FDFSUtil getFdfsUtil() throws Exception {
        return new FDFSUtil("classpath:fdfs_client.conf");
    }
}

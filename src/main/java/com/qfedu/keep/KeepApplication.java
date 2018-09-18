package com.qfedu.keep;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.qfedu.keep.mapper")
public class KeepApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeepApplication.class, args);
    }
}

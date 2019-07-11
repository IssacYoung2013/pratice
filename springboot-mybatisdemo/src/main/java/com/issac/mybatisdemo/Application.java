package com.issac.mybatisdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement // 开启事务
@EnableCaching // 开启缓存
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}

package com.zhang.supermarket_manage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@MapperScan("com.zhang.supermarket_manage.mapper")
@SpringBootApplication
public class SupermarkManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupermarkManageApplication.class, args);
    }

}

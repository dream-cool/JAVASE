package com.http.httptest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@MapperScan(basePackages = {"com.http.httptest.mapper"})
@SpringBootApplication
public class HttptestApplication {

    public static void main(String[] args) {
        SpringApplication.run(HttptestApplication.class, args);
    }

}

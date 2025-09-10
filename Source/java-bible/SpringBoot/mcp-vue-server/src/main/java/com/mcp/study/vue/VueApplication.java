package com.mcp.study.vue;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: KG
 * @description:
 * @date: Created in 21:55 2022/5/20
 * @modified by:
 */
@SpringBootApplication
@MapperScan(basePackages = "com.mcp.study.vue.mapper")
public class VueApplication {
    public static void main(String[] args) {
        SpringApplication.run(VueApplication.class, args);
    }
}

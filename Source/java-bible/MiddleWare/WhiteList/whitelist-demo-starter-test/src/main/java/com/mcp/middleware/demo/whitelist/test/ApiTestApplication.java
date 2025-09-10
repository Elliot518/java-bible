package com.mcp.middleware.demo.whitelist.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Create by KG
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.mcp.middleware.*"})
public class ApiTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiTestApplication.class, args);
    }

}

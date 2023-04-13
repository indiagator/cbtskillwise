package com.cbt.cbtskillwise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CbtskillwiseApplication {

    public static void main(String[] args) {
        SpringApplication.run(CbtskillwiseApplication.class, args);
    }

}

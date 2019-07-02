package com.aigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DeptConsumer_APP {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_APP.class,args);
    }
}
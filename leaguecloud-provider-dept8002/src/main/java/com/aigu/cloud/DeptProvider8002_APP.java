package com.aigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient   //申明是微服务客户端
public class DeptProvider8002_APP {

    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8002_APP.class,args);
    }
}
